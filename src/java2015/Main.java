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
        /*
        WorldExt that=new WorldExt(Gamer.EXAMPLE_PROBLEM(),true);        
        System.out.println(that);
        
        Sage S1=new Sage(that);
        if (S1.Run1(false)) {
            System.out.println(Sage.Result);
            System.out.println(Sage.Result.Cookie); 
            try {
                boolean flag=Verify.Verify_Problem(that.Cookie.GetFirstProblem(), Sage.Result.History, Gamer.COMPLETE_WORLD().P);
                System.out.println("Verify="+flag);
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        */
        for (int i=1; i<=10; i++) {
            WorldExt that=new WorldExt(new Problem(i));
            Problem P0=that.P.copy();
            Sage S1=new Sage(that);
            try {
                 boolean flag=Verify.Verify_Problem(P0, Sage.Result.History, Gamer.COMPLETE_WORLD().P);
                 System.out.println("Verify("+i+")="+flag);
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        
        
        
        
    }
    
}
