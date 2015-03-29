package C2015;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.Random;
import java.lang.Math;

class CPLine implements Comparator<Card[]> {
    static public int size(Card[] inn) {
		int ret=0;
		while(inn[ret]!=null && ret<21) {
			++ret;
		}
		if (ret<21)
			return ret;
		else
			return 21;
	}
	public int compare(Card[] L1, Card[] L2) {
		Comparator<Card> tmp=Buffer.cp;
		int C1=size(L1);
		int C2=size(L2);
		if (C1>C2) 
			return -1;
		else if (C1<C2)
			return 1;
		if (C1==C2 && C1==0)
			return 0;
		else
			return tmp.compare(L1[0],L2[0]);	
	}

	public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
			Function<? super T, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T, U> Comparator<T> comparing(
			Function<? super T, ? extends U> arg0, Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingDouble(
			ToDoubleFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingLong(ToLongFunction<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsFirst(Comparator<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsLast(Comparator<? super T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Card[]> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Card[]> thenComparing(Comparator<? super Card[]> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U extends Comparable<? super U>> Comparator<Card[]> thenComparing(
			Function<? super Card[], ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U> Comparator<Card[]> thenComparing(
			Function<? super Card[], ? extends U> arg0,
			Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Card[]> thenComparingDouble(
			ToDoubleFunction<? super Card[]> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Card[]> thenComparingInt(
			ToIntFunction<? super Card[]> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Card[]> thenComparingLong(
			ToLongFunction<? super Card[]> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
public class Problem {
	private Card[][] cardarr;
	public  Card[][] normarr=null;
       public  String SHA=null;
	private Byte[]   NowMaxPos;
	private Buffer   MB;
	public  static Comparator<Card[]> cp=new CPLine();
	public int GetNowMaxPos(int Line) {
		if (Line>=1 && Line<=8) {
			return NowMaxPos[Line-1];
		}
		return -1;
	}
	public Buffer GetBuffer() {return MB;}
	public Card PeekCard(int col, int row) {
		if (col>=1 && col<=8 && row>=0 && row < NowMaxPos[col-1]) {
			return cardarr[col-1][row];		
		}
		return CardDeck.errCard;
	}
	private void Upd_NowMaxPos() {
		for (int i=0; i<8; i++) {
			Byte j=0;
			while((cardarr[i][j]!=null)) {
				++j;
			};
			NowMaxPos[i]=j;
		}
	}
	public Problem(Card[][] inn1, Byte[] inn2, Buffer inn3) {
		cardarr=new Card[8][21];
		NowMaxPos=new Byte[8];
		for (int i=0; i<8; i++) {
			int j;
			for (j=0; j<21; j++) {
				cardarr[i][j]=inn1[i][j];
			}
			while(j<21) {
				cardarr[i][j]=null;
				j+=1;
			}
		}
		for (int a=0; a<8; a++) {
			NowMaxPos[a]=inn2[a];
		}
		MB=inn3;
	////暫時這樣設計:copy動作時一律不理normarr,等到有需要才做Normalize()動作
	}
	public Problem copy() { return new Problem(cardarr,NowMaxPos,MB.copy()); }
	public Problem(int inn) {
		cardarr=new Card[8][21];
		NowMaxPos=new Byte[8];
		MB=new Buffer();
		int i,j;
        int wLeft = 52;
        Random Choose = new Random(inn);
        Card[] deck = new Card[52];
        for (i = 0; i < 52; i++)
        {
            deck[i] = CardDeck.GetCard(i);
        }
        for (i = 0; i < 52; i++)
        {
            j = Math.abs(Choose.nextInt()) % wLeft;  
            cardarr[i % 8][i / 8] = deck[j];
            wLeft--;
            deck[j] = deck[wLeft];
        }

        NowMaxPos[0] = 7;
        NowMaxPos[1] = 7;
        NowMaxPos[2] = 7;
        NowMaxPos[3] = 7;
        NowMaxPos[4] = 6;
        NowMaxPos[5] = 6;
        NowMaxPos[6] = 6;
        NowMaxPos[7] = 6;
        normarr = null;		
	}
	public Problem(Card[][] inn, Buffer buf) {
		cardarr=new Card[8][21];
		NowMaxPos=new Byte[8];
		for (int i=0; i<8; i++) {
			for (int j=0; j<21; j++) {
				cardarr[i][j]=inn[i][j];
			}
		}
		Upd_NowMaxPos();
		MB=buf;
		normarr=null;
	}
	public static boolean Rule(Card upper,Card lower) {
		if (upper==null && lower!=null)
			return true;
		if (upper.Value - lower.Value==1 && upper.IsRed != lower.IsRed)
			return true;
		return false;
	}
	public Card Peek(int SrcLine){
		if (SrcLine>=1 && SrcLine<=8) {
			if (NowMaxPos[SrcLine-1]>0) {
				return cardarr[SrcLine-1][NowMaxPos[SrcLine-1]-1];
			}
		}
		return null;	
	}
	public Card Fetch(int SrcLine) {
		Card ret=null;
		if (SrcLine>=1 && SrcLine<=8) {
			if (NowMaxPos[SrcLine-1]>0) {
				if (cardarr[SrcLine-1][NowMaxPos[SrcLine-1]-1]!=null) {
					ret= cardarr[SrcLine-1][NowMaxPos[SrcLine-1]-1];
					cardarr[SrcLine-1][NowMaxPos[SrcLine-1]-1]=null;
					--NowMaxPos[SrcLine-1];	
				}
			}
		}
		return ret;
	}
	public Card FetchBuffer(Card that) {
		if (that!=null) {
			if (MB.Search(that)) {
				MB.Remove(that);
				return that;
			}
		}
		return null;
	}
	public boolean Put(Card that,int Line) {
		if (NowMaxPos[Line-1]<=19) {
			if (that!=null && Line>=1 && Line<=8 ) {
				cardarr[Line-1][NowMaxPos[Line-1]]=that;
				++NowMaxPos[Line-1]; 
				return true;
			}					
		}
		return false;
	}
	public boolean PutBuffer(Card that) {
		if (MB.Available()>0 && !MB.Search(that)) 
			return MB.Add(that);
		return false;
	}
	public boolean Pop(int Line) {
		Card that=Fetch(Line);
		if (that!=null) {
			if (MB.Available()>=1) {
				return MB.Add(that);
			}else if (HowManyBlankLines()>=1 ) {
				int tmp=FirstBlankLine();
				return Put(that,tmp);
			}
		}
		return false;		
	}
	public boolean Move(int srcLine,int dstLine) {
		if (srcLine>=1 && srcLine<=8 && dstLine>=1 && dstLine<=8) {
			Card upper=Peek(dstLine);
			Card lower=Peek(srcLine);
			if (Problem.Rule(upper, lower)) {
				lower=Fetch(srcLine);
				return Put(lower,dstLine);
			}
		}
		return false;
	}
	public boolean Down(Card that,int dstLine) {
		if (dstLine>=1 && dstLine<=8 && that!=null) {
			Card there= FetchBuffer(that);
			if (there!=null) {
				if (Peek(dstLine)==null)
					return Put(that,dstLine);
				else
					PutBuffer(there);
			}
		}
		return false;
	}
	public int Available() { return MB.Available()+ HowManyBlankLines();}
	public Card CARDFUNCTION(Card thatcard,int delta) {
		if (thatcard==null)
			return null;
		int sz=MB.size();
		if (sz>0) {
			for (int x=0; x<sz; x++) {
				if (MB.get(x).Equals(thatcard))
					return null;
			}
		}
		int i,j=0;
		boolean found=false;
		for (i=0; i<8; i++) {
			if (NowMaxPos[i]>0) {
				for (j=0; j< NowMaxPos[i]; j++) {
					if (cardarr[i][j].Equals(thatcard)) {
						found=true;
						break;
					}
				}
				if (found)
					break;
			}
		}
		if (j+delta>=0 && j+delta<=20)
			return cardarr[i][j+delta];
		else
			return null;
	}
	public int WhereIs(Card thatcard) {
		if (thatcard!=null && thatcard.Suit!=CardSuit.ERR) {
			for (int i=0; i<8; i++) {
				for (int j=NowMaxPos[i]-1; j>=0; j--) {
					if (thatcard.Equals(cardarr[i][j]))
						return (i+1);
				}
			}
			int sz=MB.size();
			for (int i=0; i<sz; i++) {
				if (thatcard.Equals(MB.get(i)))
					return 0;
			}
		}
		return -1;
	}
	public Card AHead(Card that) throws Exception{
		int srcLine=WhereIs(that);
		if (srcLine>=1 && srcLine<=8) {
			int sz=NowMaxPos[srcLine-1];
			for (int i=0; i<sz; i++) {
				if (that.Equals(cardarr[srcLine-1][i])) {
					if (i!=0)
						return cardarr[srcLine-1][i-1];
					else
						return null;
				}
			}
		}
		if (srcLine==0)
			throw new Exception("This card is at MyBuffer");
		throw new Exception("This card is not in the Problem");
	}
	public int CardNum() {
		int sum=0;
		for (int i=0; i<8; i++) {
			sum += NowMaxPos[i];
		}
		sum += MB.size();
		return sum;
	}
	public int POSITION(Card thatcard) {
		return POSITION(thatcard,WhereIs(thatcard));
	}
	public int POSITION(Card thatcard,int srcLine) {
		if (srcLine>=1 && srcLine<=8) {
			if (thatcard!=null && thatcard.Suit!=CardSuit.ERR) {
				for (int i=0; i<NowMaxPos[srcLine-1];i++) {
					if (thatcard.Equals(cardarr[srcLine-1][i]))
						return i;						
				}
			}
		}
		return -1;
	}
	public Vector<Byte> BlankLine() {
		Vector<Byte> ret=new Vector<Byte>();
		for (int i=0;i<8; i++) {
			if (NowMaxPos[i]==0)
				ret.add((byte) (i+1));
		}
		return ret;
	}
	public Vector<Byte> OneCardLine() {
		Vector<Byte> ret=new Vector<Byte>();
		for (int i=0; i<8; i++) {
			if (NowMaxPos[i]==1)
				ret.add((byte) (i+1));
		}
		return ret;			
	}
	public int FirstBlankLine() {
		for (int i=0; i<8; i++) {
			if (NowMaxPos[i]==0)
				return (i+1);
		}
		return -1;
	}
	public int HowManyBlankLines() {
		int ret=0;
		for (int i=0; i<8; i++) {
			if (NowMaxPos[i]==0)
				ret +=1;
		}
		return ret;
	}
	public int HowManyOneCardLines() {
		int ret=0; 
		for (int i=0; i<8; i++) {
			if (NowMaxPos[i]==1)
				ret +=1;
		}
		return ret;
	}
	public int OneCardSum() {
		int ret=0;
		for (int i=0; i<8; i++) {
			if (NowMaxPos[i]==1) 
				ret += cardarr[i][0].Value;
		}
		return ret;
	}
	public int MaxOf_NowMaxPos() {
		int ret=0;
		for (int i=0; i<8; i++) {
			if (ret<NowMaxPos[i])
				ret= NowMaxPos[i];
		}
		return ret;
	}
	public int SecondOf_NowMaxPos() {
		Vector<Byte> tmp=new Vector<Byte>();
		for (int i=0; i<8; i++) 
			tmp.add((byte) NowMaxPos[i]);
		Collections.sort(tmp);
		return tmp.get(6);
	}
	public int SortOf_NowMaxPos(int Line) { //輸入1是最小值,輸入8是最大值
		if (Line>=1 && Line<=8) {
			Vector<Byte> tmp=new Vector<Byte>();
			for (int i=0; i<8; i++) {
				tmp.add((byte) NowMaxPos[i]);
			}
			Collections.sort(tmp);
			return tmp.get(Line-1);
		}
		return -1;
	}
	public String toString(){
		int m=MaxOf_NowMaxPos();
		StringBuffer ret=new StringBuffer(640);
		ret.append("Buffer: ");
		ret.append(MB.toString()+"\r\n");
		for (int row=0; row<=m; row++) {
			StringBuffer Line=new StringBuffer(80);
			for (int col=0; col<8; col++) {
				StringBuffer that=new StringBuffer();
				if (cardarr[col][row]!=null) {
					that.append("["+cardarr[col][row].toString()+"]");					
				}else {
					that.append("[@@@}");
				}
				Line.append(that);
			}
			Line.append("\r\n");
			ret.append(Line);
		}
		return ret.toString();
	}
       public String toString(int d) {
           StringBuffer ret=new StringBuffer();
           if (d==9) {
              ret.append("\"");
                for (int i=0; i<MB.size()-1; i++) {
                    ret.append(MB.get(i).toString(0)+",");
                }
                ret.append(MB.get(MB.size()-1).toString(0)+"#");
                ret.append("\"\n");                  
                for (int Line=1; Line<=8; Line++) {
                    ret.append("\"");  
                    for (int i=0; i< GetNowMaxPos(Line)-1; i++) {
                        ret.append(cardarr[Line-1][i].toString(0)+",");
                    }                    
                    ret.append(cardarr[Line-1][GetNowMaxPos(Line)-1].toString(0)+"#");
                    ret.append("\"\n");                  
                }
           }
           return ret.toString();
       }
	public void Print() { System.out.println(toString()); }
	public static boolean CompareCardArr(Card[][] thes, Card[][] that) {
        for (int i = 0; i < 8; i++)  {
            for (int j = 0; j < 21; j++)  {
                if (thes[i][j] == null && that[i][j] == null)
                    break;
                else                {
                    if (thes[i][j] != null) {
                        if (thes[i][j].Equals(that[i][j]) == false)
                            return false;
                    }
                    else
                        return false;
                }
            }
        }
        return true;		
	}
    public boolean Equals(Problem that)    {
        for (int i = 1; i <= 8; i++)        {
            int tmp1 = this.NowMaxPos[i - 1];
            int tmp2 = that.NowMaxPos[i - 1];
            if (tmp1 != tmp2) return false;
        }
        return (MB.Equals(that.MB) && CompareCardArr(this.cardarr, that.cardarr));
    }
    public boolean ValueEqualsOld(Problem that)    {
        if (!MB.Equals(that.MB))
            return false;
        Card[][] P1 = GetNormarr();
        Card[][] P2 = that.GetNormarr();
        if (P1 == null)
        {
            Normalize();
            P1 = GetNormarr();
        }
        if (P2 == null)
        {
            that.Normalize();
            P2 = that.GetNormarr();
        }
        return Problem.CompareCardArr(P1, P2);
    }
    public boolean ValueEquals(Problem that) {
        if (this.SHA==null)
            this.SHA();
        if (that.SHA==null)
            that.SHA();
        return this.SHA.equals(that.SHA);
    }
    public void Normalize() {
    	Vector<Card[]> tmp=new Vector<Card[]>();
    	for (int i=1; i<=8; i++) {
    		tmp.add(ColSynthesize(i));
    	}
    	tmp.sort(cp);
    	normarr=new Card[8][21];
    	for (int i=0; i<8; i++) {
    		Card[] that=tmp.get(i);
    		for (int j=0; j<21; j++) {
    			normarr[i][j]=that[j];
    		}
    	}
    }
    private Card[] ColSynthesize(int col) {
    	Card[] ret=new Card[21];
    	for (int i=0; i<21; i++) {
    		ret[i]= cardarr[col-1][i];
    	}
    	return ret;
    }
    
    private int Synthesize(CardSuit S) {
    	int ret=0;
    	for (int i=1; i<=13; i++) {
    		Card that=CardDeck.GetCard(i,S);
    		int L=WhereIs(that);
    		if (L<0)
    			ret=i;
    		else
    			break;
    	}
    	return ret;
    }
    public Finisher Synthesize_Finisher() {
    	Card[] arr=new Card[4];
    	arr[0]= CardDeck.GetCard(Synthesize(CardSuit.CLUB),CardSuit.CLUB);
    	arr[1]= CardDeck.GetCard(Synthesize(CardSuit.DIAMOND),CardSuit.DIAMOND);
    	arr[2]= CardDeck.GetCard(Synthesize(CardSuit.HEART),CardSuit.HEART);
    	arr[3]= CardDeck.GetCard(Synthesize(CardSuit.SPADE),CardSuit.SPADE);
    	return new Finisher(arr);    	
    }
    public boolean IsValid() throws Exception{
    	Finisher F=Synthesize_Finisher();
    	for (CardSuit it : CardSuit.NormalSet ) {
    		Card c=F.Top(it);
    		if (c!=null) {
    			for (int v=c.Value+1; v<=13; v++) {
    				Card cc=CardDeck.GetCard(v,it);
    				if (WhereIs(cc)<0) {
    					throw new Exception("Corruptive Card("+cc.toString(0)+")");
    					//return false; //for C# code
    				}
    			}
    		}else {
    			for (int v=1; v<=13; v++) {
    				Card cc=CardDeck.GetCard(v,it);
    				if (WhereIs(cc)<0 && !F.Search(cc)) {
    					throw new Exception("Corruptive card("+cc.toString(0)+")");
    					//return false; //for C# code
    				}
    			}
    		}
    	}
    	if (MB.size()>4) 
    		return false;
    	return true;
    }
    public Card[][] GetNormarr() { return normarr;}
    public int QuickWhereIs(Card that) {
    	if (MB.Search(that)) {
    		return 0;
    	}
    	for (int i=1; i<=8; i++) {
    		Card hand=Peek(i);
    		if (hand!=null && hand.Suit!=CardSuit.ERR) {
    			if (hand.Equals(that))
    				return i;
    		}
    	}
    	return -1;
    }
    private Card[] getCol(int col) {
        int sz= NowMaxPos[col-1];
        Card[] ret= new Card[sz];
        for (int i=0; i<sz; i++) {
            ret[i]=cardarr[col-1][i];   
        }
        return ret;
    }
    public byte[] getBytes() {
        //Step0: Add Buffer Card
        Vector<Byte> retV=new Vector<Byte>();        
        int c;
        for (c=0; c< MB.size(); c++) {
            Integer that= MB.get(c).ID;
            retV.add(that.byteValue());
        }
        //Step1: do Normalization
        Vector<Card[]> tmp=new Vector<Card[]>();
        for(int i=1; i<=8; i++) {
            tmp.add(ColSynthesize(i));
        }
        tmp.sort(cp);        
        for (int L=0;L<8;L++ ) {
            Card[] Line=tmp.get(L);
            Integer LineNum=0;
            int sz=CPLine.size(Line);
            if (sz>0) {
                LineNum=  (sz)*(-1);
                retV.add(LineNum.byteValue());
            }else {  //sz==0
                LineNum=(-100);
                retV.add(LineNum.byteValue());
            }
            for (int i=0; i<sz; i++) {
                Integer that=Line[i].ID;
                retV.add(that.byteValue());
            }
        }
        byte[] ret=new byte[retV.size()];
        for (int i=0; i<ret.length; i++) {
            ret[i]= retV.get(i);
        }
        return ret;
    }
    public void SHA() {
        SHA= SHAClass.stringSHA(getBytes());
    }
}
