
package it.polimi.model;

        import it.polimi.view.View;

public class PlayerChoice {
    private final Player player;
    private final View view;
    private final String message;
    public PlayerChoice(Player player, String message, View view){
        this.player=player;
        this.message=message;
        this.view=view;
    }

    public String getMessage(){return message;}
    public Player getPlayer(){return player;}
    public View getView(){return  view;}
}

