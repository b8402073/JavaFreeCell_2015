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
public class JUnit_CardTest {
    
    public JUnit_CardTest() {
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
        for (int v=1; v<=13; v++) {
            for (CardSuit s: CardSuit.NormalSet) {
                Card hand=CardDeck.GetCard(v,s);
                assertEquals(Card.GetSuitFromString(hand.toString()), s);
                assertEquals(Card.GetValueFromString(hand.toString()),v);
                assertEquals(Card.GetSuitFromString(hand.toString(0)), s);
                assertEquals(Card.GetValueFromString(hand.toString(0)),v);                                                                        
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
    @Test
    public void TestCardStaticFunction() {
        //Int_To_ESuit
        /*
        assertEquals(CardSuit.CLUB, Card.Int_To_ESuit(0));
        assertEquals(CardSuit.DIAMOND, Card.Int_To_ESuit(1));
        assertEquals(CardSuit.HEART, Card.Int_To_ESuit(2));
        assertEquals(CardSuit.SPADE, Card.Int_To_ESuit(3));
        assertEquals(CardSuit.ERR, Card.Int_To_ESuit(-1));
        assertEquals(CardSuit.ERR, Card.Int_To_ESuit(5));        
        */
        
        // Char_To_Suit
        assertEquals(CardSuit.CLUB, CardSuit.CharToSuit('C'));
        assertEquals(CardSuit.CLUB, CardSuit.CharToSuit('c'));
        assertEquals(CardSuit.ERR, CardSuit.CharToSuit('A'));
        assertEquals(CardSuit.ERR, CardSuit.CharToSuit('@'));
        // Suit_To_LowerCase        
        assertEquals("c", CardSuit.CLUB.toLowerCase());
        assertEquals("d", CardSuit.DIAMOND.toLowerCase());
        assertEquals("h", CardSuit.HEART.toLowerCase());
        assertEquals("s",CardSuit.SPADE.toLowerCase());
        assertEquals("@",CardSuit.ERR.toLowerCase());
        //GetValueFromString
        assertEquals(11,Card.GetValueFromString("11C"));
        assertEquals(3,Card.GetValueFromString("3H"));
        assertEquals(11,Card.GetValueFromString("11A"));
        assertEquals(-1,Card.GetValueFromString("18C"));
        assertEquals(-1,Card.GetValueFromString("18A"));
        //GetSuitFromString
        assertEquals(CardSuit.CLUB,Card.GetSuitFromString("11C"));
        assertEquals(CardSuit.HEART,Card.GetSuitFromString("3H"));
        assertEquals(CardSuit.ERR,Card.GetSuitFromString("11A"));
        assertEquals(CardSuit.CLUB,Card.GetSuitFromString("18C"));
        assertEquals(CardSuit.ERR,Card.GetSuitFromString("18A"));
        //Equals
        Card H7=new Card(24+CardSuit.HEART.ordinal());
        Card that=CardDeck.GetCard(7,CardSuit.HEART);        
        assertEquals(true, that.Equals(H7));
        assertEquals(true, H7.Equals(that));
        assertEquals(false,CardDeck.GetCard("8C").Equals(H7));
        assertEquals(false,CardDeck.GetCard("1S").Equals(H7));
        assertEquals(false,CardDeck.GetCard("1S").Equals(null));
        //isCard
        assertEquals(true, Card.isCard("7H"));
        assertEquals(true, Card.isCard(" 7H"));
        assertEquals(false, Card.isCard("18H"));
        assertEquals(false, Card.isCard(null));
        assertEquals(false, Card.isCard("13A"));
        assertEquals(true, Card.isCard("07C"));
    } 
    @Test
    public void TestCardDeckFunction() {
        //Create
        //assertEquals(true,CardDeck.Create());
        //GetCard(inn)
        assertEquals(null,CardDeck.GetCard(-1));
        assertEquals(null,CardDeck.GetCard(52));
        assertEquals(CardDeck.GetCard(0), CardDeck.GetCard(1,CardSuit.CLUB));
        assertEquals(CardDeck.GetCard(51), CardDeck.GetCard(13,CardSuit.SPADE));
        for (int i=0; i<52; i++) {
            Card that=CardDeck.GetCard(i);
            assertEquals(CardDeck.GetCard(i)==CardDeck.GetCard(that.Str), true);
            assertEquals(CardDeck.GetCard(i)==CardDeck.GetCard(that._Str),true);
        }                
    }    
}
