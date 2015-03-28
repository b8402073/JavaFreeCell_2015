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
          SHistory.Create();
    }
    /*
    @Test
    public void testMakeChild0() {
      
        WorldExt Example= new WorldExt(Gamer.EXAMPLE_PROBLEM());        
        System.out.println(Example);
        Example.Child=new Vector<WorldExt>();
        Example.makeChild0(0, 100);
        
    }
    */
    @Test
    public void Test1() {
        WorldExt Example=new WorldExt(Gamer.EXAMPLE_PROBLEM(),true);
        System.out.println("Before:");
        System.out.println(Example);
        Example.MOVELINE(CC.D9,CC.D7);
        System.out.println("After");
        System.out.println(Example);
    }
    
}
