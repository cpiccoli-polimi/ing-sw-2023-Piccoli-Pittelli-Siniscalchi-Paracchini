package it.polimi.server;

import it.polimi.observer.Observer;

/**
 * Interface used to connect with client
 *
 * @author Nicola Siniscalchi
 */
public interface ClientConnection {
    /**
     * Close clientConnection
     *
     * @param closingMessage message to be shown after
     *                       closing the connection
     */
    void closeConnection(String closingMessage);

    /**
     * Adds an observer
     *
     * @param observer
     */
    void addObserver(Observer<String> observer);

    /**
     * Send a message to the client
     *
     * @param message
     */
    void asyncSend(Object message);
}
