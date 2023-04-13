package it.polimi.model;

import java.lang.Object;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Long.parseLong;
import static java.util.Collections.shuffle;

public class CardsBag {
    private int[] cards;

    protected void CardsBag() {
        LocalTime clock = LocalTime.now();
        int hours = clock.getHour();
        int minutes = clock.getMinute();
        int seconds = clock.getSecond();
        String clockString = new String();
        clockString += hours;
        clockString += minutes;
        clockString += seconds;
        long seed = parseLong(clockString);
        Random generator = new Random(seed);

        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 132; i++) {
            list.add(i+1);
        }

        shuffle(list, generator);

        for(int i = 0; i < 132; i++) {
            cards[i] = list.get(i);
        }
    };

    public int getCard(){
        id = cards[0];
        cards = ArrayUtils.removeElement(cards, id);
        return id;
    };

    private void setCards(int[] cards){
        this.cards = cards;
    };
}