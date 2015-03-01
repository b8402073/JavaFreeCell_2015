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
            for (CardSuit s: CardSuit.values()) {
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
    
}
