package C2015;

import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class CPCard implements Comparator<Card> {

	public int compare(Card arg0, Card arg1) {
		if (arg0.Value < arg1.Value)
			return -1;
		else if (arg0.Value> arg1.Value)
			return 1;
		if (arg0.Suit.ord < arg1.Suit.ord) {
			return -1;
		}else if (arg0.Suit.ord > arg1.Suit.ord) 
			return 1;
		return 0;
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

	public Comparator<Card> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Card> thenComparing(Comparator<? super Card> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U extends Comparable<? super U>> Comparator<Card> thenComparing(
			Function<? super Card, ? extends U> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U> Comparator<Card> thenComparing(
			Function<? super Card, ? extends U> arg0, Comparator<? super U> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Card> thenComparingDouble(
			ToDoubleFunction<? super Card> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Card> thenComparingInt(ToIntFunction<? super Card> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Card> thenComparingLong(ToLongFunction<? super Card> arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
public class Buffer {
	private Vector<Card> mydata;
	protected static Comparator<Card> cp=new CPCard();
	public Buffer() {
		mydata=new Vector<Card>();
	}
	public Buffer(List<Card> inn) {
		this();
		for (Card elem : inn) {
			mydata.add(elem);
		}
		mydata.sort(cp);
	}
	public Card get(int inn) {
		if (inn>=0 && inn< mydata.size()) {
			return mydata.get(inn);
		}
		return null;
	}
	public int size() { return mydata.size();}
	public boolean Search(Card inn) {
		if (inn!=null && inn.Suit!=CardSuit.ERR) {
			for (Card that: mydata) {
				if (inn.Equals(that))
					return true;
			}
		}
		return false;
	}
	public boolean Add(Card inn) {
		if (inn!=null && inn.Suit!=CardSuit.ERR) {
			if (size()<4) {
				if (!Search(inn)) {
					mydata.add(inn);
					mydata.sort(cp);
					return true;
				}
			}
		}
		return false;
	}
	public boolean Remove(Card inn) {
		if (inn!=null && inn.Suit != CardSuit.ERR) {
			for(Card that : mydata) {
				if (inn.Equals(that)) {
					mydata.remove(that);
					return true;
				}
			}
		}
		return false;
	}
	public int Available() { return 4-size(); }
	public String toString() {
		StringBuffer ret=new StringBuffer("[");
		for(Card that:mydata) {
			ret.append(that.toString(0)+" ");
		}
		ret.append("]");
		return ret.toString();		
	}
	public Buffer copy() {
		return new Buffer(mydata);
	}
	public boolean Equals(Buffer that) {
		if (mydata.size() != that.mydata.size())
			return false;
		for (int x=0; x< mydata.size(); x++) {
			if (!mydata.get(x).Equals(that.mydata.get(x))) {
				return false;
			}
		}
		return true;
	}	
}
