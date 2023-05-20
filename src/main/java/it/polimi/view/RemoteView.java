
package it.polimi.view;


        import it.polimi.model.Player;
        import it.polimi.observer.Observer;

        import java.util.Observable;


public class RemoteView extends View {
    private ClientConnection clientConnection;

    @Override
    public void update(GameView message) {

    }


    private class MessageReceiver implements Observer<String> {
        @Override
        public void update(String message){
            System.out.println("received: "+message);
            try{
                handleMove(message);
            }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e){
                clientConnection.asyncSend("Error!");
            }

        }
    }
    public RemoteView(Player player, ClientConnection c){
        super(player);
        this.clientConnection=c;
        c.addObserver(new MessageReceiver());

    }
    @Override
    protected void showMessage(Object message){ clientConnection.asyncSend(message);}


}
