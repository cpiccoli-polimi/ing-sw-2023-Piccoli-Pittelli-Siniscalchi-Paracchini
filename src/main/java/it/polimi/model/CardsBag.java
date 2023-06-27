package it.polimi.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Long.parseLong;
import static java.util.Collections.shuffle;

public class CardsBag {
    private List<Integer> cards;

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

    public int getSize(){ return cards.size();}
    public int getCard(){
        return cards.remove(0);
    }

    private void setCards(List<Integer> cards){
        for(int i = 0; i < cards.size(); i++){
            this.cards.add(cards.remove(0));
        }
    }
}