package it.polimi.client;

import it.polimi.model.GameView;
import it.polimi.model.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientGUI extends Client{
    public ClientGUI(String ip, int port){
        super(ip, port);
    }
}
