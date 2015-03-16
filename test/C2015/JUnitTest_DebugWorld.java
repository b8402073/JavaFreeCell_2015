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
public class JUnitTest_DebugWorld {
    
    public JUnitTest_DebugWorld() {
        SHistory.Create();
    }

    @Test
    public void testSomeMethod() {
        WorldExt D=new WorldExt(Gamer.EXAMPLE_PROBLEM());
        System.out.println(D);
        D.POP(CC.C13);
        D.POP(CC.S7);
        D.FINISH(CC.H1);
        System.out.println(D);
        WorldExt D2=D.copy();
        System.out.println("D2");
        System.out.println(D2);
    }
    
}
