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
public class JUnit_CCTest {
        public enum X {C1,D1,H1,S1,
        C2,D2,H2,S2,
        C3,D3,H3,S3,
        C4,D4,H4,S4,
        C5,D5,H5,S5,
        C6,D6,H6,S6,
        C7,D7,H7,S7,
        C8,D8,H8,S8,
        C9,D9,H9,S9,
        C10,D10,H10,S10,
        C11,D11,H11,S11,
        C12,D12,H12,S12,
        C13,D13,H13,S13
        };
    
    public JUnit_CCTest() {
       
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

    /**
     * Test of values method, of class CC.
     */
    @Test
    public void test() {
        SHistory.Create();

        assertEquals(CC.C1, CardDeck.GetCard(X.C1.ordinal()));
        assertEquals(CC.D1, CardDeck.GetCard(X.D1.ordinal()));
        assertEquals(CC.H1, CardDeck.GetCard(X.H1.ordinal()));
        assertEquals(CC.S1, CardDeck.GetCard(X.S1.ordinal()));
        
        assertEquals(CC.C2, CardDeck.GetCard(X.C2.ordinal()));
        assertEquals(CC.D2, CardDeck.GetCard(X.D2.ordinal()));
        assertEquals(CC.H2, CardDeck.GetCard(X.H2.ordinal()));
        assertEquals(CC.S2, CardDeck.GetCard(X.S2.ordinal()));
        
        assertEquals(CC.C3, CardDeck.GetCard(X.C3.ordinal()));
        assertEquals(CC.D3, CardDeck.GetCard(X.D3.ordinal()));
        assertEquals(CC.H3, CardDeck.GetCard(X.H3.ordinal()));
        assertEquals(CC.S3, CardDeck.GetCard(X.S3.ordinal()));
        
        assertEquals(CC.C4, CardDeck.GetCard(X.C4.ordinal()));
        assertEquals(CC.D4, CardDeck.GetCard(X.D4.ordinal()));
        assertEquals(CC.H4, CardDeck.GetCard(X.H4.ordinal()));
        assertEquals(CC.S4, CardDeck.GetCard(X.S4.ordinal()));
        
        assertEquals(CC.C5, CardDeck.GetCard(X.C5.ordinal()));
        assertEquals(CC.D5, CardDeck.GetCard(X.D5.ordinal()));
        assertEquals(CC.H5, CardDeck.GetCard(X.H5.ordinal()));
        assertEquals(CC.S5, CardDeck.GetCard(X.S5.ordinal()));
        
        assertEquals(CC.C6, CardDeck.GetCard(X.C6.ordinal()));
        assertEquals(CC.D6, CardDeck.GetCard(X.D6.ordinal()));
        assertEquals(CC.H6, CardDeck.GetCard(X.H6.ordinal()));
        assertEquals(CC.S6, CardDeck.GetCard(X.S6.ordinal()));
        
        assertEquals(CC.C7, CardDeck.GetCard(X.C7.ordinal()));
        assertEquals(CC.D7, CardDeck.GetCard(X.D7.ordinal()));
        assertEquals(CC.H7, CardDeck.GetCard(X.H7.ordinal()));
        assertEquals(CC.S7, CardDeck.GetCard(X.S7.ordinal()));
        
        assertEquals(CC.C8, CardDeck.GetCard(X.C8.ordinal()));
        assertEquals(CC.D8, CardDeck.GetCard(X.D8.ordinal()));
        assertEquals(CC.H8, CardDeck.GetCard(X.H8.ordinal()));
        assertEquals(CC.S8, CardDeck.GetCard(X.S8.ordinal()));

        assertEquals(CC.C9, CardDeck.GetCard(X.C9.ordinal()));
        assertEquals(CC.D9, CardDeck.GetCard(X.D9.ordinal()));
        assertEquals(CC.H9, CardDeck.GetCard(X.H9.ordinal()));
        assertEquals(CC.S9, CardDeck.GetCard(X.S9.ordinal()));
        
        assertEquals(CC.C10, CardDeck.GetCard(X.C10.ordinal()));
        assertEquals(CC.D10, CardDeck.GetCard(X.D10.ordinal()));
        assertEquals(CC.H10, CardDeck.GetCard(X.H10.ordinal()));
        assertEquals(CC.S10, CardDeck.GetCard(X.S10.ordinal()));
        
        assertEquals(CC.C11, CardDeck.GetCard(X.C11.ordinal()));
        assertEquals(CC.D11, CardDeck.GetCard(X.D11.ordinal()));
        assertEquals(CC.H11, CardDeck.GetCard(X.H11.ordinal()));
        assertEquals(CC.S11, CardDeck.GetCard(X.S11.ordinal()));
        
        assertEquals(CC.C12, CardDeck.GetCard(X.C12.ordinal()));
        assertEquals(CC.D12, CardDeck.GetCard(X.D12.ordinal()));
        assertEquals(CC.H12, CardDeck.GetCard(X.H12.ordinal()));
        assertEquals(CC.S12, CardDeck.GetCard(X.S12.ordinal()));

        assertEquals(CC.C13, CardDeck.GetCard(X.C13.ordinal()));
        assertEquals(CC.D13, CardDeck.GetCard(X.D13.ordinal()));
        assertEquals(CC.H13, CardDeck.GetCard(X.H13.ordinal()));
        assertEquals(CC.S13, CardDeck.GetCard(X.S13.ordinal()));

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    
}
