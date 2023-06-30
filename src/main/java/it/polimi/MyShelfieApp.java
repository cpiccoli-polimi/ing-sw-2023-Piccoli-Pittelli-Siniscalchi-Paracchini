package it.polimi;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

/**
 * Main class is the class that runs as soon
 * as the program runs, lets the user decide
 * to run the server or the client
 *
 * @author Christian Piccoli
 */
public class MyShelfieApp {
        public static void main(String args[]) throws IOException {
            Scanner in = new Scanner(System.in);
            System.out.println("Type 1 to start the Server, 2 to start a Client");
            int selection = 0;
            try{
                selection = parseInt(in.nextLine());
            } catch(NumberFormatException e){
                System.err.println("You have to insert a number!");
                System.exit(1);
            }

            if (selection == 1) {
                ServerApp.main(null);
            } else if (selection == 2) {
                System.out.println("Enter the IP Address of the Server");
                String IPAddress = in.nextLine();
                String[] arguments = new String[2];
                arguments[0] = "--server-ip:" + IPAddress;
                System.out.println("Press 1 for Textual UI, 2 for Graphical UI");
                int UI_Selection;
                try{
                    UI_Selection = parseInt(in.nextLine());
                    if(UI_Selection == 1){
                        arguments[1] = "--client-type:tui";
                    }
                    else if(UI_Selection == 2){
                        arguments[1] = "--client-type:gui";
                    }
                    else{
                        System.out.println("The number you type must be 1 or 2");
                        exit(0);
                    }
                    ClientApp.main(arguments);
                } catch(NumberFormatException e){
                    System.err.println("You have to insert a number!");
                    System.exit(1);
                }
            } else {
                System.out.println("The number you type must be 1 or 2");
                exit(0);
            }
        }

}
