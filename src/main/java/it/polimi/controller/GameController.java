package it.polimi.controller;

import it.polimi.model.Bookshelf;
import it.polimi.model.Game;
import it.polimi.model.PersonalGoalCard;
import it.polimi.model.Player;

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
                table[i] = player;
                break;
            }
        }
        model.setTable(table);
    }
    private void CountPersonalGoalsPoints() {
        // Get all the players
        Player[] table = model.getTable();
        // For each of them count points
        for(int i=0;i< table.length;i++) {
            // Get bookshelf, personalGoal and actual points from Player
            Bookshelf bookshelf = table[i].getBookshelf();
            PersonalGoalCard personalGoal = table[i].getPersonalGoal();
            int points = table[i].getPoints();
            // Scan through every row and columns: if two cells match, add one point
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (bookshelf.getShelf()[row][col].type == personalGoal[row][col].type) {
                        points++;
                    }
                }
            }
            table[i].setPoints(points);
        }
    }
    private void CountAdjacentItemsPoints() {
        // How to check adjacent?
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
            points[i][1] = table[i].getPoints();
            points[i][2] = i;
        }
    }

}

