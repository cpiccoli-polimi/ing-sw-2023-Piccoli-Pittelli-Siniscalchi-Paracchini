package it.polimi.view;

import it.polimi.controller.GameController;

import java.util.Scanner;

public class GameView {
    String askNickname(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter nickname");
        String nickname = userInput.nextLine();
        int commonGoalsNumber = GameController.get
    }
}
