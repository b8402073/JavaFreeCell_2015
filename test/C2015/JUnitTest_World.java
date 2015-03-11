package C2015;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Home
 */
public class JUnitTest_World {
    public static Card CC(String inn) {
        return CardDeck.GetCard(inn);
    }
    
    public JUnitTest_World() {
        SHistory.Create();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    /*
    @Test  
    public void bug_from_adteclipse() {
        try {
            System.out.println("This is Testing bug_from_android_Eclipse");
            for (int i=1;i<=10; i++) {
                Problem that=new Problem(i);
                Finisher F= that.Synthesize_Finisher();
                Card cc=F.Top(Card.ESuit.CLUB);
                Card dd=F.Top(Card.ESuit.DIAMOND);
                Card hh=F.Top(Card.ESuit.HEART);
                Card ss=F.Top(Card.ESuit.SPADE);
                assertEquals(cc,null);
                assertEquals(dd,null);
                assertEquals(hh,null);
                assertEquals(ss,null);
                WorldExt Test=new WorldExt(that);
                System.out.println(Test.toString());
                 Sage S=new Sage(Test);
                 assertEquals(S.Run1(true),true);
                 assertEquals(Verify.Verify_Problem(that, S.Result.History,S.Result.P),true);
                 assertEquals(Verify.Total_Veryfy(new DebugWorld(S.root.P,Sage.Result.History)),true);
            }
            
            
        }catch(Exception e )
        {
          e.printStackTrace();          
        }        
    } 
    */
    
    @Test    
    public void TestAutoSafeUp_Detai() {
        try {
            Problem P1= EXAMPLE_BUG();            
            World test=new World(P1);
            assertEquals(test.AutoSafeUp(),true);
            Problem P2= EXAMPLE_ANSWER();
            World ans= new World(P2);
            System.out.println("test");
            System.out.println(test);
            System.out.println("ans");
            System.out.println(ans);
            System.out.println(ans.Equals(test));  //I'm sure that ans.Equals(test)
            assertEquals(ans.Equals(test),true);
            assertEquals(ans.ValueEquals(test),true);
        }catch(Exception e) {
            System.out.println(e.toString());
            assertEquals(true,false);
        }        
    }
    @Test
    public void TestMoveLineFromZeroLine() {
        try {
            Problem P=World.SynthesizeProblemFromNineStrings("5C,7S,12S,13C#",  //Buffer Card
                    //After these Lines are Array Cards
                    "13H,12C,11H,10C,9H,8S,7D#", "13S#", "2H,6D,5D,11D,2C,8C,9D#", "8H,13D,5H,4C,3D#","10S,7H,3H,11S,6C,10D,9S#", "12D,11C,10H,9C,8D,7C#", "12H,4H,2D,6S,4S,6H,5S,4D,3C#","#");
            World test=new World(P);            
            //System.out.println(test.MOVELINE(8, 1));
            assertEquals(test.MOVELINE(8, 1),false);
            
        }catch(Exception e) {
            System.out.println(e.toString());
            fail("Error");
        }
    }
    
    /*
    @Test    
    public void TestWorld()     {
        System.out.println("@TestWorld");
        SHistory.Create();
        World root= Gamer.EXAMPLE_WORLD();
        S0__1(root); //測試MOVELINE
        S1(root);    //POP(13S)
        assertEquals(root.isComplete(),false);
        assertEquals(root.isDead(),false);
        S2(root); //POP(7S)
        S3(root); //Finish( 1H),
        S4(root); //DOWN( 5C,8),
        S5(root); //POP( 3C),
        S6(root); //Connect( 5C, 4D),
        S7(root); //Connect( 4D, 3C),
        S8(root); //POP( 5S),
        S9(root); //Connect( 7C, 6H),
        S10(root); //Connect( 6H, 5S),
        S10__1(root);


        S11(root); //Finish( 4S),
        S12(root); //Finish( 5S),
        S13(root); //Finish( 6S),
        S14(root); //Finish( 2D),
        S15(root); //Finish( 7S),
        S16(root); //POP( 9D),
        S17(root); //POP( 8C),
        S18(root); //Finish( 2C),
        S19(root); //Finish( 3D),
        S20(root); //Finish( 3C),
        S20__1(root);
        S20__2(root);
        S20__3(root);

        S21(root); //Finish( 4D),
        S22(root); //Finish( 4C),
        S23(root); //Finish( 5C),
        S24(root); //DOWN(12S,8),
        S25(root); //Connect(12S,11D),
        S26(root); //Finish( 5D),
        S27(root); //Finish( 6D),
        S28(root); //Finish( 2H),
        S29(root); //Finish( 7D),
        S30(root); //Finish( 8S),

        S31(root); //Finish( 9S),
        S32(root); //POP(10D),
        S33(root); //Finish( 6C),
        S34(root); //DOWN(11S,3),
        S35(root); //Finish( 3H),
        S36(root); //Finish( 4H),
        S37(root); //Finish( 5H),
        S38(root); //Finish( 6H),
        S39(root); //Finish( 7H),
        S40(root); //Finish( 7C),

        S41(root); //Finish( 8C),
        S42(root); //Finish( 8D),
        S43(root); //Finish( 9D),
        S44(root); //POP(13D),
        S45(root); //Finish( 8H),
        S46(root); //Finish( 9C),
        S47(root); //Finish(10D),
        S48(root); //Finish( 9H),
        S49(root); //Finish(10S),
        S50(root); //Finish(10H),

        S51(root); //Finish(10C),
        S52(root); //Finish(11S),
        S53(root); //Finish(11C),
        S54(root); //Finish(11D),
        S55(root); //Finish(11H),
        S56(root); //Finish(12D),
        S57(root); //Finish(12H),
        S58(root); //Finish(12S),
        S59(root); //Finish(12C),
        S60(root); //Finish(13S),

        S61(root); //Finish(13C),
        S62(root); //Finish(13H),
        //Test(Not root.isComplete())
        assertEquals(root.isComplete(),false);
        //Test(Not root.isDead())
        assertEquals(root.isDead(),false);
        S63(root); //Finish(13D)        
        assertEquals(root.isComplete(),true); 
        System.out.println(root.toString()); 
        try {
        assertEquals(Verify.Verify_Problem(Gamer.EXAMPLE_PROBLEM(), root.History,root.P),true);
        }catch(Exception ex) {
            System.out.println(ex);
        }
    }
   */
    
    public void S0__1(World root) {  //測試MOVELINE
        World cp0=null;
        try {
            cp0=root.copy();
            assertEquals(cp0.POP(CC("9S")),true);
            assertEquals(cp0.POP(CC("10D")),true);
            assertEquals(cp0.CONNECT(CC("7D"), CC("6C")),true);
            assertEquals(cp0.CONNECT(CC("11S"), CC("10D")),true);
            assertEquals(cp0.CONNECT(CC("10D"),CC("9S")),true);
            World cp2= cp0.copy();
            assertEquals(cp0.MOVELINE(4, 1),true);
            
            assertEquals(cp2.POP(CC("3D")),true);
            assertEquals(cp2.POP(CC("4C")),true);
            assertEquals(cp2.CONNECT(CC("6C"),CC("5H")),true);
            assertEquals(cp2.CONNECT(CC("5H"),CC("4C")),true);
            assertEquals(cp2.CONNECT(CC("4C"),CC("3D")),true);
            
            assertEquals(cp2.Equals(cp0),true);
            assertEquals(cp0.Equals(cp2),true);
        }catch(Exception e) {System.out.println(e.toString());}; 
    }
    public void S1(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("13S"), CC("12D")),false);
            assertEquals(root.FINISH(CC("13H")),false);
            assertEquals(root.POP(CC("1H")),false);
            assertEquals(root.DOWN(CC("12S")),false);
            
