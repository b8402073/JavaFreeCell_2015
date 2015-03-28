/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C2015;

import java.util.Vector;

/**
 * Debugger is designed as a new member of WorldExt;
 * Debug can provide the logging function for WorldExt to record all kinds of 
 * problems that are created after Sage.run();
 * When the Debugger of a WorldExt is null,we don't provide logging function.
 * In this scenario, we don't waste any resources.
 * @author easterday
 */
public class Debugger {
    private final Problem MyFirstProblem;
    private Vector<Problem> AncestorP;
    public Debugger(Problem MFP,Vector<Problem> AncP) {
        MyFirstProblem=MFP.copy();
        AncestorP= realloc_AncestorP(AncP);
    }
    public Debugger(Problem MFP) {
        MyFirstProblem=MFP.copy();
        AncestorP= new Vector<Problem>();
    }
    public Debugger copy() {
        return new Debugger(MyFirstProblem, AncestorP);
    }
    public void Add(Problem P) {
        AncestorP.add(P.copy());
    }
    public Problem get(int i) {
       if (i>=0 && i< AncestorP.size()) {
           return AncestorP.get(i).copy();
       }
       return null;
    }
    public Problem GetFirstProblem() { return MyFirstProblem;}
    public static Debugger MakeDebugger(Problem InitP,Vector<Integer> HH) {
        Vector<Problem> old= SHistory.MakeAncestorP(InitP, HH);
        if (old.get(0).Equals(InitP)) {
            old.remove(0);
            return new Debugger(InitP.copy(), old);
        }
       return null;        
    }
    public static Vector<Problem> realloc_AncestorP(Vector<Problem> inn) {
        Vector<Problem> ret=new Vector<Problem>();
        for (Problem elem: inn)
            ret.add(elem);
        return ret;
    }
    public int size() { return AncestorP.size();}
}
