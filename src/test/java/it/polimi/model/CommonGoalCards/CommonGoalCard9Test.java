package it.polimi.model.CommonGoalCards;

import it.polimi.model.PublicObjectCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonGoalCard9Test {
    @Test
    void TreColonneTreTipiDiversi(){
        PublicObjectCard [][] bookshelf;
        int k=0;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard9 cm9=new CommonGoalCard9(4);
        for(int i=0;i<bookshelf.length;i++){
            bookshelf[i][0]=new PublicObjectCard(k,i,0);
            bookshelf[i][1]=new PublicObjectCard(k+23,i,1);
            bookshelf[i][2]=new PublicObjectCard(k+46,i,2);
        }
        assertTrue(cm9.check(bookshelf));
    }
    @Test
    void TreColonneStessoTipo(){
        PublicObjectCard [][] bookshelf;
        int k=0;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard9 cm9=new CommonGoalCard9(4);
        for(int i=0;i<bookshelf.length;i++){
            bookshelf[i][0]=new PublicObjectCard(k,i,0);
            bookshelf[i][1]=new PublicObjectCard(k,i,1);
            bookshelf[i][2]=new PublicObjectCard(k,i,2);
        }
        assertTrue(cm9.check(bookshelf));
    }
    @Test
    void SoloDueColonne(){
        PublicObjectCard [][] bookshelf;
        int k=0;
        bookshelf= new PublicObjectCard[6][5];
        CommonGoalCard9 cm9=new CommonGoalCard9(4);
        for(int i=0;i<bookshelf.length;i++){
            bookshelf[i][0]=new PublicObjectCard(k,i,0);
            bookshelf[i][1]=new PublicObjectCard(k,i,1);
        }
        assertEquals(false,cm9.check(bookshelf));
    }
}