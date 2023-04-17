package it.polimi.model.CommonGoalCards;
import static org.junit.jupiter.api.Assertions.*;

import it.polimi.model.PublicObjectCard;

import org.junit.jupiter.api.Test;

public class CommonGoalCard11Test {
    @Test
    void EmptyBookshelf(){
        PublicObjectCard [][] bookshelf;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard11 cm11=new CommonGoalCard11(4);
        assertEquals(false,cm11.check(bookshelf));
    }
    @Test
    void ColonnaPiena(){
        PublicObjectCard [][] bookshelf;
        int k=0;
        bookshelf=new PublicObjectCard[6][5];
        for(int i=0;i< bookshelf.length;i++){
            bookshelf[i][0]=new PublicObjectCard(k,i,0);
        }
        CommonGoalCard11 cm11=new CommonGoalCard11(4);
        assertEquals(false,cm11.check(bookshelf));
    }
    @Test
    void DueColonneStessoTipo(){
        PublicObjectCard[][] bookshelf;
        int k=0;
        bookshelf=new PublicObjectCard[6][5];
        for(int i=0;i< bookshelf.length;i++){
            bookshelf[i][0]=new PublicObjectCard(k,i,0);
            k++;
            bookshelf[i][1]=new PublicObjectCard(k,i,1);
            k++;
        }
        CommonGoalCard11 cm11=new CommonGoalCard11(4);
        assertEquals(true,cm11.check(bookshelf));
    }
}
