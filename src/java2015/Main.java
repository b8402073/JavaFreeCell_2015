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
        WorldExt that=new WorldExt(Gamer.EXAMPLE_PROBLEM());
        System.out.println(that);
        Sage S1=new Sage(that);
        if (S1.Run1(false)) {
            System.out.println(Sage.Result);
        }
  
        
        
    }
    
}
