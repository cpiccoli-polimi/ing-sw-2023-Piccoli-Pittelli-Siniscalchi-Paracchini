package it.polimi.model;

import java.io.FileReader;
import java.util.Map;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


public class PersonalGoalCard extends GoalCard{
    private static Bookshelf goal;
    private static Map<Integer,Integer> points;
    public PersonalGoalCard(int id) {
        // TODO: Lettura da file

        // TODO: Inizializzazione corretta?
        points =  Map.ofEntries(
                Map.entry(1, 1),
                Map.entry(2, 2),
                Map.entry(3, 4),
                Map.entry(5, 9),
                Map.entry(6, 12)
        );
        };
}

