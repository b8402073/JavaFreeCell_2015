package C2015;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//import JavaFreeCell.*;
import java.util.Vector;
import java.io.FileWriter;

//import static org.junit.Assert.*;
/**
 *
 * @author Home
 */
public class Verify {
    public static Vector<Integer> Sub(Vector<Integer> inn,int start) {
        int sz= inn.size();        
        if (start>0 && start<sz) {
            Vector<Integer> ret= new Vector<Integer>();
            for (int i=start; i<sz; i++) {
                ret.add(inn.get(i));
            }
            return ret;
        }else if (start==0) {
            return inn;
        }
        return null;
    }

    public static boolean Verify_Problem(Problem inn, Vector<Integer> H,Problem after) throws Exception {
        SHistory.Create();
        World root=new World(inn.copy());
        int sz= H.size();
        for (int i=0; i<sz; i++) {
            int that=H.get(i);
            Card CHigh=null, CLow=null, CHand=null;
            CardSuit CLowSuit=CardSuit.ERR;
            if (that>=2000) {
                CHigh=CardDeck.GetCard(that-2000);
                if (CHigh.IsRed) {
                    CLowSuit=CardSuit.SPADE;
                }else {
                    CLowSuit=CardSuit.HEART;
                }
                CLow= CardDeck.GetCard(CHigh.Value-1, CLowSuit);
                if (!root.CONNECT(CHigh, CLow)) {
                    System.out.println("Can't Connect at "+i);
                    return false;
                }                    
            }else if (that>=1000 && that<2000) {
                CHigh=CardDeck.GetCard(that-1000);
                if (CHigh.IsRed) {
                    CLowSuit= CardSuit.CLUB;                    
                }else {
                    CLowSuit= CardSuit.DIAMOND;
                }
                CLow= CardDeck.GetCard(CHigh.Value-1,CLowSuit);
                if (!root.CONNECT(CHigh, CLow)) {
                    System.out.println("Can't Connect at "+i);
                    return false;
                }                
            }else if ( that>=0 && that <=51) {
                CHand=CardDeck.GetCard(that);
                if (!root.FINISH(CHand)) {
                    System.out.println("Can't FINISH at "+i);
                    return false;
                }
            }else if ( that>=100 && that<=151) {
                CHand= CardDeck.GetCard(that-100);
                if (!root.POP(CHand)){
                    System.out.println("Cant't POP at "+i);
                    return false;
                }
            }else if (that >=200 && that<=251) {
                CHand= CardDeck.GetCard(that-200);
                if (!root.DOWN(CHand)) {
                    System.out.println("Can't DOWN at "+i);
                    return false;
                }                    
            }else {
                System.out.println("Unknown Move at "+i);
                return false;
            }
        }
        if (root.P.ValueEquals(after))
            return true;
        System.out.println("World isn't End.");
        return false;
    }
   
    public static boolean Total_Veryfy(DebugWorld inn) throws Exception { //如果World的AncestorP拿掉的話，這個函式就不能用了
        Problem PBNow=inn.P.copy();
        System.out.println("PBNow:");
        System.out.println(PBNow.toString());
        boolean ret=true;
        int i=0;
        for (Problem PP : inn.AncestorP) {
            if (Verify_Problem(PP,Sub(inn.History,i),PBNow))
                i++;
            else {
                System.out.println("Err AncP at "+i);
                System.out.println(PP.toString());
                ret=false;
                return false;
            }
        }
        return ret;
    }
    public static String ListProblemToString(Vector<Problem> inn,boolean ShowFinisher) throws Exception {
        StringBuffer ret=new StringBuffer();
        int sz=inn.size();
        if (sz>0)  {
            for (int i=0; i<sz; i++) {
                ret.append("<<"+i+">> Total Count="+sz+"\r\n");
                if (ShowFinisher) {
                    ret.append( inn.get(i).Synthesize_Finisher().toString()+"\r\n");
                }
                ret.append(inn.get(i).toString()+"\r\n");
            }
        }else {
            ret.append("Empty Count\r\n");
        } 
        return ret.toString();              
    }
    public static <T extends World>  String ListWorldToString(Vector<T> inn,boolean ShowHistory,boolean ShowFinisher,boolean ShowCardNumAndAV) {
        StringBuffer ret=new StringBuffer();
        int sz=inn.size();
        if (sz>0) {
            for (int i=0; i<sz; i++) {
                ret.append("<<"+i+">> Total Count="+sz+"\r\n");
                if (ShowCardNumAndAV) {
                    ret.append("CardNum="+inn.get(i).P.CardNum()+"  AV="+ Gamer.Total_Obstruction_AV(inn.get(i))+" Tail="+ Gamer.Tail(inn.get(i).History)+"\r\n");
                }
                ret.append(inn.get(i).toString(ShowHistory,ShowFinisher)+"\r\n");
            }
        }else {
            ret.append("Empty Count\r\n");
        }
        return ret.toString();
    }
    
    //public static Vector<WorldExt2> U2List() 暫時不作
    public static void WriteStringToText(String FileName,String inn)  {
        try {
            if (!FileName.endsWith(".txt") && !FileName.endsWith(".TXT"))
                FileName=FileName+".txt";
            FileWriter fw=new FileWriter(FileName);
            fw.write(inn);
            fw.flush();
            fw.close();
        }catch(Exception ex) {
            System.out.println(ex);
        }
    }
    public static <T extends World>  int Locate1(Vector<T> V,T that) {
        if (V!=null && V.size()>0) {
            for (int i=0; i<V.size(); i++) {
                if (V.get(i).ValueEquals(that))
                    return i;
            }
        }
        return -1;
    }
    public static <T extends World> int Locate2(Vector<T> V,Problem that) {
        if (V!=null && V.size()>0) {
            for (int i=0; i<V.size(); i++) {
                if (V.get(i).P.ValueEquals(that))
                    return i;
            }
        }
        return -1;
    }
    public static int Locate3(Vector<Problem> V,Problem that) {
        if (V!=null && V.size()>0) {
            for (int i=0; i<V.size(); i++) {
                if (V.get(i).ValueEquals(that)) 
                    return i;
            }
        }
        return -1;
    }
}
