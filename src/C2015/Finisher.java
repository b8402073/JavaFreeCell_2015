package C2015;

public class Finisher {
	private Card[] arr={null,null,null,null};
	private boolean DoResponseCard(Card inn) {
		if (inn!=null && inn.ID<=51 && inn.ID>=0) {
			arr[inn.Suit.ord]=inn;
			return true;
		}
		return false;
	}
	public Card Top(CardSuit inn) {
		if (inn!=CardSuit.ERR) {
			return arr[inn.ord];
		}
		return null;
	}
	public boolean Search(Card that) {
		if (that==null)
			return false;
		Card response=Top(that.Suit);
		if (response==null)
			return false;
		else if (that.Value > response.Value)
			return false;
		return true;
	}
	public Finisher() {}
	public Finisher(Card innc,Card innd,Card innh,Card inns) {
		int flag=0;
		if (innc==null || innc.Suit==CardSuit.CLUB) {
			arr[0]=innc; flag+=1;
		}else if (innd==null || innd.Suit==CardSuit.DIAMOND){
			arr[1]=innd; flag+=1;
		}else if (innh==null || innh.Suit==CardSuit.HEART) {
			arr[2]=innh; flag+=1;
		}else if (inns==null || inns.Suit==CardSuit.SPADE) {
			arr[3]=inns; flag+=1;
		}
		if (flag==4)
			return;
		arr=null;
	}
	public Finisher(String innc,String innd,String innh,String inns) {
		this(CardDeck.GetCard(innc),
			 CardDeck.GetCard(innd),
			 CardDeck.GetCard(innh),
			 CardDeck.GetCard(inns)); 
	}
	public Finisher(Card[] that) {
        if (that.length == 4)
        {
            if (that[0] == null || that[0].Suit == CardSuit.CLUB)
            {
                if (that[1] == null || that[1].Suit == CardSuit.DIAMOND)
                {
                    if (that[2] == null || that[2].Suit == CardSuit.HEART)
                    {
                        if (that[3] == null || that[3].Suit == CardSuit.SPADE)
                        {
                            for (int i = 0; i < 4; i++)
                            {
                                arr[i] = that[i];                                    
                            }
                        }
                    }
                }
            }
            return;
        }
	}
	public Finisher copy() {return new Finisher(arr);}
	public boolean add(Card inn) {
		if (inn!=null && inn.Suit!=CardSuit.ERR) {
			Card that=Top(inn.Suit);
			if (that==null && inn.Value==1)
				return DoResponseCard(inn);
			else if (inn.Value== that.Value+1)
				return DoResponseCard(inn);
		}
		return false;
	}
	public Card Need(CardSuit inn) {
		if (inn!=CardSuit.ERR) {
			Card that=Top(inn);
			if (that==null)
				return CardDeck.GetCard(1,inn);
			else if (that.Value<13) 
				return CardDeck.GetCard(that.Value+1,inn);
			else
				return null;
		}
		return null;
	}
	public boolean Needed(Card inn){
		if (inn==null)
			return false;
		if (inn.Equals(Need(inn.Suit)))
			return true;
		return false;
	}
	public String toString(){
		StringBuffer ret=new StringBuffer(30);
		ret.append('[');
		for (int i=0; i<3; i++){
			if (arr[i]==null)
				ret.append("EMPTY,");
			else
				ret.append(arr[i].toString(0)+",");
		}
		if (arr[3]==null)
			ret.append("EMPTY");
		else
			ret.append(arr[3].toString(0));
		ret.append(']');
		return ret.toString();		
	}
	public boolean SafeCardUp(Card inn) {
		if (inn!=null && inn.Suit!=CardSuit.ERR) {
			int N=inn.Value;
			if (N==1 || N==2)
				return true;
			if (inn.IsRed) {
				if (arr[CardSuit.CLUB.ord]==null ||
					arr[CardSuit.SPADE.ord]==null)
					return false;
				if (arr[CardSuit.SPADE.ord].Value >= inn.Value-1 &&
					arr[CardSuit.CLUB.ord].Value>= inn.Value-1)
					return true;
				return false;
			}else {
				if (arr[CardSuit.DIAMOND.ord]==null ||
					arr[CardSuit.HEART.ord]==null)
					return false;
				
				if (arr[CardSuit.DIAMOND.ord].Value>= inn.Value-1 &&
					arr[CardSuit.HEART.ord].Value>= inn.Value-1)
					return true;
				return false;				
			}
		}
		return false;
	}
	public boolean Equals(Finisher that) {
		if (that!=null && that.arr!=null) {
			return (arr[0]==that.arr[0] &&
					arr[1]==that.arr[1] &&
					arr[2]==that.arr[2] &&
					arr[3]==that.arr[3]);
		}
		return false;
	}
}
