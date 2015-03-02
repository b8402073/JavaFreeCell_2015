/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C2015;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author easterday
 */
public class CardTest {
    
    public CardTest() {
         SHistory.Create();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {   
        //CardDeck.Create();
        for (int v=1; v<=13; v++) {
            for (CardSuit s: CardSuit.values()) {
                Card hand=CardDeck.GetCard(v,s);
                if (hand!=null) {
                    assertEquals(Card.GetSuitFromString(hand.toString()), s);
                    assertEquals(Card.GetValueFromString(hand.toString()),v);
                    assertEquals(Card.GetSuitFromString(hand.toString(0)), s);
                    assertEquals(Card.GetValueFromString(hand.toString(0)),v);                                    
                }                    
            }
        }
        assertEquals(Card.GetSuitFromString("ET8"),CardSuit.ERR);
        assertEquals(Card.GetValueFromString("ET8"),-1);
        assertEquals(Card.GetSuitFromString("13T"),CardSuit.ERR);
        assertEquals(Card.GetValueFromString("13T"),13);        
    }
    @Test
    public void TestCard() {
        Card XXX=new Card();
        assertEquals(XXX.ID, -1);    assertEquals(XXX.toString(),"@@?");
        assertEquals(XXX.Value,0);  assertEquals(XXX.Suit, CardSuit.ERR); assertEquals(XXX.IsRed,false);
        for (int i=0; i<52; i++) {
            Card that= CardDeck.GetCard(i);
            assertEquals(that.ID,i);            
        }
        for (int n=1; n<=13;n++) {
            for(CardSuit pp : CardSuit.values()) {
                Card that= CardDeck.GetCard(n,pp);                
                if (pp== CardSuit.ERR) {
                    assertEquals(null, that);
                    break;
                }                    
                assertEquals(that.Value, n);
                assertEquals(that.Suit, pp);
                boolean ColorIsRed = (pp==CardSuit.DIAMOND || pp==CardSuit.HEART);
                assertEquals(that.IsRed, ColorIsRed);
                assertEquals(that._Str.length(),3);
                if (n<=9) {
                    assertEquals(that.Str.length(),2);
                }
                assertEquals(n,Card.GetValueFromString(that.Str));
                assertEquals(pp, Card.GetSuitFromString(that.Str));
                assertEquals(n,Card.GetValueFromString(that._Str));
                assertEquals(pp, Card.GetSuitFromString(that._Str));
            }
        }    
    }
}
