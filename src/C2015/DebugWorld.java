/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C2015;

import java.util.Vector;

/**
 *
 * @author easterday
 */
public class DebugWorld extends World{
    private final Problem MyFirstProblem;
    public Vector<Problem> AncestorP;
    public Vector<Problem> realloc_AncestorP() {
        Vector<Problem> ret=new Vector<Problem>();
        for (Problem elem: AncestorP) {
            ret.add(elem);
        }
        return ret;
    }
    public DebugWorld(Problem PP,Vector<Integer> HH,Vector<Problem> AncP,Problem FirstP) {
        super(PP,HH);
        AncestorP=AncP;
        MyFirstProblem=FirstP;
    }
    public DebugWorld(Problem PP, Vector<Integer> HH,Vector<Problem> AncP) {
        super(PP,HH);
        MyFirstProblem=PP.copy();
        AncestorP=AncP;
    }
    public DebugWorld(Problem PP) {
        this(PP,new Vector<Integer>(), new Vector<Problem>());   
    }
    public DebugWorld(Problem PP,Vector<Integer> HH) {
        super();
        MyFirstProblem=PP.copy();
        try {
            P=SHistory.MakeProblem(new World(PP.copy()), HH);
        }catch(Exception ex) {
            System.out.println(ex);
        }
        F=P.Synthesize_Finisher();
        History=HH;
        AncestorP= SHistory.MakeAncestorP(PP, HH);
    }
    public DebugWorld(int i) {
        super(i);
        MyFirstProblem= P.copy();
        AncestorP=new Vector<Problem>();
    }
    public DebugWorld(Problem PP,Finisher FF,Vector<Integer> HH) {
        this(PP,HH);
        Finisher checkF=P.Synthesize_Finisher();
        if (!checkF.Equals(FF)) {
            System.out.println("Corruptive Problem");
            System.exit(101);
        }
    }
    public DebugWorld copy() {
        return new DebugWorld(P.copy(), realloc_History(),realloc_AncestorP(),MyFirstProblem);
    }
    private static Vector<Problem> bfChangeAncestorP=null;
    protected void ResumeWorld() {
        super.ResumeWorld();
        AncestorP= bfChangeAncestorP;        
    }
    protected void ResumeWorld(Problem PP,Vector<Integer> HH,Vector<Problem> AncP) {
        super.ResumeWorld();
        AncestorP= AncP;
    }
    @Override
    public boolean MOVELINE(int srcLine,int dstLine) {
        boolean ret= super.MOVELINE(srcLine, dstLine);
        if (ret)
            AncestorP.add(BeforeChange);
        return ret;
    }
    @Override
    public boolean MOVELINE(Card High,Card Low) {
		int srcLine= P.QuickWhereIs(Low);
		int dstLine= P.QuickWhereIs(High);
		return MOVELINE(srcLine,dstLine);
    }
    @Override
    public boolean CONNECT(Card upper,Card lower) {
        boolean ret= super.CONNECT(upper, lower);
        if (ret)
            AncestorP.add(BeforeChange);
        return ret;
    }
    @Override 
    public boolean FINISH(Card that) {
        boolean ret= super.FINISH(that);
        if (ret)
            AncestorP.add(BeforeChange);
        return ret;
    }
    @Override
    public boolean POP(Card that) {
        boolean ret=super.POP(that);
        if (ret)
            AncestorP.add(BeforeChange);
        return ret;
    }
    @Override
    public boolean _DOWN(Card that,int dstLine) {
        boolean ret= super._DOWN(that, dstLine);
        if (ret)
            AncestorP.add(BeforeChange);
        return ret;        
    }
    public Problem GetMyFirstProblem() {
        return MyFirstProblem;
    }
    
    
    
    
}
