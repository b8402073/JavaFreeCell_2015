/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2015;
import C2015.*;
import java.util.Vector;
/**
 *
 * @author easterday
 */
public class Main {

  
    public static void main(String[] args) {
        SHistory.Create();
        WorldExt W0=new WorldExt(Gamer.EXAMPLE_PROBLEM());         
        System.out.println("W0:\n"+W0.toString());
        
        System.out.println("MOVELINE(1,3)="+W0.MOVELINE(1,3));
        
        System.out.println("W After (1,3)");
        System.out.println(W0.toString());
        
        W0.Child=new Vector<WorldExt>();
        W0.makeChild0(0, 100);
        System.out.println("------------------------------------------");
        Verify.ListWorldToString(W0.Child, true, true, true);
        System.out.println(W0);
        
    }
    
}
