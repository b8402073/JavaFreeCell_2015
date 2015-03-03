/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2015;
import C2015.*;
/**
 *
 * @author easterday
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static  Problem EXAMPLE_BUG() {
        Problem ret= World.SynthesizeProblemFromNineStrings(
           "6C,9D,10D,13C#",
           "13H,12C,11H,10C,9H,8C#",
           "13S#",
           "11S#",
           "8H,13D,5H#",
           "10S,7H,3H#",
           "12D,11C,10H,9C,8D,7C,6H#",
           "12H,4H#",
           "12S,11D#"
        );
        return ret;
    }
    public static Problem EXAMPLE_ANSWER() {
/*        
        Card[][] arr=new Card[8][21];
        MyBuffer b=new MyBuffer();
        b.Add(CC("10D"));       b.Add(CC("13C"));
        arr[0][0]=CC("13H");
        arr[0][1]=CC("12C");
        arr[0][2]=CC("11H");
        arr[0][3]=CC("10C");
        arr[0][4]=CC("9H");
        
        arr[1][0]=CC("13S");
        
        arr[2][0]=CC("11S");
        
        arr[3][0]=CC("8H");
        arr[3][1]=CC("13D");
        
        arr[4][0]=CC("10S");
        
        arr[5][0]=CC("12D");
        arr[5][1]=CC("11C");
        arr[5][2]=CC("10H");
        arr[5][3]=CC("9C");
        
        arr[6][0]=CC("12H");
        
        arr[7][0]=CC("12S");
        arr[7][1]=CC("11D");
*/        
        Problem ret= World.SynthesizeProblemFromNineStrings(
           "10D,13C#",
           "13H,12C,11H,10C,9H#",
           "13S#",
           "11S#",
           "8H,13D#",
           "10S#",
           "12D,11C,10H,9C#",
           "12H#",
           "12S,11D#"
        );
        return ret;
    }    
    public static void main(String[] args) {
        SHistory.Create();
        System.out.println("W1:");
        Problem P1= EXAMPLE_BUG();
        World W1=new World(P1);      
        System.out.println(W1);
        System.out.println(W1.AutoSafeUp());
        System.out.println("W1 After: AutoSafeUp");
        System.out.println(W1.toString());
        
        Problem P2= EXAMPLE_ANSWER(); 
        World W2=new World(P2);
        System.out.println("W2:");
        System.out.println(W2.toString());
        System.out.println("W1==W2:"+W1.P.Equals(W2.P));
        
    }
    
}
