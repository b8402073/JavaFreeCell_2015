/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C2015;

import java.util.Vector;
import static org.junit.Assert.assertEquals;
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
        /*------Step1--------*/
        Example.MOVELINE(CC.D9,CC.D7);
        Problem Step1=Example.P.copy();
//        System.out.println("After");
//        System.out.println(Example);
//        System.out.println("FirstProblem:");
        System.out.println(Example.Cookie.GetFirstProblem());
        assertEquals(Example.Cookie.GetFirstProblem().Equals(Gamer.EXAMPLE_PROBLEM()),true);
        assertEquals(Example.Cookie.get(0).Equals(Gamer.EXAMPLE_PROBLEM()),true);
        assertEquals(Example.Cookie.size(),1);
        assertEquals(Example.History.size(),1);
        assertEquals(Example.History.get(0).intValue(),SHistory.MoveLine_ToNum(CC.D9,CC.D7));
        /*------Step2--------*/
        Example.POP(CC.C13);
        Problem Step2=Example.P.copy();
        assertEquals(Example.Cookie.get(1).Equals(Step1),true);        
        assertEquals(Example.Cookie.size(),2);
        assertEquals(Example.History.size(),2);
        assertEquals(Example.History.get(1).intValue(),SHistory.Pop_ToNum(CC.C13));
//        System.out.println("After");
//        System.out.println(Example);
        /*------Step3--------*/
        Example.POP(CC.S7);
        Problem Step3=Example.P.copy();
        assertEquals(Example.Cookie.get(2).Equals(Step2),true);
        assertEquals(Example.Cookie.size(),3);
        assertEquals(Example.History.size(),3);
        assertEquals(Example.History.get(2).intValue(),SHistory.Pop_ToNum(CC.S7));
 //       System.out.println("After");
 //       System.out.println(Example);
        /*------Step4--------*/
        Example.FINISH(CC.H1);
        Problem Step4=Example.P.copy();
        assertEquals(Example.Cookie.get(3).Equals(Step3),true);
        assertEquals(Example.Cookie.size(),4);
        assertEquals(Example.History.size(),4);
        assertEquals(Example.History.get(3).intValue(),SHistory.Finish_ToNum(CC.H1));
        /*------Step5--------*/
        Example.DOWN(CC.C5);
        Problem Step5=Example.P.copy();
        assertEquals(Example.Cookie.get(4).Equals(Step4),true);
        assertEquals(Example.Cookie.size(),5);
        assertEquals(Example.History.size(),5);
        assertEquals(Example.History.get(4).intValue(),SHistory.Down_ToNum(CC.C5));
        //System.out.println("After");
        //System.out.println(Example);
        /*------Step6--------*/
        Example.POP(CC.C3);
        Problem Step6=Example.P.copy();
        assertEquals(Example.Cookie.get(5).Equals(Step5),true);
        assertEquals(Example.Cookie.size(),6);
        assertEquals(Example.History.size(),6);
        assertEquals(Example.History.get(5).intValue(),SHistory.Pop_ToNum(CC.C3));
        /*------Step7--------*/
        Example.CONNECT(CC.C5, CC.D4);
        Problem Step7=Example.P.copy();
        assertEquals(Example.Cookie.get(6).Equals(Step6),true);
        assertEquals(Example.Cookie.size(),7);
        assertEquals(Example.History.size(),7);
        assertEquals(Example.History.get(6).intValue(),SHistory.Connect_ToNum(CC.C5, CC.D4));
        /*------Step8--------*/
    }
    
}
