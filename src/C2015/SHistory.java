package C2015;
import java.util.List;
import java.util.Vector;
public class SHistory {
    public static boolean ready = false;
    //private static SHistory INSTANCE = new SHistory();
    static final String[] Fin={"Finish(1C)","Finish(1D)","Finish(1H)","Finish(1S)",
					                "Finish(2C)","Finish(2D)","Finish(2H)","Finish(2S)",
						            "Finish(3C)","Finish(3D)","Finish(3H)","Finish(3S)",
						            "Finish(4C)","Finish(4D)","Finish(4H)","Finish(4S)",
						            "Finish(5C)","Finish(5D)","Finish(5H)","Finish(5S)",
						            "Finish(6C)","Finish(6D)","Finish(6H)","Finish(6S)",
						            "Finish(7C)","Finish(7D)","Finish(7H)","Finish(7S)",
						            "Finish(8C)","Finish(8D)","Finish(8H)","Finish(8S)",
						            "Finish(9C)","Finish(9D)","Finish(9H)","Finish(9S)",
						            "Finish(10C)","Finish(10D)","Finish(10H)","Finish(10S)",
						            "Finish(11C)","Finish(11D)","Finish(11H)","Finish(11S)",
						            "Finish(12C)","Finish(12D)","Finish(12H)","Finish(12S)",
						            "Finish(13C)","Finish(13D)","Finish(13H)","Finish(13S)" };
    static final String[] Pop={  "POP(1C)","POP(1D)","POP(1H)","POP(1S)" ,
						            "POP(2C)","POP(2D)","POP(2H)","POP(2S)" ,
						            "POP(3C)","POP(3D)","POP(3H)","POP(3S)" ,
						            "POP(4C)","POP(4D)","POP(4H)","POP(4S)" ,
						            "POP(5C)","POP(5D)","POP(5H)","POP(5S)" ,
						            "POP(6C)","POP(6D)","POP(6H)","POP(6S)" ,
						            "POP(7C)","POP(7D)","POP(7H)","POP(7S)" ,
						            "POP(8C)","POP(8D)","POP(8H)","POP(8S)" ,
						            "POP(9C)","POP(9D)","POP(9H)","POP(9S)" ,
						            "POP(10C)","POP(10D)","POP(10H)","POP(10S)" ,
						            "POP(11C)","POP(11D)","POP(11H)","POP(11S)" ,
						            "POP(12C)","POP(12D)","POP(12H)","POP(12S)" ,
						            "POP(13C)","POP(13D)","POP(13H)","POP(13S)"  };

    static final String[] Down={ "DOWN(1C)","DOWN(1D)","DOWN(1H)","DOWN(1S)" ,
						            "DOWN(2C)","DOWN(2D)","DOWN(2H)","DOWN(2S)" ,
						            "DOWN(3C)","DOWN(3D)","DOWN(3H)","DOWN(3S)" ,
						            "DOWN(4C)","DOWN(4D)","DOWN(4H)","DOWN(4S)" ,
						            "DOWN(5C)","DOWN(5D)","DOWN(5H)","DOWN(5S)" ,
						            "DOWN(6C)","DOWN(6D)","DOWN(6H)","DOWN(6S)" ,
						            "DOWN(7C)","DOWN(7D)","DOWN(7H)","DOWN(7S)" ,
						            "DOWN(8C)","DOWN(8D)","DOWN(8H)","DOWN(8S)" ,
						            "DOWN(9C)","DOWN(9D)","DOWN(9H)","DOWN(9S)" ,
						            "DOWN(10C)","DOWN(10D)","DOWN(10H)","DOWN(10S)" ,
						            "DOWN(11C)","DOWN(11D)","DOWN(11H)","DOWN(11S)" ,
						            "DOWN(12C)","DOWN(12D)","DOWN(12H)","DOWN(12S)" ,
						            "DOWN(13C)","DOWN(13D)","DOWN(13H)","DOWN(13S)" };
    static final String[] ConnectHigh={ "@ERR","@ERR","@ERR","@ERR",
    "CONNECT(2C,1H)","CONNECT(2D,1S)","CONNECT(2H,1S)","CONNECT(2S,1H)",
    "CONNECT(3C,2H)","CONNECT(3D,2S)","CONNECT(3H,2S)","CONNECT(3S,2H)",
    "CONNECT(4C,3H)","CONNECT(4D,3S)","CONNECT(4H,3S)","CONNECT(4S,3H)",
    "CONNECT(5C,4H)","CONNECT(5D,4S)","CONNECT(5H,4S)","CONNECT(5S,4H)",
    "CONNECT(6C,5H)","CONNECT(6D,5S)","CONNECT(6H,5S)","CONNECT(6S,5H)",
    "CONNECT(7C,6H)","CONNECT(7D,6S)","CONNECT(7H,6S)","CONNECT(7S,6H)",
    "CONNECT(8C,7H)","CONNECT(8D,7S)","CONNECT(8H,7S)","CONNECT(8S,7H)",
    "CONNECT(9C,8H)","CONNECT(9D,8S)","CONNECT(9H,8S)","CONNECT(9S,8H)",
    "CONNECT(10C,9H)","CONNECT(10D,9S)","CONNECT(10H,9S)","CONNECT(10S,9H)",
    "CONNECT(11C,10H)","CONNECT(11D,10S)","CONNECT(11H,10S)","CONNECT(11S,10H)",
    "CONNECT(12C,11H)","CONNECT(12D,11S)","CONNECT(12H,11S)","CONNECT(12S,11H)",
    "CONNECT(13C,12H)","CONNECT(13D,12S)","CONNECT(13H,12S)","CONNECT(13S,12H)" };

