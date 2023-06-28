package it.polimi.server;

import it.polimi.observer.Observer;

public interface ClientConnection {
    void closeConnection(String closingMessage);

    void addObserver(Observer<String> observer);

    void asyncSend(Object message);
}
