package it.polimi.model;

import java.lang.Object;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Long.parseLong;
import static java.util.Collections.shuffle;

public class CardsBag {
    private List<Integer> cards;


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

        cards = new ArrayList<Integer>();
        for(int i = 0; i < 132; i++) {
            cards.add(list.get(i));
        }
    };

    public int getCard(){
        int id = cards.remove(0);
        return id;
    };

    private void setCards(List<Integer> cards){
        this.cards = cards;
    };
}