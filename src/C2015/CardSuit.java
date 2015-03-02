package C2015;

public enum CardSuit {
	CLUB(0,"C"),
	DIAMOND(1,"D"),
	HEART(2,"H"),
	SPADE(3,"S"),
	ERR(4,"@");
	public  final int ord;
	public  final String UpperCaseLetter;
       public  final String LowerCaseLetter;
	//private String Name;
	CardSuit(final int num,final String inn) {
		ord=num;  UpperCaseLetter=inn; 
              LowerCaseLetter= inn.toLowerCase();
	}	
	public CardSuit Next() {   //備而不用
		switch(this.ord) {
		case 0:  return DIAMOND;
		case 1:  return HEART;
		case 2: return SPADE;
		case 3: return ERR;
		default:
				return null;
		}
	}
	public static CardSuit  CharToSuit(char c) {
		switch(c) {
		case 'C': case'c':  return CLUB;
		case 'D': case 'd': return DIAMOND;
		case 'H': case 'h': return HEART;
		case 'S': case 's': return SPADE;
		default:   return ERR;
		}
	}
	public static boolean IsRed(CardSuit inn) {
		return (inn==DIAMOND || inn==HEART);
	}
	public String toString() {		return UpperCaseLetter;	}
       public String toLowerCase() {        return LowerCaseLetter; }
	public final static CardSuit[] RedSet={ DIAMOND,HEART};
	public final static CardSuit[] BlackSet={CLUB,SPADE};
       public final static CardSuit[] NormalSet={CLUB,DIAMOND,HEART,SPADE};
}
/*
public class CardSuit {

	private final String name;
	private static int nextOrdinal=0;
	private final int ordinal=nextOrdinal++;
	private CardSuit(String inn) { name=inn;}
	public String toString() { return name;}
	public int compareTo(Object o) {
		return ordinal-((CardSuit) o).ordinal;
	}
	public static final CardSuit CLUB=new CardSuit("C");
	public static final CardSuit DIAMOND=new CardSuit("D");
	public static final CardSuit HEART=new CardSuit("H");
	public static final CardSuit SPADE=new CardSuit("S");
	public static final CardSuit ERR=  new CardSuit("@");
	public static boolean IsRed(CardSuit that) {
		return ( (that==HEART)||(that==DIAMOND));
	}
	public int ord() { return ordinal;	}
	public static CardSuit CharToSuit(char c) {
		switch(c) {
		case 'C':
			return CLUB;
		case 'D':
			return DIAMOND;
		case 'H':
			return HEART;
		case 'S':
			return SPADE;
		case '@':  default:
			return ERR;
		}
	}
	public CardSuit Next() {
		if (this==CLUB) {
			return DIAMOND;
		}else if (this==DIAMOND) {
			return HEART;
		}else if (this==HEART) {
			return SPADE;
		}else if (this==SPADE) {
			return ERR;
		}
		return null;		
	}
}
*/
