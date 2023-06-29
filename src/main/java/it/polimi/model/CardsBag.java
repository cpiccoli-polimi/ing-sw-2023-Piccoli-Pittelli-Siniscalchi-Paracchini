package it.polimi.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Long.parseLong;
import static java.util.Collections.shuffle;

/**
 * CardsBag class represents the physical bag
 * in the game, containing all the tiles that
 * are then placed on the LivingRoomBoard
 */
public class CardsBag {
    private List<Integer> cards;

    /**
     * Creates the istance of CardsBag, setting
     * its attributes
     */
    protected CardsBag() {
        LocalTime clock = LocalTime.now();
        int hours = clock.getHour();
        int minutes = clock.getMinute();
        int seconds = clock.getSecond();
        String clockString = "";
        clockString += hours;
        clockString += minutes;
        clockString += seconds;
        long seed = parseLong(clockString);
        Random generator = new Random(seed);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 132; i++) {
            list.add(i+1);
        }

        shuffle(list, generator);

        cards = new ArrayList<>();
        for(int i = 0; i < 132; i++) {
            cards.add(list.get(i));
        }
    }

    /**
     * Returns the size of CardsBag
     *
     * @return cards.size the remaining tiles inside
     */
    public int getSize(){ return cards.size();}
    /**
     * Returns a card from the bag
     *
     * @return the reference to the card
     */
    public int getCard(){
        return cards.remove(0);
    }

}