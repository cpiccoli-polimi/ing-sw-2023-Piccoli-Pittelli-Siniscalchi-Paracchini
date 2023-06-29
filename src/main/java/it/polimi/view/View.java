package it.polimi.view;

import it.polimi.model.*;

import it.polimi.observer.*;

/**
 * This class is used for the "View" part
 * of the MVC pattern
 *
 * @see it.polimi.observer.Observer
 */
public abstract class View extends Observable<PlayerChoice> implements Observer<GameView> {
    private Player player;


    /**
     * Creates the view for the passed player
     *
     * @param player
     */
    protected View(Player player){
        this.player = player;
    }

    /**
     * Returns the player of this view
     *
     * @return player
     */
    protected Player getPlayer(){
        return player;
    }

    /**
     * Shows the message on the CLI
     *
     * @param message the message to be shown
     */
    protected abstract void showMessage(Object message);

    /**
     * Notify the model of the move made
     * by the player through a PlayerChoice
     *
     * @param message the message containing the
     *                move made by the player
     */
    void handleMove(String message) {
        notify(new PlayerChoice(player, message, this));
    }

    /**
     * Shows an error message on the CLI
     * with the exception thrown by the controller
     *
     * @param message exception to be shown
     */
    public void reportError(Exception message){
        showMessage(message);
    }


}
