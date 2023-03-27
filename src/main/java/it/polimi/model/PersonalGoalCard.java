package it.polimi.model;

import java.io.FileReader;
import java.util.Map;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


public class PersonalGoalCard extends GoalCard{
    private static Bookshelf goal;
    private static Map<Integer,Integer> points;
    public PersonalGoalCard(int id) {
        // TODO: Sistemare lettura da file JSON
            /*JSONParser jsonParser = new JSONParser();

            try (FileReader reader = new FileReader("PersonalGoalCards.json"))
            {
                JSONObject obj  = (JSONObject)obj;
                String name = (String)obj.get("Name");
                String course = (String)obj.get("Course");
                JSONArray subjects = (JSONArray)obj.get("Subjects");
          }*/
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

