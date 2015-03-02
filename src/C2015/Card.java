package C2015;

import java.io.ObjectStreamException;


public class Card {
	private static final CardSuit[] PRIVATE_VALUES={CardSuit.CLUB,CardSuit.DIAMOND,CardSuit.HEART,CardSuit.SPADE,CardSuit.ERR};
	private Object readResolve() throws ObjectStreamException {
		return PRIVATE_VALUES[4];  //@@?  其實我也看不懂
	}
    public static final String[] P ={" 1C"," 1D"," 1H"," 1S",
        " 2C"," 2D"," 2H"," 2S",
        " 3C"," 3D"," 3H"," 3S",
        " 4C"," 4D"," 4H"," 4S",
        " 5C"," 5D"," 5H"," 5S",
        " 6C"," 6D"," 6H"," 6S",
        " 7C"," 7D"," 7H"," 7S",
        " 8C"," 8D"," 8H"," 8S",
        " 9C"," 9D"," 9H"," 9S",
        "10C","10D","10H","10S", 
        "11C","11D","11H","11S",
        "12C","12D","12H","12S",
        "13C","13D","13H","13S"  };

	
	public final int Value;
	public final CardSuit Suit ;
	public final boolean IsRed;
	public final int ID;
       public final String _Str;
       public final String Str;
	public Card() {
		ID=(-1);
		Value=0;
		Suit= CardSuit.ERR;
		IsRed=false;
              _Str="@@?";
              Str="@@";
	}
	public Card(int inn) {
		ID= inn;
		Suit= PRIVATE_VALUES[ inn%4 ];
		Value= (inn/4)+1;	
		IsRed= CardSuit.IsRed(Suit);
              if (ID>=0) {
                  _Str=P[ID];
                  if (Value>=10)
                      Str=_Str;
                  else
                      Str=_Str.substring(1);
              }
              else {
                  Str=_Str="@@?";
              }              
	}
	public String toString() {return _Str;	}
	public String toString(int d) { return Str;}
       
    public static int GetValueFromString(String inn)
    {
        inn = inn.trim();
        String ret;
        if (inn.length() == 2)
            ret = inn.substring(0, 1);
        else if (inn.length() == 3)
            ret = inn.substring(0, 2);
        else
            return -1;
        if (ret.equals("ET"))
            return -1;
        try
        {            
            int val = Integer.valueOf(ret);
            if (val >= 1 && val <= 13)
                return val;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return -1;
        }
        return -1;
    }
    public static CardSuit GetSuitFromString(String inn)
    {
        inn = inn.trim();
        String ret;
        if (inn.length() == 2)
            ret = inn.substring(1, 2);  //startindex,endindex
        else if (inn.length() == 3)
            ret = inn.substring(2, 3);  //startindex,endindex
        else
            ret = "@";
        return (CardSuit.CharToSuit(ret.charAt(0)) );
    }
    public boolean Equals(Card that) {
    	if (that!=null) {
    		if (ID==that.ID) {
    			return true;
    		}
    	}
    	return false;
    }
}
