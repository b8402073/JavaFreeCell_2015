/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C2015;

import java.util.Vector;
import org.junit.Test;

/**
 *
 * @author easterday
 */
public class JUnitTest_WorldExt {
    
    public JUnitTest_WorldExt() {
    }

    @Test
    public void testMakeChild0() {
        SHistory.Create();
        WorldExt Example= new WorldExt(Gamer.EXAMPLE_PROBLEM());        
        System.out.println(Example);
        Example.Child=new Vector<WorldExt>();
        Example.makeChild0(0, 100);
        
    }
    
}
