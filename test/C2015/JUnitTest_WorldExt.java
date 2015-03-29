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
    public void Test1() {   //基本動作測試
        WorldExt Example=new WorldExt(Gamer.EXAMPLE_PROBLEM(),true);
        System.out.println("Before:");
        System.out.println(Example);
        /*------Step1--------*/
        Example.MOVELINE(CC.D9,CC.D7);
        Problem Step1=Example.P.copy();
//        System.out.println("After");
//        System.out.println(Example);
//        System.out.println("FirstProblem:");
        //System.out.println(Example.Cookie.GetFirstProblem());
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
    
    @Test
    public void Test2() {  //Try if WroldExt.copy() works fine with Cookie
        WorldExt Example=new WorldExt(Gamer.EXAMPLE_PROBLEM(),true);
        /*------Step1--------*/
        Example.MOVELINE(CC.D9,CC.D7);        
        Problem Step1= Example.P.copy();
         /*------Step2--------*/
        Example.POP(CC.C13);       
        Problem Step2= Example.P.copy();
        /*------Step3--------*/
        Example.POP(CC.S7);
        Problem Step3= Example.P.copy();
        /*------Step4--------*/
        Example.FINISH(CC.H1); 
        Problem Step4= Example.P.copy();
        /*------Step5--------*/
        Example.DOWN(CC.C5); 
        Problem Step5= Example.P.copy();
        /*------Step6--------*/
        Example.POP(CC.C3);  
        Problem Step6= Example.P.copy();
        /*------Step7--------*/
        Example.CONNECT(CC.C5, CC.D4);
        Problem Step7= Example.P.copy();
        //Make Copy
        WorldExt that=Example.copy();
        assertEquals(that.Cookie.GetFirstProblem().Equals(Gamer.EXAMPLE_PROBLEM()),true);
        assertEquals(that.Cookie.GetFirstProblem().Equals(that.Cookie.GetFirstProblem()),true);
        //assertEquals(that.Cookie.GetFirstProblem()!=that.Cookie.GetFirstProblem(),true);
        assertEquals(that.Cookie.size(), Example.Cookie.size());
        int sz= that.Cookie.size();
        for (int i=0; i<sz; i++) {
            assertEquals(that.Cookie.get(i).Equals(Example.Cookie.get(i)),true);
            assertEquals(that.History.get(i), Example.History.get(i));
            assertEquals(that.P.Equals(Example.P),true);
            assertEquals(that.F.Equals(Example.F),true);
        }
        
        
        
    }
    @Test
    public void Test3() { //Try if WroldExt.copy() works fine without Cookie
        WorldExt Example=new WorldExt(Gamer.EXAMPLE_PROBLEM());
        /*------Step1--------*/
        Example.MOVELINE(CC.D9,CC.D7);        
        assert(Example.Cookie==null);
        Problem Step1= Example.P.copy();
         /*------Step2--------*/
        Example.POP(CC.C13);       
        Problem Step2= Example.P.copy();
        assert(Example.Cookie==null);        
        /*------Step3--------*/
        Example.POP(CC.S7);
        Problem Step3= Example.P.copy();
        assert(Example.Cookie==null);
        /*------Step4--------*/
        Example.FINISH(CC.H1); 
        Problem Step4= Example.P.copy();
                assert(Example.Cookie==null);
        /*------Step5--------*/
        Example.DOWN(CC.C5); 
        Problem Step5= Example.P.copy();
                assert(Example.Cookie==null);
        /*------Step6--------*/
        Example.POP(CC.C3);  
        Problem Step6= Example.P.copy();
                assert(Example.Cookie==null);
        /*------Step7--------*/
        Example.CONNECT(CC.C5, CC.D4);
                assert(Example.Cookie==null);
        Problem Step7= Example.P.copy();
        //Make Copy
        WorldExt that=Example.copy();
      //  assertEquals(that.Cookie.GetFirstProblem().Equals(Gamer.EXAMPLE_PROBLEM()),true);
      //  assertEquals(that.Cookie.GetFirstProblem().Equals(that.Cookie.GetFirstProblem()),true);
        //assertEquals(that.Cookie.GetFirstProblem()!=that.Cookie.GetFirstProblem(),true);
      //  assertEquals(that.Cookie.size(), Example.Cookie.size());
        int sz= that.History.size();
        for (int i=0; i<sz; i++) {
       //     assertEquals(that.Cookie.get(i).Equals(Example.Cookie.get(i)),true);
            assertEquals(that.History.get(i), Example.History.get(i));
            assertEquals(that.P.Equals(Example.P),true);
            assertEquals(that.F.Equals(Example.F),true);
        }
        
                
    }
    @Test
    public void Test4() {
        System.out.println("@Test4");
        WorldExt Example=new WorldExt(Gamer.EXAMPLE_PROBLEM());
        boolean flag=false;
        flag=Example.POP(CC.C13);        assert(flag);
        flag=Example.POP(CC.S7);         assert(flag);
        flag=Example.FINISH(CC.H1);         assert(flag);
        flag=Example.DOWN(CC.C5); assert(flag);
        flag=Example.MOVELINE(CC.C5, CC.C3); assert(flag);
        flag=Example.MOVELINE(CC.C7, CC.S5); assert(flag);
        flag=Example.FINISH(CC.S4); assert(flag);
        flag=Example.FINISH(CC.S5); assert(flag);
        flag=Example.FINISH(CC.S6); assert(flag);
        flag=Example.FINISH(CC.D2); assert(flag);
        flag=Example.FINISH(CC.S7); assert(flag);
        flag=Example.POP(CC.D9); assert(flag);
        flag=Example.POP(CC.C8); assert(flag);
        flag=Example.FINISH(CC.C2); assert(flag);
        flag=Example.FINISH(CC.D3); assert(flag);
        flag=Example.FINISH(CC.C3); assert(flag);
        flag=Example.FINISH(CC.D4); assert(flag);
        flag=Example.FINISH(CC.C4); assert(flag);
        flag=Example.FINISH(CC.C5); assert(flag);
        flag=Example.DOWN(CC.S12);         assert(flag);
        flag=Example.CONNECT(CC.S12, CC.D11); assert(flag);
        flag=Example.FINISH(CC.D5); assert(flag);
        flag=Example.FINISH(CC.D6); assert(flag);
        flag=Example.FINISH(CC.H2); assert(flag);
        flag=Example.MOVELINE(null, CC.S9); 
        assert(flag);
        flag=Example.FINISH(CC.C6); assert(flag);
        flag=Example.FINISH(CC.D7); assert(flag);
        flag=Example.POP(CC.S11); assert(flag);
        flag=Example.FINISH(CC.H3); assert(flag);
        flag=Example.FINISH(CC.H4); assert(flag);
        flag=Example.FINISH(CC.H5); assert(flag);
        flag=Example.FINISH(CC.H6); assert(flag);
        flag=Example.FINISH(CC.H7); assert(flag);
        flag=Example.FINISH(CC.C7); assert(flag);
        flag=Example.FINISH(CC.C8);assert(flag);
        flag=Example.FINISH(CC.S8);assert(flag);
        flag=Example.FINISH(CC.D8);assert(flag);
        flag=Example.FINISH(CC.D9);assert(flag);
        flag=Example.POP(CC.D13);assert(flag);
        flag=Example.FINISH(CC.H8);assert(flag);
        flag=Example.FINISH(CC.C9);assert(flag);
        flag=Example.FINISH(CC.H9);assert(flag);
        flag=Example.FINISH(CC.S9);assert(flag);
        flag=Example.FINISH(CC.S10);assert(flag);
        flag=Example.FINISH(CC.H10);assert(flag);
        flag=Example.FINISH(CC.C10);assert(flag);
        flag=Example.FINISH(CC.D10);assert(flag);
        flag=Example.FINISH(CC.C11);assert(flag);
        flag=Example.FINISH(CC.D11);assert(flag);
        flag=Example.FINISH(CC.S11);assert(flag);
        flag=Example.FINISH(CC.H11);assert(flag);
        flag=Example.FINISH(CC.D12);assert(flag);
        flag=Example.FINISH(CC.H12);assert(flag);
        flag=Example.FINISH(CC.S12);assert(flag);
        flag=Example.FINISH(CC.C12);assert(flag);
        flag=Example.FINISH(CC.S13);assert(flag);
        flag=Example.FINISH(CC.C13);assert(flag);
        flag=Example.FINISH(CC.D13);assert(flag);
        flag=Example.FINISH(CC.H13);assert(flag);
        //System.out.println(Example);
    }
    @Test
    public void Test5() {
        System.out.println("@Test5");
        Vector<Problem> Hand=new Vector<Problem>();
        WorldExt Example=new WorldExt(Gamer.EXAMPLE_PROBLEM(),true);
        boolean flag=false;
        flag=Example.POP(CC.C13);        assert(flag);Hand.add(Example.P.copy());
        flag=Example.POP(CC.S7);         assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H1);         assert(flag);Hand.add(Example.P.copy());
        flag=Example.DOWN(CC.C5); assert(flag);Hand.add(Example.P.copy());
        flag=Example.MOVELINE(CC.C5, CC.C3); assert(flag);Hand.add(Example.P.copy());
        flag=Example.MOVELINE(CC.C7, CC.S5); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.S4); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.S5); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.S6); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D2); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.S7); assert(flag);Hand.add(Example.P.copy());
        flag=Example.POP(CC.D9); assert(flag);Hand.add(Example.P.copy());
        flag=Example.POP(CC.C8); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.C2); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D3); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.C3); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D4); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.C4); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.C5); assert(flag);Hand.add(Example.P.copy());
        flag=Example.DOWN(CC.S12);         assert(flag);Hand.add(Example.P.copy());
        flag=Example.CONNECT(CC.S12, CC.D11); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D5); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D6); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H2); assert(flag);Hand.add(Example.P.copy());
        flag=Example.MOVELINE(null, CC.S9); Hand.add(Example.P.copy());
        assert(flag);
        flag=Example.FINISH(CC.C6); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D7); assert(flag);Hand.add(Example.P.copy());
        flag=Example.POP(CC.S11); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H3); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H4); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H5); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H6); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H7); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.C7); assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.C8);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.S8);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D8);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D9);assert(flag);Hand.add(Example.P.copy());
        flag=Example.POP(CC.D13);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H8);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.C9);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H9);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.S9);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.S10);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H10);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.C10);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D10);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.C11);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D11);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.S11);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H11);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D12);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H12);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.S12);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.C12);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.S13);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.C13);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.D13);assert(flag);Hand.add(Example.P.copy());
        flag=Example.FINISH(CC.H13);assert(flag);Hand.add(Example.P.copy());
        for (Problem P: Hand) {
            int sz= Example.Cookie.size();
            for (int i=0; i<sz; i++) {
                Problem X= Example.Cookie.get(i);
                boolean f1= P.ValueEquals(X);
                P.SHA();  X.SHA();
                boolean f2= P.SHA.equals(X.SHA);
                assertEquals(f1,f2);
            }
        }
    }
}
