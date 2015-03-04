/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C2015;

import java.util.Vector;
import java.util.Comparator;
/**
 *
 * @author easterday
 */
class CardNum_TotalAV<T extends World> implements Comparator<T> {
    public int compare(T X, T Y) {
        int x1= X.P.CardNum();
        int y1= Y.P.CardNum();
        if (x1<y1)
            return -1;
        else if (x1>y1)
            return 1;
        else {
            int x2=Gamer.Total_Obstruction_AV(X);
            int y2=Gamer.Total_Obstruction_AV(Y);
            if (x2<y2)
                return -1;
            else if (x2>y2)
                return 1;
            else {
                if (SHistory.BetterHistory(X.History, Y.History))
                    return -1;
                else if (SHistory.BetterHistory(Y.History, X.History))
                    return 1;
                else {
                    for (int i=0; i<X.History.size(); i++) {
                        int x3=X.History.get(i);
                        int y3=Y.History.get(i);
                        if (x3>y3)
                            return -1;
                        else if (x3<y3)
                            return 1;
                    }
                }
            }
        }
        return 0;
    }
    public boolean equals(Object obj) {
        return false;
    }
}
public class WorldExt extends World{
    public Vector<WorldExt> Child;
    //public static U<WorldExt> Universe=new U<WorldExt>();
    public static Comparator<WorldExt> CM=new CardNum_TotalAV<WorldExt>();
    public WorldExt(Problem PP) {
        super(PP,new Vector<Integer>());
        Child=null;                
    }
    public WorldExt(Problem PP,Vector<Integer> HH) {
        super(PP,HH); 
        Child=null;
    }
    public WorldExt(Problem PP,Finisher FF,Vector<Integer> HH) {
        super(PP,FF,HH);
        Child=null;
    }
    public WorldExt copy() {
        return new WorldExt(P.copy(), F.copy(), realloc_History());
    }
    public boolean ChildRoutine(boolean flag, WorldExt that, int Level,int HiLevel)    {
        if (flag) {
            if (!that.isDead()) {
                that.AutoSafeUp();
                if (that.isComplete()){
                    Child.add(that);
                    return true;
                }else if (Level>=HiLevel) {
                    Child.add(that);
                    return false;
                }else if (!U<WorldExt>.Exist(that)) {
                    U<WorldExt>.Add(that);
                    Child.add(that);
                    return false;
                }else {  //如果Universe contain that
                    return false;    
                }
            }
        }
        return false;
    }
    public Vector<WorldExt> makeChild(int Level) {
        return makeChild(Level,120,null);
    }
    public Vector<WorldExt> makeChild(int Level,int HiLevel,String Prefix) {
        Child=new Vector<WorldExt>();
        if (!makeChild0(Level,HiLevel)) {
            if (!makeChild1(Level,HiLevel)) {
                if (!makeChild2(Level,HiLevel)) {
                    if (!makeChild3B(Level,HiLevel)) {
                        if (!makeChild3A(Level,HiLevel)) {
                            if (!makeChild4(Level,HiLevel)) {
                                makeChild5(Level,HiLevel);
                            }
                        }
                    }
                }
            }
        }
        if (Prefix!=null) {
            String FN=("C:\\Tmp\\"+Prefix+"_"+Level+"_beforeSort.txt");
            Verify.WriteStringToText(FN, Verify.ListWorldToString(Child, true, true, true));
        }
        Child.sort(CM);
        return Child;
    }
    public boolean makeChild0(int Level,int HiLevel) {
        int i,j;
        for (i=1; i<=8; i++) {
            for (j=1; j<=8; j++) {
                if (i!=j) {
                    //Problem.DebugProblem= this.P;
                    //Console.WriteLine("This\n"+this.toString());
                    WorldExt that=this.copy();
                    if (!ChildRoutine(that.MOVELINE(i, j),that,Level,HiLevel)) {
                        //Gamer.assert(this.P.Equals(Problem.DebugProblem),"Error in MOVELINE");
                        //System.out.println("That\n"+ that.toString());
                        continue;
                    }else
                        return true;
                }
            }
        }
        return false;
    }
    public boolean makeChild1(int Level, int HiLevel) { //CONNECT(8,8)
        for (int i=1; i<=8; i++) {
            for (int j=1; j<=8; j++) {
                if (i!=j) {
                    Card upper=this.P.Peek(i);
                    Card lower=this.P.Peek(j);
                    if (upper!=null && lower!=null &&
                        upper.Suit!=CardSuit.ERR &&
                        lower.Suit!=CardSuit.ERR) {
                        if (Problem.Rule(upper, lower)) {
                            WorldExt that=this.copy();
                            if (!ChildRoutine(that.CONNECT(upper, lower),that,Level,HiLevel)) {
                                //System.out.println("That\n"+that.toString());
                                //Gamer.assert(this.P.Equals(Problem.DebugProblem),"Error in Connect(8,8)");
                                continue;
                            }else {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean makeChild2()
    
}
