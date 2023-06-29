
package it.polimi.model;
import it.polimi.view.View;

/**
 * PlayerChoice class is meant to transform to
 * final passed parameters, to pass through the network
 * only "final" attributes and serialize them
 */
public class PlayerChoice {
    private final Player player;
    private final View view;
    private final String message;
    /**
     * Sets attribute of PlayerChoice class based
     * on parameters passed
     *
     * @param player
     * @param message
     * @param view
     */
    public PlayerChoice(Player player, String message, View view){
        this.player=player;
        this.message=message;
        this.view=view;
    }
    /**
     * Returns the message
     *
     * @return message
     */
    public String getMessage(){return message;}
    /**
     * Returns the player
     *
     * @return player
     */
    public Player getPlayer(){return player;}
    /**
     * Returns the view
     *
     * @return view
     */
    public View getView(){return  view;}
}

