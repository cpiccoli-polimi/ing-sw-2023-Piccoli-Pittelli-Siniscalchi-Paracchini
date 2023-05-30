package it.polimi.view;
import it.polimi.model.GameView;
import it.polimi.model.Player;
import it.polimi.observer.Observer;
import it.polimi.server.ClientConnection;

public class RemoteView extends View {
    private ClientConnection clientConnection;
    public RemoteView(Player player, ClientConnection c){
        super(player);
        this.clientConnection=c;
        c.addObserver(new MessageReceiver());

    }
    @Override
    protected void showMessage(Object message){ clientConnection.asyncSend(message);}


    @Override
    public void update(GameView message) {
        System.out.println("received: "+message);
        try{
            clientConnection.asyncSend(message);
            if(message.getCurrPlayer()==super.getPlayer().getPosition()){
                clientConnection.asyncSend(message.getTurnPlayerMessage());
            }
            else{
                clientConnection.asyncSend(message.getOtherPlayersMessage());
            }
        }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e){
            clientConnection.asyncSend("Error!");
        }

    }


    private class MessageReceiver implements Observer<String> {
        @Override
        public void update(String message){
            System.out.println("received: "+message);
            try{
                handleMove(message);
            }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e){
                clientConnection.asyncSend(e.getMessage());
            }

        }
    }
}