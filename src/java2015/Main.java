/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2015;
import C2015.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
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
        World W0=Gamer.COMPLETE_WORLD();
        byte[] d=W0.P.getBytes();
        for (byte k:d) {
            System.out.print(""+k+",");
        }
        System.out.println();
        for (byte k:d) {
            if (k<0) {
                System.out.println(k*(-1));
            }else
                System.out.print(CardDeck.GetCard(k).Str+",");
        }
        
        WorldExt that0=new WorldExt(Gamer.EXAMPLE_PROBLEM());
        System.out.println(that0.P);
        System.out.println(new Date());
        byte[] data=that0.P.getBytes();
        for (byte k:data) {
            System.out.print(""+k+",");
        }
        System.out.println();
        for (byte k:data) {
            if (k<0) {
                System.out.println(k*(-1));
            }else
                System.out.print(CardDeck.GetCard(k).Str+",");
        }
        System.out.println(SHAClass.stringSHA(data));
        System.out.println(new Date());
        for (int i=1; i<=10; i++) {
            WorldExt that=new WorldExt(new Problem(i));
            Problem P0=that.P.copy();
            Sage S1=new Sage(that);
            if (S1.Run1(false)) {
                try {
                     boolean flag=Verify.Verify_Problem(P0, Sage.Result.History, Gamer.COMPLETE_WORLD().P);
                     System.out.println("Verify("+i+")="+flag);
                }catch(Exception ex) {
                    ex.printStackTrace();
                }                
            }

        }
    }
}