package it.polimi.view;

import java.io.Serializable;
import java.util.List;

public class TextualUIView implements Serializable {
    static final long serialVersionUID = 1L;
    private final int playersNumber;
    private final int commonGoalsNumber;
    private final String nickname;
    private final List<Integer[]> objectCardsChoice;
    private final int columnChoice;
    private final List<Integer> insertionOrderChoice;

    public TextualUIView(TextualUI view){
        this.playersNumber = view.getPlayersNumber();
        this.commonGoalsNumber = view.getCommonGoalsNumber();
        this.nickname = view.getNickname();
        this.objectCardsChoice = view.getObjectCardsChoice();
        this.columnChoice = view.getColumnChoice();
        this.insertionOrderChoice = view.getInsertionOrderChoice();
    }

    public int getPlayersNumber() {
        return this.playersNumber;
    }

    public int getCommonGoalsNumber() {
        return this.commonGoalsNumber;
    }

    public String getNickname() {
        return this.nickname;
    }

    public List<Integer[]> getObjectCardsChoice() {
        return this.objectCardsChoice;
    }

    public int getColumnChoice() {
        return this.columnChoice;
    }

    public List<Integer> getInsertionOrderChoice() {
        return this.insertionOrderChoice;
    }
}
