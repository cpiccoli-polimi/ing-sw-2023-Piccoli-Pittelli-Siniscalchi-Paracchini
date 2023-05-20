package it.polimi.view;

import it.polimi.model.*;

import it.polimi.observer.*;


public abstract class View extends Observable<PlayerChoice> implements Observer<GameView> {
    private Player player;


    protected View(Player player){
        this.player = player;
    }

    protected Player getPlayer(){
        return player;
    }

    protected abstract void showMessage(Object message);

    void handleMove(String message) {
        notify(new PlayerChoice(player, message, this));
    }

    public void reportError(String message){
        showMessage(message);
    }


}