    static final String[] ConnectLow={ "@ERR","@ERR","@ERR","@ERR",
    "CONNECT(2C,1D)","CONNECT(2D,1C)","CONNECT(2H,1C)","CONNECT(2S,1D)",
    "CONNECT(3C,2D)","CONNECT(3D,2C)","CONNECT(3H,2C)","CONNECT(3S,2D)",
    "CONNECT(4C,3D)","CONNECT(4D,3C)","CONNECT(4H,3C)","CONNECT(4S,3D)",
    "CONNECT(5C,4D)","CONNECT(5D,4C)","CONNECT(5H,4C)","CONNECT(5S,4D)",
    "CONNECT(6C,5D)","CONNECT(6D,5C)","CONNECT(6H,5C)","CONNECT(6S,5D)",
    "CONNECT(7C,6D)","CONNECT(7D,6C)","CONNECT(7H,6C)","CONNECT(7S,6D)",
    "CONNECT(8C,7D)","CONNECT(8D,7C)","CONNECT(8H,7C)","CONNECT(8S,7D)",
    "CONNECT(9C,8D)","CONNECT(9D,8C)","CONNECT(9H,8C)","CONNECT(9S,8D)",
    "CONNECT(10C,9D)","CONNECT(10D,9C)","CONNECT(10H,9C)","CONNECT(10S,9D)",
    "CONNECT(11C,10D)","CONNECT(11D,10C)","CONNECT(11H,10C)","CONNECT(11S,10D)",
    "CONNECT(12C,11D)","CONNECT(12D,11C)","CONNECT(12H,11C)","CONNECT(12S,11D)",
    "CONNECT(13C,12D)","CONNECT(13D,12C)","CONNECT(13H,12C)","CONNECT(13S,12D)" };
    
    static String[][] MoveLine=new String[52][52];
    static String[]   MoveLineToEmpty=new String[52];
    
    private SHistory()  { Create();}
    public static boolean Create() {
        if (!ready)
        {
            if (!CardDeck.ready)
            {
                CardDeck.Create();
            }
            //WorldExt.InstanceU=new U<WorldExt>();
            //WorldExt.CM= new CardNum_TotalAV<WorldExt>();
            for (int i=0; i<52; i++) {
            	for (int j=0; j<i; j++) {
            		if (i>j) {
                		Card High= CardDeck.GetCard(i);
                		Card Low = CardDeck.GetCard(j);
                		if (High.Value - Low.Value >1 ) {
                			MoveLine[i][j]= new String("MOVELINE("+High.toString(0)+","+Low.toString(0)+")");
                			continue;
                		}
            		}
            		MoveLine[i][j]="@ERR";
            	}
            }
            for (int k=0; k<52; k++) {
            	Card Low;
           		Low=CardDeck.GetCard(k);
            	MoveLineToEmpty[k]=new String("MOVELINE(EMPTY,"+Low.toString(0)+")");
            }
            ready = true;                
        }
        return ready;    	
    }
    
    public static String NumToString(int that)
    {
    	if (that>=10000) {
    		that -=10000;
    		int hi= that/ 100;
    		int low= that%100;
    		if (hi>=0 && low>=0 && hi<52 && low<52)
    			return MoveLine[hi][low];
    		else if (hi==99 && low>=0 && low<52)
    			return MoveLineToEmpty[low];
    	}
    	else if (that >= 2000)        {
            return ConnectHigh[that - 2000];
        }
        else if (that >= 1000 && that < 2000)        {
            return ConnectLow[that - 1000];
        }
        else if (that >= 0 && that <= 51)        {
            return Fin[that];
        }
        else if (that >= 100 && that <= 151)        {
            return Pop[that - 100];
        }
        else if (that >= 200 && that <= 251)        {
            return Down[that - 200];
        }
        return null;
    }    
    public static int MoveLine_ToNum(Card High,Card Low) {
    	int ret=10000;
    	if (High==null)
    		ret +=9900;
    	else
    		ret += (High.ID*100);
    	ret += Low.ID;
    	return ret;
    }
    public static int Connect_ToNum(Card High, Card Low)
    {
        int ret = 0;
        if (High != null && Low != null)
        {
            if (Low.Suit == CardSuit.CLUB || Low.Suit == CardSuit.DIAMOND)
                ret += 1000;
            else
                ret += 2000;
        }
        ret += High.ID;
        return ret;
    }
    public static int Down_ToNum(Card that)     { return (200 + that.ID);  }
    public static int Pop_ToNum(Card that)      { return (100 + that.ID);  }
    public static int Finish_ToNum(Card that)   { return that.ID; }   
    
