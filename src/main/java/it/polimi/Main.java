package it.polimi;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class Main {
        public static void main(String args[]) throws IOException {
            Scanner in = new Scanner(System.in);
            System.out.println("Press 1 for Server, 2 for Client");
            int selection = parseInt(in.nextLine());
            
            if (selection == 1) {
                ServerApp.main(null);
            } else if (selection == 2) {
                System.out.println("Enter IP Address of the Server");
                String IPAddress = in.nextLine();
                String[] arguments = new String[2];
                arguments[0] = "--server-ip:" + IPAddress;
                System.out.println("Press 1 for Textual UI, 2 for Graphical UI");
                int UI_Selection = parseInt(in.nextLine());
                if(UI_Selection == 1){
                    arguments[1] = "--client-type:tui";
                }
                else if(UI_Selection == 2){
                    arguments[1] = "--client-type:gui";
                }
                else{
                    System.out.println("ERROR");
                    exit(0);
                }
                ClientApp.main(arguments);
            } else {
                System.out.println("ERROR");
            }
        }

}
