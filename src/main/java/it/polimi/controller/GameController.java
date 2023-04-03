package it.polimi.controller;

import it.polimi.model.Bookshelf;
import it.polimi.model.Game;
import it.polimi.model.PersonalGoalCard;
import it.polimi.model.Player;

import java.util.HashMap;
import java.util.Map;

public class GameController {
    public final Game model;
    public GameController(Game model){
        this.model=model;
    }
    private Game GetModel() {
        return this.model;
    }
    private void SaveNickname(String nickname, int commonGoalsNumber) {
        Player player = new Player(nickname,commonGoalsNumber);
        Player[] table = model.getTable();
        for(int i=0;i<4;i++){
            if (table[i] == null){
                model.setTable(player,i);
                break;
            }
        }
    }
    private void CountPersonalGoalsPoints() {
        // Get all the players
        Player[] table = model.getTable();
        // For each of them count points
        for(int i=0;i< table.length;i++) {
            // Get bookshelf, personalGoal and actual points from Player
            ObjectCard[][] bookshelf = table[i].getBookshelf().getShelf();
            PersonalGoalCard personalGoal = table[i].getPersonalGoal();
            int points = table[i].getPoints();
            // Scan through every row and columns: if two cells match, add one point
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (bookshelf[row][col].type == personalGoal[row][col].type) {
                        points++;
                    }
                }
            }
            table[i].setPoints(points);
        }
    }
    private void CountAdjacentItemsPoints() {
        Player[] table = model.getTable();
        for(int i=0;i< table.length;i++) {
            // Get bookshelf from each player
            ObjectCard[][] bookshelf = table[i].getBookshelf().getShelf();
            // Create hashmap to track which types has already been counted
            Map<String, Integer> countedTypes = new HashMap<>();
            // Cycle through every row and column
            for (int row = 0; row < bookshelf.length; row++) {
                for (int col = 0; col < bookshelf[row].length; col++) {
                    ObjectCard currentCard = bookshelf[row][col];
                    String currentType = currentCard.getType();
                    // If currentType has not been counted yet, we start counting from 0
                    if (!countedTypes.containsKey(currentType)) {
                        int adjacentCount = 0; // Counter for adjacent cards

                        // Cycle through every row and column adjacent to the actual card
                        for (int j = row - 1; j <= row + 1; j++) {
                            for (int k = col - 1; k <= col + 1; k++) {
                                // If adjacent slot is not empty and it is not actual card, add to count
                                if (j >= 0 && j < bookshelf.length && k >= 0 && k < bookshelf[row].length && !(j == row && k == col)) {
                                    ObjectCard adjacentCard = bookshelf[i][j];

                                    if (adjacentCard.getType().equals(currentType)) {
                                        adjacentCount++;
                                    }
                                }
                            }
                        }

                        // Add actual type to counted types map
                        countedTypes.put(currentType, adjacentCount);
                    } else {
                        // If actual type has already been counted, restart from previous count
                        // In case there are separated groups of adjacent cards from the same type
                        int previousCount = countedTypes.get(currentType);

                        // Restart from previous count
                        int adjacentCount = previousCount;
                        for (int j = row - 1; j <= row + 1; j++) {
                            for (int k = col - 1; k <= col + 1; k++) {
                                if (j >= 0 && j < bookshelf.length && k >= 0 && k < bookshelf[row].length && !(j == row && k == col)) {
                                    ObjectCard adjacentCard = bookshelf[i][j];

                                    if (adjacentCard.getType().equals(currentType)) {
                                        adjacentCount++;
                                    }
                                }
                            }
                        }

                        // Update current type count
                        countedTypes.put(currentType, adjacentCount);
                    }
                }
            }
            // Sum all types countings and put them into points attribute
            int adjacentPoints = 0;
            for (int count : countedTypes.values()) {
                adjacentPoints += count;
            }
            int points = table[i].getPoints();
            points += adjacentPoints;
            table[i].setPoints(points);
        }
    }
    private void DeclareWinner() {
        Player[] table = model.getTable();
        CountPersonalGoalsPoints();
        // Common goals points already calculated?
        CountAdjacentItemsPoints();
        // *** CREATE LEADERBOARD ***
        // Create support int array to check points
        // It contains [points][playerNumberInArray]
        int[][] points = new int[table.length][2];
        for(int i=0;i< table.length;i++){
            points[i][0] = table[i].getPoints();
            points[i][1] = i;
        }
        // Reorder array
        for (int k = 0; k < points.length; k++) {
            for (int i= 0; i < points[k].length; i++) {
                for (int j = 0; j < points[k].length; j++) {
                    if (points[k][i] < points[k][j]) {
                        int temp = points[k][i];
                        points[k][i] = points[k][j];
                        points[k][j] = temp;
                    }
                }
            }
        }
        // Copy in order into leaderboard
        // First
        model.setLeaderboard(table[points[0][1]],0);
        // Second
        model.setLeaderboard(table[points[1][1]],1);
        // Third
        model.setLeaderboard(table[points[2][1]],2);
        // Fourth
        model.setLeaderboard(table[points[3][1]],3);

        // TODO: How to notify view?
    }

}

