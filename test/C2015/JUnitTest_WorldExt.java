/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C2015;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author easterday
 */
public class JUnitTest_WorldExt {
    
    public JUnitTest_WorldExt() {
    }

    @Test
    public void testSomeMethod() {
        SHistory.Create();
        WorldExt Example= new WorldExt(Gamer.EXAMPLE_PROBLEM());        
        System.out.println(Example);
    }
    
}
