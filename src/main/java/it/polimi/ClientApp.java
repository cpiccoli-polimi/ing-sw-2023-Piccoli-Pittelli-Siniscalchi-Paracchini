package it.polimi;

import it.polimi.client.ClientGUI;
import it.polimi.client.ClientTUI;

import java.io.IOException;

/**
 * ClientApp class is the one that runs on client
 * side during the game
 *
 * @author Nicola Siniscalchi
 */
public class ClientApp {
    public static void main(String[] args){

        String ip;

        //the args should be written in this way, otherwise an Exception will be thrown: --server-ip:000.0.0.0 --client-type:tui

        if(args.length == 2 && args[0].startsWith("--server-ip") && args[1].startsWith("--client-type")){
            ip = new String(args[0].substring(12));
            if(args[1].equals("--client-type:tui")){
                ClientTUI client = new ClientTUI(ip, 12345);
                try{
                    client.run();
                }
                catch(IOException e){
                    System.err.println(e.getMessage());
                }
            }
            else if(args[1].equals("--client-type:gui")){

                ClientGUI client = new ClientGUI();
                String[] clientArgs = new String[2];
                clientArgs[0] = new String(ip);
                clientArgs[1] = new String(String.valueOf(12345));
                client.main(clientArgs);
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else{
            throw new IllegalArgumentException();
        }

    }
}
