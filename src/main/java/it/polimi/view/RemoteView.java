package it.polimi.view;
import it.polimi.model.GameView;
import it.polimi.model.Player;
import it.polimi.observer.Observer;
import it.polimi.server.ClientConnection;

/**
 * RemoteView handles server-side the View
 *
 * @author Lorenzo Pittelli
 */
public class RemoteView extends View {
    private ClientConnection clientConnection;

    /**
     * Creates the RemoteView
     *
     * @param player
     * @param c the ClientConnection interface
     */
    public RemoteView(Player player, ClientConnection c){
        super(player);
        this.clientConnection=c;
        c.addObserver(new MessageReceiver());

    }

    /**
     * Sends a message to the view
     *
     * @param message the message to be shown
     */
    @Override
    protected void showMessage(Object message){ clientConnection.asyncSend(message);}


    /**
     * Updates the view, like when the other
     * player plays
     *
     * @param message the message containing the
     *                updates
     */
    @Override
    public void update(GameView message) {
        System.out.println("Received: "+message);
        try{
            clientConnection.asyncSend(message);
        }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e){
            clientConnection.asyncSend("Error!");
        }

    }

    /**
     * Receives message from the view and
     * updates the view
     */
    private class MessageReceiver implements Observer<String> {
        @Override
        public void update(String message){
            System.out.println("Received: "+message);
            try{
                handleMove(message);
            }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e){
                clientConnection.asyncSend(e.getMessage());
            }

        }
    }
}
