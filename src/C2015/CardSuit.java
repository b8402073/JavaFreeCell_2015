package C2015;

public enum CardSuit {
	CLUB(0,"C"),
	DIAMOND(1,"D"),
	HEART(2,"H"),
	SPADE(3,"S"),
	ERR(4,"@");
	public  final int ord;
	public  final String Letter;
	//private String Name;
	CardSuit(final int num,final String inn) {
		ord=num;  Letter=inn;
	}	
	public CardSuit Next() {
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
		case 'C':  return CLUB;
		case 'D':  return DIAMOND;
		case 'H':  return HEART;
		case 'S':  return SPADE;
		default:   return ERR;
		}
	}
	public static boolean IsRed(CardSuit inn) {
		return (inn==DIAMOND || inn==HEART);
	}
	public String toString() {		return Letter;	}
	public static CardSuit[] RedSet={ DIAMOND,HEART};
	public static CardSuit[] BlackSet={CLUB,SPADE};
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