package C2015;

import java.util.Vector;

public class World {
	public Problem P;
	public Finisher F;
	public Vector<Integer> History;
	public Vector<Integer> realloc_History(){
		Vector<Integer> ret=new Vector<Integer>();
		int sz=History.size();
		for (int i=0; i<sz; i++) {
			ret.add(History.get(i));
		}
		return ret;
	}
	protected World() {}
	public World(int i){
		P=new Problem(i);
		try {
		System.out.println(""+P.IsValid());
		}catch(Exception ex) {System.out.println(ex);}
		F=P.Synthesize_Finisher();
		History=new Vector<Integer>();		
	}
	public World(Problem PP) {
		this(PP,new Vector<Integer>());
	}
	public World(Problem PP,Vector<Integer> HH) {
		//if (!PP.IsValid())		
		//		throw new Exception("Corruptive Problem\r\n"+ P.toString() );
		P=PP;
		F=P.Synthesize_Finisher();
		History=HH;
	}
	public World(Problem PP,Finisher FF,Vector<Integer> HH) {
		this(PP,HH);
		F=FF;
	}
	public World copy(){
		return new World(P.copy(),F.copy(),realloc_History());
	}
	private boolean CheckFinish() { //有可以直接上牌時,傳回falses
		int sz=P.GetBuffer().size();
		for (int i=0; i<sz; i++) {
			if (F.Needed(P.GetBuffer().get(i)))
				return false;
		}
		for (int i=1; i<=8; i++) {
			Card hand=P.Peek(i);
			if (hand!=null) {
				if (F.Needed(hand))
					return false;
			}
		}
		return true;
	}
	private static Problem BeforeChange=null;
	private static Vector<Integer> bfChangeHistory=null;
	private void ReserveWorld() {
		BeforeChange=P.copy();
		bfChangeHistory=realloc_History();		
	}
	private void ResumeWorld() {
		P=BeforeChange;
		History=bfChangeHistory;
	}
	public void ResumeWorld(Problem PP,Vector<Integer> HH) {
		P=PP; History=HH;
	}
	public boolean MOVELINE(int srcLine,int dstLine) {
		Problem ML_BeforeChange=P.copy();
		Vector<Integer> ML_BeforeHistory=realloc_History();
		Vector<Card> hand;
		Integer Insert;
		Card dstCard=P.Peek(dstLine);
		if (dstCard!=null) {
			hand=Gamer.GetDragonDestNotNull(P,srcLine,dstCard);
			Insert=SHistory.MoveLine_ToNum(dstCard, P.Peek(srcLine));
		}else {
			hand=Gamer.GetDragonDestIsNull(P,srcLine);
			Insert=SHistory.MoveLine_ToNum(null, P.Peek(srcLine));
		}
		boolean flag;
		for (Card elem: hand) {
			flag=P.Put(elem, dstLine);
			if (!flag) {
				ResumeWorld(ML_BeforeChange,ML_BeforeHistory);
				return false;
			}
		}
		P.normarr=null; 
		History.add(Insert);
		return true;
	}
	public boolean MOVELINE(Card High,Card Low) {
		int srcLine= P.QuickWhereIs(Low);
		int dstLine= P.QuickWhereIs(High);
		return MOVELINE(srcLine,dstLine);
	}
	public boolean Equals(World that) {
		return P.equals(that.P);
	}
	public boolean ValueEquals(World that) {
		return P.ValueEquals(that.P);
	}
	public boolean CONNECT(Card upper,Card lower) {
		ReserveWorld();
		Card hand=null;
		if (Problem.Rule(upper, lower)) {
			int dstLine=P.QuickWhereIs(upper);
			int srcLine=P.QuickWhereIs(lower);
			if (dstLine>=1) {
				if (srcLine==0)
					hand=P.FetchBuffer(lower);
				else if (srcLine>=1) 
					hand=P.Fetch(srcLine);
				else
					return false; //因為沒動到牌局所以不必ResumeWorld
				if (P.Put(hand,dstLine)) {
					Integer Insert= SHistory.Connect_ToNum(upper, lower);
					History.add(Insert);
					P.normarr=null;
					return true;
				}else {
					if (srcLine==0)
						P.PutBuffer(hand);
					else
						P.Put(hand, srcLine);
					return false;
				}					
			}
		}
		if (hand!=null)
			ResumeWorld();
		return false;
	}
	public boolean FINISH(Card that) {
		ReserveWorld();
		Card hand=null;
		if (F.Needed(that)) {
			if (P.GetBuffer().Search(that)) {
				hand=P.FetchBuffer(that);
			}else {
				int srcLine=P.QuickWhereIs(that);
				if (srcLine>=1)
					hand=P.Fetch(srcLine);
				else
					return false;
			}
			if (F.add(hand)) {
				Integer Insert=SHistory.Finish_ToNum(hand);
				History.add(Insert);
				P.normarr=null;
				return true;
			}
		}
		if (hand!=null)
			ResumeWorld();
		return false;
	}
	public boolean POP(Card that) {
		ReserveWorld();
		Card hand=null;
		if (P.GetBuffer().Available()>0) {
			int srcLine=P.QuickWhereIs(that);
			if (srcLine>=1) {
				hand=P.Fetch(srcLine);
				if (P.PutBuffer(hand)) {
					Integer Insert=SHistory.Pop_ToNum(that);
					History.add(Insert);
					P.normarr=null;
					return true;
				}
			}
		}else {
			int dstLine=P.FirstBlankLine();
			if (dstLine>=1) {
				int srcLine=P.QuickWhereIs(that);
				if (srcLine>=1) {
					hand=P.Fetch(srcLine);
					if (P.Put(hand, dstLine)) {
						Integer Insert=SHistory.Down_ToNum(that);
						History.add(Insert);
						P.normarr=null;
						return true;
					}
				}					
			}
		}
		if (hand!=null)
			ResumeWorld();
		return false;
	}
	public boolean _DOWN(Card that,int dstLine) {
		ReserveWorld();
		Card hand=null;
		if (dstLine>=1 && dstLine<=8 && P.Peek(dstLine)==null) {
			int srcLine=P.QuickWhereIs(that);
			if (srcLine>=1 && this.P.GetNowMaxPos(srcLine)>=2) {
				hand=P.Fetch(srcLine);
			}else if (srcLine==0)
				hand=P.FetchBuffer(that);
			else
				return false; //沒有動到牌局
			if (P.Put(hand, dstLine)) {
				Integer Insert=SHistory.Down_ToNum(that);
				History.add(Insert);
				P.normarr=null;
				return true;
			}
		}
		if (hand!=null)
			ResumeWorld();
		return false;
	}
	public boolean DOWN(Card that) {
		int BL=P.FirstBlankLine();
		if (P.QuickWhereIs(that)>=0 && BL>=1) {
			return _DOWN(that,BL);
		}
		return false;
	}
	public boolean AutoSafeUp(){
		if (this.isComplete())
			return true;
		boolean flag,ret=false;
		do 
		{
			flag=false;
			Vector<Card> Hand=Gamer.L1b(this);
			for(Card elem :Hand)  {
				if (F.Needed(elem)) {
					if (F.SafeCardUp(elem)) {
						if (FINISH(elem)) {
							flag=true; ret=true;
						}	
					}
				}
			}
			for (int i=1; i<=8; i++) {
				Card hand=P.Peek(i);
				if (hand!=null && hand.Suit!=CardSuit.ERR) {
					if (F.Needed(hand)) {
						if (F.SafeCardUp(hand)) {
							flag=true; ret=true;
						}
					}
				}
			}				
		}while(flag);
		return ret;		
	}
	public boolean ALLUP() {
		boolean ret=false;
		while(World.UserFinish(this).size()>0) {
			if (AutoSafeUp())
				ret=true;
			for (int i=1; i<=13; i++) {
				for (CardSuit it : CardSuit.NormalSet) {
					Card that=CardDeck.GetCard(i,it);
					if (F.Needed(that)) {
						if (this.FINISH(that))
							ret=true;
					}
				}
			}
		}
		return ret;
	}
	public boolean isComplete(){
		for (CardSuit it : CardSuit.NormalSet) {
			if (F.Need(it)!=null)
				return false;
		}
		return true;
	}
	public String HistoryToString(int inn,boolean head) {
		StringBuffer ret=new StringBuffer();
		int sz=History.size();
		if (inn>=0 && inn<sz){
			if (head) {
				ret.append(String.format("HistoryFrom(%d):[", inn));				
			}
			for (int i=inn; i<sz; i++) {
				ret.append(SHistory.NumToString(History.get(i)));
				ret.append(';');
			}
			if (head) 
				ret.append("]\r\n");
			return ret.toString();
		}
		return ("HistoryToString: [EMPTY]\r\n");
	}
	public String toString() { return toString(true,true);}
	public String toString(boolean ShowHistory, boolean ShowFinisher) {
		StringBuffer ret=new StringBuffer();
		if (ShowHistory)
			ret.append(HistoryToString(0,true));
		if (ShowFinisher)
			ret.append("Finisher: "+F.toString()+"\r\n");
		ret.append(P.toString());
		return ret.toString();
	}
	public boolean isDead() {
		if (P.Available()>0)
			return false;
		int sz=P.GetBuffer().size();
		for (int i=0; i<sz; i++) {
			Card hand=P.GetBuffer().get(i);
			if (F.Needed(hand))
				return false;
			for (int j=1; j<=8; j++) {
				Card there=P.Peek(j);
				if (Problem.Rule(there, hand))
					return false;
			}
		}
		for (int i=1; i<=8; i++) {
			if (F.Needed(P.Peek(i)))
				return false;
			for (int j=1; j<=8; j++) {
				if (i!=j) {
					if (Problem.Rule(P.Peek(i), P.Peek(j)))
						return false;
				}
			}
		}
		return true;
	}
	public static Vector<Card> UserFinish(World inn) {
		Vector<Card> ret=new Vector<Card>();
		World inW=inn.copy();
		boolean flag;
		do {
			flag=false;
			for (int i=0; i< inW.P.GetBuffer().size(); i++) {
				Card hand=inW.P.GetBuffer().get(i);
				if (inW.F.Needed(hand)) {
					if (inW.FINISH(hand)) {
						ret.add(hand);
						flag=true;
						break;
					}
				}
			}
			for (int i=1; i<=8; i++) {
				Card hand=inW.P.Peek(i);
				if (hand!=null && hand.Suit!=CardSuit.ERR) {
					if (inW.F.Needed(hand)) {
						if (inW.FINISH(hand)) {
							ret.add(hand);
							flag=true;
						}
					}
				}
			}
		}while(flag);
		return ret;
	}
	public String GetBufStrings() {
		StringBuffer ret=new StringBuffer();
		int sz=P.GetBuffer().size();
		for (int i=0; i<sz-1; i++)
			ret.append(P.GetBuffer().get(i).toString(0)+",");
		ret.append(P.GetBuffer().get(sz-1).toString(0));
		return ret.toString();
	}
	public String GetStrings(int LineNum){
		if (P.normarr==null)
			P.Normalize();
		return GetString(P.normarr,LineNum);
	}
	public static String GetString(Card[][] norm,int LineNum) {
		if (LineNum>=1 && LineNum<=8) {
			Vector<Card> ret=new Vector<Card>();
			for (int row=0; row<21; row++) {
				if (norm[LineNum-1][row]!=null)
					ret.add(norm[LineNum-1][row]);
				else
					break;
			}
			StringBuffer buf=new StringBuffer();
			if (ret.size()>0) {
				for (int i=0; i<ret.size()-1; i++) {
					buf.append(ret.get(i).toString(0)+",");
				}
				buf.append(ret.get(ret.size()-1).toString(0));
			}
			return buf.toString();
		}
		return null;  //GetString Has Error Input
	}
	public static String HistoryIntoNUmbers(Vector<Integer> inn) {
		StringBuffer ret=new StringBuffer("'");
		if (inn.size()>0) {
			for (int i=0; i< inn.size()-1; i++) {
				ret.append(inn.get(i).toString()+",");
			}
			ret.append(inn.get(inn.size()-1).toString());
		}
		ret.append("#");
		ret.append("'");
		return ret.toString();
	}
	public static Vector<Card> ParseString(String inn) {
		Vector<Card> ret=new Vector<Card>();
		String[] split=inn.split(",#");		
		for (String s: split) {
			if (s.length()>0)
				ret.add(CardDeck.GetCard(s));
			else
				break;
		}			
		return ret;		
	}
	public static Problem SynthesizeProblemFromNineStrings(String B,
	String S1,String S2,String S3,String S4,String S5,String S6,String S7,String S8) {
		Vector<Card> BCard=ParseString(B);
		Vector<Card>[] ALLCard= new Vector[8];
		ALLCard[0]= ParseString(S1); ALLCard[1]=ParseString(S2);
		ALLCard[2]= ParseString(S3); ALLCard[3]=ParseString(S4);
		ALLCard[4]= ParseString(S5); ALLCard[5]=ParseString(S6);
		ALLCard[6]= ParseString(S7); ALLCard[7]=ParseString(S8);
		Buffer retMB=new Buffer();
		for (Card that : BCard)
			retMB.Add(that);
		Card[][] newcardarr=new Card[8][21];
		for (int i=0; i<8; i++) {
			for (int j=0; j<21; j++) {
				if (j < ALLCard[i].size())
					newcardarr[i][j]=ALLCard[i].get(j);
				else
					newcardarr[i][j]=null;
			}
		}
		return new Problem(newcardarr,retMB);
	}
	public static Vector<Integer> ParseHistory(String inn) {
		Vector<Integer> ret=new Vector<Integer>();
		String[] split=inn.split(",#");
		for (String s:split) {
			if (s.length()>0)
				ret.add(Integer.valueOf(s));
			else
				break;
		}
		return ret;
	}
	public String GetWorldInOneString() {
		StringBuffer ret=new StringBuffer("'");
		ret.append(GetBufStrings());
		ret.append('B');
		for (int i=1; i<=8; i++) {
			ret.append(GetStrings(i));
			ret.append('#');
		}
		ret.append(')');
		return ret.toString();		
	}
    public static Problem SynthesizeProblemFromOneString(String inn) {
        if (inn.charAt(0)=='\'' && inn.charAt(inn.length()-1)=='\'') {
            inn= inn.substring(1,inn.length()-1);   //startindex,endindex
            String[] that=inn.split("B");
            if (that.length==2) {
            	String B=that[0];
            	String[] hand=that[1].split("#");
            	if (hand.length==9) {
            		return SynthesizeProblemFromNineStrings(B,hand[0],hand[1],hand[2],hand[3],hand[4],hand[5],hand[6],hand[7]);
            	}
            }
        }
        return null;
    }
	
}