            assertEquals(root.POP(CC("13C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}
    }
    public void S2(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("12D"), CC("11C")),false);
            assertEquals(root.FINISH(CC("1C")),false);
            assertEquals(root.POP(CC("1H")),false);
            assertEquals(root.DOWN(CC("12S")),false);
            
            assertEquals(root.POP(CC("7S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}        
    }
    public void S3(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("11C"), CC("10D")),false);
            assertEquals(root.FINISH(CC("1S")),false);
            assertEquals(root.POP(CC("2H")),false);
            assertEquals(root.DOWN(CC("12S")),false);
            
            assertEquals(root.FINISH(CC("1H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}
        
    }
    public void S4(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("10D"), CC("9S")),false);
            assertEquals(root.FINISH(CC("2S")),false);
            assertEquals(root.POP(CC("2S")),false);
            assertEquals(root.DOWN(CC("11S")),false);
            
            assertEquals(root.DOWN(CC("5C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}
        
    }
    public void S5(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("9S"), CC("8H")),false);
            assertEquals(root.FINISH(CC("3C")),false);
            assertEquals(root.POP(CC("1S")),false);
            assertEquals(root.DOWN(CC("11H")),false);
            
            assertEquals(root.POP(CC("3C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}
        
    }
    public void S6(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("8H"), CC("7C")),false);
            assertEquals(root.FINISH(CC("3S")),false);
            assertEquals(root.POP(CC("2S")),false);
            assertEquals(root.DOWN(CC("10C")),false);
            
            assertEquals(root.CONNECT(CC("5C"),CC("4D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}
        
    }
    public void S7(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("7C"), CC("6D")),false);
            assertEquals(root.FINISH(CC("13S")),false);
            assertEquals(root.POP(CC("3S")),false);
            assertEquals(root.DOWN(CC("9C")),false);
            
            assertEquals(root.CONNECT(CC("4D"),CC("3C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}
        
    }
    public void S8(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("6D"), CC("5S")),false);
            assertEquals(root.FINISH(CC("12S")),false);
            assertEquals(root.POP(CC("4S")),false);
            assertEquals(root.DOWN(CC("10C")),false);
            
            assertEquals(root.POP(CC("5S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}
        
    }
    public void S9(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("5S"), CC("4H")),false);
            assertEquals(root.FINISH(CC("11S")),false);
            assertEquals(root.POP(CC("5S")),false);
            assertEquals(root.DOWN(CC("11C")),false);
            
            assertEquals(root.CONNECT(CC("7C"),CC("6H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}        
        
    }
    public void S10(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("4H"), CC("3S")),false);
            assertEquals(root.FINISH(CC("10S")),false);
            assertEquals(root.POP(CC("5H")),false);
            assertEquals(root.DOWN(CC("12C")),false);
            
            assertEquals(root.CONNECT(CC("6H"),CC("5S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                
    }
    public void S10__1(World root) { //測AutoSafeUp()的失敗
        try {
            World cp1= root.copy();
            World cp2= root.copy();

            assertEquals(cp1.FINISH(CC("2D")),false);
            assertEquals(cp2.AutoSafeUp(),false);
            assertEquals(cp1.Equals(cp2),true);
            assertEquals(cp2.Equals(cp1),true);                       
        }catch(Exception e) { System.out.println(e.toString());}                
    }
    public void S11(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("3S"), CC("2H")),false);
            assertEquals(root.FINISH(CC("9S")),false);
            assertEquals(root.POP(CC("6H")),false);
            assertEquals(root.DOWN(CC("13C")),false);
            
            assertEquals(root.FINISH(CC("4S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                
        
    }
    public void S12(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("2C"), CC("1S")),false);
            assertEquals(root.FINISH(CC("1D")),false);
            assertEquals(root.POP(CC("3S")),false);
            assertEquals(root.DOWN(CC("13S")),false);
            
            assertEquals(root.FINISH(CC("5S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                
        
    }
    public void S13(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("2S"), CC("1H")),false);
            assertEquals(root.FINISH(CC("2S")),false);
            assertEquals(root.POP(CC("2S")),false);
            assertEquals(root.DOWN(CC("2S")),false);
            
            assertEquals(root.FINISH(CC("6S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
    }
    public void S14(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("2C"), CC("1D")),false);
            assertEquals(root.FINISH(CC("2C")),false);
            assertEquals(root.POP(CC("2C")),false);
            assertEquals(root.DOWN(CC("2C")),false);
            
            assertEquals(root.FINISH(CC("2D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                
        
    }
    public void S15(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("3H"), CC("2C")),false);
            assertEquals(root.FINISH(CC("3H")),false);
            assertEquals(root.POP(CC("3H")),false);
            assertEquals(root.DOWN(CC("3H")),false);
            
            assertEquals(root.FINISH(CC("7S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                
        
    }
    public void S16(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("4C"), CC("3H")),false);
            assertEquals(root.FINISH(CC("4C")),false);
            assertEquals(root.POP(CC("4C")),false);
            assertEquals(root.DOWN(CC("4C")),false);
            
            assertEquals(root.POP(CC("9D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                
        
    }
    public void S17(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("5H"), CC("4C")),false);
            assertEquals(root.FINISH(CC("5H")),false);
            assertEquals(root.POP(CC("5H")),false);
            assertEquals(root.DOWN(CC("5H")),false);
            
            assertEquals(root.POP(CC("8C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                
        
    }
    public void S18(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("5D"), CC("4S")),false);
            assertEquals(root.FINISH(CC("5D")),false);
            assertEquals(root.POP(CC("5D")),false);
            assertEquals(root.DOWN(CC("5D")),false);
            
            assertEquals(root.FINISH(CC("2C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                
        
    }
    public void S19(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("6S"), CC("5D")),false);
            assertEquals(root.FINISH(CC("6S")),false);
            assertEquals(root.POP(CC("6S")),false);
            assertEquals(root.DOWN(CC("6S")),false);
            
            assertEquals(root.FINISH(CC("3D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                
        
    }
    public void S20(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("7H"), CC("6S")),false);
            assertEquals(root.FINISH(CC("7H")),false);
            assertEquals(root.POP(CC("7H")),false);
            assertEquals(root.DOWN(CC("7H")),false);
            
            assertEquals(root.FINISH(CC("3C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                
        
    }
    public void S20__1(World root) { //測AutoSafeUp()的成功
        try {
            World cp1=root.copy();
            World cp2=root.copy();
            assertEquals(cp1.FINISH(CC("4D")),true);  //Action
            assertEquals(cp2.AutoSafeUp(),true);
            assertEquals(cp1.Equals(cp2),true);
            assertEquals(cp2.Equals(cp1),true);
        }catch(Exception e) { System.out.println(e.toString());}                               
    }
    public void S20__2(World root) { //測POP的失敗
        try {
            World cp1=root.copy();
            World cp2=root.copy();
            assertEquals(cp1.POP(CC("8C")),false);  
            assertEquals(cp1.POP(CC("7D")),false);  
            assertEquals(cp1.POP(CC("13S")),false);  
            
            assertEquals(cp1.Equals(cp2),true);
            assertEquals(cp2.Equals(cp1),true);
        }catch(Exception e) { System.out.println(e.toString());}                               
        
    }
    public void S20__3(World root) { //測MOVELINE的失敗
        try {
            World cp1=root.copy();
            World cp2=root.copy();
            for (int i=1; i<=8; i++) {
                for (int j=1; j<=8; j++) {
                    if (i!=j) {
                        assertEquals(cp1.MOVELINE(i, j),false);                        
                    }
                }
            }            
            assertEquals(cp1.Equals(cp2),true);
            assertEquals(cp2.Equals(cp1),true);            
        }catch(Exception e) { System.out.println(e.toString());}                               

    }
    public void S21(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("4H"), CC("3S")),false);
            assertEquals(root.FINISH(CC("10S")),false);
            assertEquals(root.POP(CC("5H")),false);
            assertEquals(root.DOWN(CC("12C")),false);
            
            assertEquals(root.FINISH(CC("4D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
    }
    public void S22(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("8S"), CC("7D")),false);
            assertEquals(root.FINISH(CC("8S")),false);
            assertEquals(root.POP(CC("8S")),false);
            assertEquals(root.DOWN(CC("8S")),false);
            
            assertEquals(root.FINISH(CC("4C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S23(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("9H"), CC("8S")),false);
            assertEquals(root.FINISH(CC("8S")),false);
            assertEquals(root.POP(CC("8S")),false);
            assertEquals(root.DOWN(CC("8S")),false);
            
            assertEquals(root.FINISH(CC("5C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S24(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("10C"), CC("9H")),false);
            assertEquals(root.FINISH(CC("9H")),false);
            assertEquals(root.POP(CC("9H")),false);
            assertEquals(root.DOWN(CC("9H")),false);
            
            assertEquals(root.DOWN(CC("12S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                               
    }
    public void S25(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("11H"), CC("10C")),false);
            assertEquals(root.FINISH(CC("10C")),false);
            assertEquals(root.POP(CC("10C")),false);
            assertEquals(root.DOWN(CC("10C")),false);
            
            assertEquals(root.CONNECT(CC("12S"),CC("11D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                
    }
    public void S26(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("12S"), CC("11H")),false);
            assertEquals(root.FINISH(CC("11H")),false);
            assertEquals(root.POP(CC("11H")),false);
            assertEquals(root.DOWN(CC("11H")),false);
            
            assertEquals(root.FINISH(CC("5D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S27(World root){
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("13D"), CC("12S")),false);
            assertEquals(root.FINISH(CC("12S")),false);
            assertEquals(root.POP(CC("12S")),false);
            assertEquals(root.DOWN(CC("12S")),false);
            
            assertEquals(root.FINISH(CC("6D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S28(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("13S"), CC("12S")),false);
            assertEquals(root.FINISH(CC("1S")),false);
            assertEquals(root.POP(CC("1S")),false);
            assertEquals(root.DOWN(CC("1S")),false);
            
            assertEquals(root.FINISH(CC("2H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S29(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("13H"), CC("12H")),false);
            assertEquals(root.FINISH(CC("8H")),false);
            assertEquals(root.POP(CC("8H")),false);
            assertEquals(root.DOWN(CC("8H")),false);
            
            assertEquals(root.FINISH(CC("7D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S30(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("13C"), CC("12C")),false);
            assertEquals(root.FINISH(CC("7S")),false);
            assertEquals(root.POP(CC("7S")),false);
            assertEquals(root.DOWN(CC("7S")),false);
            
            assertEquals(root.FINISH(CC("8S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S31(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("13S"), CC("12D")),false);
            assertEquals(root.FINISH(CC("10S")),false);
            assertEquals(root.POP(CC("10S")),false);
            assertEquals(root.DOWN(CC("10S")),false);
            
            assertEquals(root.FINISH(CC("9S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S32(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("2D"), CC("13D")),false);
            assertEquals(root.FINISH(CC("2D")),false);
            assertEquals(root.POP(CC("2D")),false);
            assertEquals(root.DOWN(CC("2D")),false);
            
            assertEquals(root.POP(CC("10D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S33(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("3D"), CC("12D")),false);
            assertEquals(root.FINISH(CC("3D")),false);
            assertEquals(root.POP(CC("3D")),false);
            assertEquals(root.DOWN(CC("3D")),false);
            
            assertEquals(root.FINISH(CC("6C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S34(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("4D"), CC("11D")),false);
            assertEquals(root.FINISH(CC("4D")),false);
            assertEquals(root.POP(CC("4D")),false);
            assertEquals(root.DOWN(CC("4D")),false);
            
            System.out.println(root.toString());
            assertEquals(root.DOWN(CC("11S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S35(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("5D"), CC("10D")),false);
            assertEquals(root.FINISH(CC("5D")),false);
            assertEquals(root.POP(CC("5D")),false);
            assertEquals(root.DOWN(CC("5D")),false);
            
            assertEquals(root.FINISH(CC("3H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                
    }
    public void S36(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("6D"), CC("9D")),false);
            assertEquals(root.FINISH(CC("6D")),false);
            assertEquals(root.POP(CC("6D")),false);
            assertEquals(root.DOWN(CC("6D")),false);
            
            assertEquals(root.FINISH(CC("4H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S37(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("7D"), CC("8D")),false);
            assertEquals(root.FINISH(CC("6D")),false);
            assertEquals(root.POP(CC("6D")),false);
            assertEquals(root.DOWN(CC("6D")),false);
            
            assertEquals(root.FINISH(CC("5H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S38(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("8S"), CC("7D")),false);
            assertEquals(root.FINISH(CC("7D")),false);
            assertEquals(root.POP(CC("7D")),false);
            assertEquals(root.DOWN(CC("7D")),false);
            
            assertEquals(root.FINISH(CC("6H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                        
        
    }
    public void S39(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("2S"), CC("1D")),false);
            assertEquals(root.FINISH(CC("2S")),false);
            assertEquals(root.POP(CC("2S")),false);
            assertEquals(root.DOWN(CC("2S")),false);
            
            assertEquals(root.FINISH(CC("7H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
    }
    public void S40(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("3S"), CC("2D")),false);
            assertEquals(root.FINISH(CC("3S")),false);
            assertEquals(root.POP(CC("3S")),false);
            assertEquals(root.DOWN(CC("3S")),false);
            
            assertEquals(root.FINISH(CC("7C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
    }
    public void S41(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("4S"), CC("3D")),false);
            assertEquals(root.FINISH(CC("4S")),false);
            assertEquals(root.POP(CC("4S")),false);
            assertEquals(root.DOWN(CC("4S")),false);
            
            assertEquals(root.FINISH(CC("8C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                        
    }
    public void S42(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("5S"), CC("4D")),false);
            assertEquals(root.FINISH(CC("5S")),false);
            assertEquals(root.POP(CC("5S")),false);
            assertEquals(root.DOWN(CC("5S")),false);
            
            assertEquals(root.FINISH(CC("8D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                        
    }
    public void S43(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("6S"), CC("5D")),false);
            assertEquals(root.FINISH(CC("6S")),false);
            assertEquals(root.POP(CC("6S")),false);
            assertEquals(root.DOWN(CC("6S")),false);
            
            assertEquals(root.FINISH(CC("9D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
    }
    public void S44(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("7S"), CC("6D")),false);
            assertEquals(root.FINISH(CC("7S")),false);
            assertEquals(root.POP(CC("7S")),false);
            assertEquals(root.DOWN(CC("7S")),false);
            
            assertEquals(root.POP(CC("13D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
    }
    public void S45(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("8H"), CC("7C")),false);
            assertEquals(root.FINISH(CC("7C")),false);
            assertEquals(root.POP(CC("7C")),false);
            assertEquals(root.DOWN(CC("7C")),false);
            
            assertEquals(root.FINISH(CC("8H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
    }
    public void S46(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("9C"), CC("8H")),false);
            assertEquals(root.FINISH(CC("8H")),false);
            assertEquals(root.POP(CC("8H")),false);
            assertEquals(root.DOWN(CC("8H")),false);
            
            assertEquals(root.FINISH(CC("9C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
    }
    public void S47(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("9C"), CC("8H")),false);
            assertEquals(root.FINISH(CC("9C")),false);
            assertEquals(root.POP(CC("8H")),false);
            assertEquals(root.DOWN(CC("9C")),false);
            
            assertEquals(root.FINISH(CC("10D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
    }
    public void S48(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("2S"), CC("1D")),false);
            assertEquals(root.FINISH(CC("2S")),false);
            assertEquals(root.POP(CC("2S")),false);
            assertEquals(root.DOWN(CC("2S")),false);
            
            assertEquals(root.FINISH(CC("9H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
    }
    public void S49(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("3S"), CC("2H")),false);
            assertEquals(root.FINISH(CC("3S")),false);
            assertEquals(root.POP(CC("3S")),false);
            assertEquals(root.DOWN(CC("3S")),false);
            
            assertEquals(root.FINISH(CC("10S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
    }
    public void S50(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("3S"), CC("2H")),false);
            assertEquals(root.FINISH(CC("3S")),false);
            assertEquals(root.POP(CC("3S")),false);
            assertEquals(root.DOWN(CC("3S")),false);
            
            assertEquals(root.FINISH(CC("10H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                        
    }
    public void S51(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("10C"), CC("9H")),false);
            assertEquals(root.FINISH(CC("9H")),false);
            assertEquals(root.POP(CC("9H")),false);
            assertEquals(root.DOWN(CC("9H")),false);
            
            assertEquals(root.FINISH(CC("10C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
    }
    public void S52(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("10C"), CC("9H")),false);
            assertEquals(root.FINISH(CC("9H")),false);
            assertEquals(root.POP(CC("9H")),false);
            assertEquals(root.DOWN(CC("9H")),false);
            
            assertEquals(root.FINISH(CC("11S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
    }
    public void S53(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("10C"), CC("9H")),false);
            assertEquals(root.FINISH(CC("9H")),false);
            assertEquals(root.POP(CC("9H")),false);
            assertEquals(root.DOWN(CC("9H")),false);
            
            assertEquals(root.FINISH(CC("11C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                              
    }
    public void S54(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("10C"), CC("9H")),false);
            assertEquals(root.FINISH(CC("9H")),false);
            assertEquals(root.POP(CC("9H")),false);
            assertEquals(root.DOWN(CC("9H")),false);
            
            assertEquals(root.FINISH(CC("11D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                               
    }
    public void S55(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("10C"), CC("9H")),false);
            assertEquals(root.FINISH(CC("9H")),false);
            assertEquals(root.POP(CC("9H")),false);
            assertEquals(root.DOWN(CC("9H")),false);
            
            assertEquals(root.FINISH(CC("11H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                               
    }
    public void S56(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("10C"), CC("9H")),false);
            assertEquals(root.FINISH(CC("9H")),false);
            assertEquals(root.POP(CC("9H")),false);
            assertEquals(root.DOWN(CC("9H")),false);
            
            assertEquals(root.FINISH(CC("12D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                               
    }
    public void S57(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("10C"), CC("9H")),false);
            assertEquals(root.FINISH(CC("9H")),false);
            assertEquals(root.POP(CC("9H")),false);
            assertEquals(root.DOWN(CC("9H")),false);
            
            assertEquals(root.FINISH(CC("12H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                               
    }
    public void S58(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("10C"), CC("9H")),false);
            assertEquals(root.FINISH(CC("9H")),false);
            assertEquals(root.POP(CC("9H")),false);
            assertEquals(root.DOWN(CC("9H")),false);
            
            assertEquals(root.FINISH(CC("12S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                              
    }
    public void S59(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("10C"), CC("9H")),false);
            assertEquals(root.FINISH(CC("9H")),false);
            assertEquals(root.POP(CC("9H")),false);
            assertEquals(root.DOWN(CC("9H")),false);
            
            assertEquals(root.FINISH(CC("12C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                               
    }
    public void S60(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("13C"), CC("13S")),false);
            assertEquals(root.FINISH(CC("2H")),false);
            assertEquals(root.POP(CC("1H")),false);
            assertEquals(root.DOWN(CC("1H")),false);
            
            assertEquals(root.FINISH(CC("13S")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
        
    }
    public void S61(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("13C"), CC("13S")),false);
            assertEquals(root.FINISH(CC("2H")),false);
            assertEquals(root.POP(CC("1H")),false);
            assertEquals(root.DOWN(CC("1H")),false);
            
            assertEquals(root.FINISH(CC("13C")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                               
    }
    public void S62(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("13C"), CC("13S")),false);
            assertEquals(root.FINISH(CC("2H")),false);
            assertEquals(root.POP(CC("1H")),false);
            assertEquals(root.DOWN(CC("1H")),false);
            
            assertEquals(root.FINISH(CC("13H")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                              
    }
    public void S63(World root) {
        try {
            Finisher f1= root.F;
            Finisher f2= root.P.Synthesize_Finisher();
            assertEquals(f1.Equals(f2),true);
            assertEquals(root.CONNECT(CC("13C"), CC("13S")),false);
            assertEquals(root.FINISH(CC("2H")),false);
            assertEquals(root.POP(CC("1H")),false);
            assertEquals(root.DOWN(CC("1H")),false);
            
            assertEquals(root.FINISH(CC("13D")),true);  //Action
        }catch(Exception e) { System.out.println(e.toString());}                                       
        
    }
    
}
