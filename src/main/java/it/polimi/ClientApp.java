package it.polimi;

import it.polimi.client.Client;
import it.polimi.client.ClientGUI;
import it.polimi.client.ClientTUI;

import java.io.IOException;

public class ClientApp {
    public static void main(String[] args){

        String ip;
        Client client;

        //the args should be written in this way, otherwise an Exception will be thrown: --server-ip:000.0.0.0 --client-type:tui

        if(args.length == 1 && args[0].startsWith("--client-type")){
            ip = new String("127.0.0.1");
            if(args[0].equals("--client-type:tui")){
                client = new ClientTUI(ip, 12345);
            }
            else if(args[0].equals("--client-type:gui")){
                client = new ClientGUI(ip, 12345);
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        else{
            throw new IllegalArgumentException();
        }

        try{
            client.run();
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