    public static int Tail(List<Integer> inn)
    {
        int ret = 0;
        int sz = inn.size();
        for (int i = sz - 1; i >= 0; i--)
        {
            if (inn.get(i) < 100)
                ret += 1;
            else
                break;
        }
        return ret;
    }
    public static boolean BetterHistory(List<Integer> nex, List<Integer> prev)
    {
        int nexCount = nex.size();
        int prevCount = prev.size();
        if (nexCount < prevCount)
            return true;
        else if (nexCount > prevCount)
            return false;
        else //if (nexCount == prevCount)
        {
            int Tnex = Tail(nex);

            if (Tnex > 12)
            {
                int Tprev = Tail(prev);
                if (Tnex > Tprev)
                    return true;
            }
        }
        return false;
    }
    public static boolean BetterWorld(World nex, World prev)
    {
        if (prev != null && nex != null)
        {
            if (nex.ValueEquals(prev))
            {
                if (BetterHistory(nex.History, prev.History))
                    return true;
            }
        }
        if (prev == null && nex == null)
            return true;
        return false;
    } 
    public static Vector<Problem> MakeAncestorP(Problem init, List<Integer> H) {
        Vector<Problem> ret = new Vector<Problem>();
        int sz = H.size();
        for (int i = 0; i < sz; i++)
        {
            World root = new World(init.copy());
            Vector<Integer> HandHistory = new Vector<Integer>();
            for (int j = 0; j < i; j++)
            {
                HandHistory.add(H.get(j));
            }
            try {
            	ret.add(MakeProblem(root, HandHistory));
            }catch(Exception ex) {
            	ex.printStackTrace();
            	return null;
            }
        }
        return ret;
    }
    public static Problem MakeProblem(World init, List<Integer> HandHistory) throws Exception    {
        int sz= HandHistory.size();
        for (int i = 0; i < sz; i++)
        {
            int that = HandHistory.get(i);
            Card CHigh = null, CLow = null, CHand = null;
            CardSuit CLowSuit = CardSuit.ERR;
            if (that>=10000) {
            	that -=10000;
            	int high=that/100;
            	int low= that%100;
            	CHigh=CardDeck.GetCard(high);
            	CLow =CardDeck.GetCard(low);
            	if (!init.MOVELINE(CHigh,CLow))
            		throw new Exception("Can't MoveLine("+CHigh+","+CLow+")");
            }
            else if (that >= 2000)
            {
                CHigh = CardDeck.GetCard(that - 2000);
                if (CHigh.IsRed)
                    CLowSuit = CardSuit.SPADE;
                else
                    CLowSuit = CardSuit.HEART;
                CLow = CardDeck.GetCard(CHigh.Value - 1, CLowSuit);
                if (!init.CONNECT(CHigh, CLow))
                {
                    throw new Exception("Can't Connect at " + i);                        
                }
            }
            else if (that >= 1000 && that < 2000)
            {
                CHigh=CardDeck.GetCard(that-1000);
                if (CHigh.IsRed)
                    CLowSuit=CardSuit.CLUB;
                else
                    CLowSuit=CardSuit.DIAMOND;
                CLow=CardDeck.GetCard(CHigh.Value-1,CLowSuit);
                if (!init.CONNECT(CHigh, CLow))
                {
                    throw new Exception("Can't Connect at " + i);
                }
            }
            else if (that >= 0 && that <= 51)
            {
                CHand = CardDeck.GetCard(that);
                if (!init.FINISH(CHand))
                {
                   throw new Exception("Can't FINISH at " + i);                        
                }
            }
            else if (that >= 100 && that <= 151)
            {
                CHand = CardDeck.GetCard(that - 100);
                if (!init.POP(CHand))
                {
                    throw new Exception("Can't POP at " + i);                        
                }
            }
            else if (that >= 200 && that <= 251)
            {
                CHand = CardDeck.GetCard(that - 200);
                if (!init.DOWN(CHand))
                {
                    throw new Exception("Can't DOWN at " + i);                        
                }
            }
            else
            {
                throw new Exception("Unknown Move at " + i);                    
            }
        }
        return init.P;
    }
    public static boolean EqualHistoy(List<Integer> nex, List<Integer> prev)
    {
        if (nex == prev)
            return true;
        if (nex != null && prev != null)
        {
            if (nex.size() != prev.size())
            {
                for (int i = 0; i < nex.size(); i++)
                {
                    if (nex.get(i) != prev.get(i))
                        return false;
                }
            }
        }
        return true;
    }    
}
