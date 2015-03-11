package C2015;

import java.util.Vector;

public class Gamer {
	public static Card CC(String inn) {return CardDeck.GetCard(inn);}
	public static Vector<Card> GetDragon(Problem P,int srcLine) {
		Vector<Card> ret=new Vector<Card>();
		Card first=P.Peek(srcLine);
		if (first!=null && first.Suit!=CardSuit.ERR) {
			ret.add(first);
			try {
				Card second=P.AHead(first);
				while(second!=null && Problem.Rule(second, first)) {
					ret.add(second);
					first=second;
					second=P.AHead(second);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
				ret=new Vector<Card>();
			}
		}
		return ret;
	}
	public static Vector<Card> GetDragonDestNotNull(Problem P,int srcLine,Card cut) {
		Vector<Card> ret= GetDragon(P,srcLine);
              if (ret.size()>0) {
                    int delta= ret.size() - P.Available() -1;
                    //step1 依照 P.Available()來減少抓牌的數目                
                    if (delta>0) {
                            for (int i=0; i<delta; i++) {
                                    ret.removeElementAt(ret.size()-1);
                            }
                    }
                    //step2 依照Cut這張牌來減少抓牌數目
                    if (cut!=null) {
                            int sz= ret.size();
                            boolean Math_Rule=false;
                            Vector<Card> delete_me=new Vector<Card>();
                            for (int i=0; i<sz; i++) {
                                    Card hand=ret.get(i);
                                    if (Problem.Rule(cut, hand)) {
                                            Math_Rule=true;
                                            i++;
                                            while(i<sz) {
                                                    hand=ret.get(i);
                                                    delete_me.add(hand);
                                                    i++;
                                            }
                                            for (Card tmp:delete_me) {
                                                    ret.remove(tmp);
                                            }
                                    }
                            }
                            if (Math_Rule==false)
                                    ret.clear();
                    }
              }
		return ret;
	}
	public static Vector<Card> GetDragonDestIsNull(Problem P,int srcLine) {
		Vector<Card> ret= GetDragon(P,srcLine);
              if (ret.size()>0) {
                    //最多移動P.Available()張牌
                    int Max=P.Available();
                    while(ret.size() > Max) {
                            ret.removeElementAt(ret.size()-1);
                    }
              }
		return ret;
	}
    public static int Finisher_Num(Card inn,Finisher that) {
        if (inn!=null && that!=null && inn.Suit!=CardSuit.ERR) {
            Card thattop=that.Need(inn.Suit);
            if (thattop!=null)
                return (inn.Value - thattop.Value);
        }
        return -14;
    }
    public static String Finisher_View(Card inn,Finisher that) {
        int N= Finisher_Num(inn,that);
        if (N!= -14) {
            if (N>=10)
                return(""+inn.Suit+N);
            else
                return(" "+inn.Suit+N);
        }
        return "GGY";
    }
    public static String UserFinshLabel(World inn) {
        Vector<Card> that= World.UserFinish(inn);
        StringBuffer ret=new StringBuffer();
        for(Card elem : that) {
            ret.append(elem.toString(0));
            ret.append(',');
        }
        return ret.toString();
    }
    public static int Obstruction_Num(World inn,int L,int Pos) {
        int ret=0;
        Card hicard=inn.P.PeekCard(L, Pos);
        if (hicard!=null && hicard.Suit!=CardSuit.ERR) {
            int hi_num=Gamer.Finisher_Num(hicard, inn.F);
            if (Pos+1<21) {
                for (int P=Pos+1; P<21; P++) {
                    Card lowcard=inn.P.PeekCard(L, P);
                    if (lowcard==null)
                        break;
                    int low_num=Gamer.Finisher_Num(lowcard, inn.F);
                    if (low_num > hi_num)
                        ++ret;
                }
            }
            return ret;
        }
        return -1;
    }
    public static int Total_Obstruction(World inn) {
        return Total_Obstruction(inn,false);
    }
    public static int Total_Obstruction(World inn, boolean debug) {
        int ret=0;
        for (int i=1; i<=8; i++) {
            if (debug)
                System.out.println("Line"+i+": ");
            for (int j=0; j<21; j++) {
                Card highcard= inn.P.PeekCard(i,j);
                if (highcard==null || j==20)
                    break;
                for (int k=j+1; k<21; k++) {
                    Card lowcard= inn.P.PeekCard(i, k);
                    if (lowcard==null)
                        break;
                    else {
                        int high_num=Gamer.Finisher_Num(highcard,inn.F);
                        int low_num= Gamer.Finisher_Num(lowcard, inn.F);
                        int av= inn.P.Available();
                        if (lowcard.Suit == highcard.Suit) {
                            if (high_num< low_num) {
                                ret++;
                                if (debug) {
                                    String oo=String.format("<{0}={1}>,", Gamer.Finisher_View(highcard,inn.F)
                                                                      , Gamer.Finisher_View(lowcard,inn.F));
                                    System.out.println(oo);
                                }                                    
                            }
                        }else {
                            if (high_num < low_num) {
                                ret++;
                                if (debug) {
                                    String oo=String.format("<{0}={1}>", Gamer.Finisher_View(highcard, inn.F)
                                                                    , Gamer.Finisher_View(lowcard, inn.F));
                                    System.out.println(oo);
                                }
                            }
                        }
                    }
                }
            }
            if (debug)
                System.out.println("\n");
        }
        return ret;
    }
    
    
    public static int Total_Obstruction_AV(World inn) {
        return Total_Obstruction_AV(inn,false);
    }
    public static int Total_Obstruction_AV(World inn, boolean debug) {
        int ret=0;
        for (int i=1; i<=8; i++) {
            if (debug)
                System.out.println("Line"+i+":");
            for (int j=0; i<21; j++) {
                Card hicard= inn.P.PeekCard(i, j);
                if (hicard==null || j==20)
                    break;
                for (int k=j+1; k<21; k++) {
                    Card lowcard= inn.P.PeekCard(i,k);
                    if (lowcard==null)
                        break;
                    else     {
                        int high_num=Gamer.Finisher_Num(hicard,inn.F);
                        int low_num=Gamer.Finisher_Num(lowcard,inn.F);
                        int av= inn.P.Available();
                        if (lowcard.Suit==hicard.Suit) {
                            if (high_num< low_num) {
                                ret++;
                                if (debug) {
                                    String oo=String.format("<{0}={1}>", Gamer.Finisher_View(hicard,inn.F), Gamer.Finisher_View(lowcard,inn.F));
                                    System.out.println(oo);
                                }
                            }
                        }else {
                           if (low_num - high_num > av) {
                               ret++;
                               if (debug) {
                                   String oo= String.format("<{0}={1}>", Gamer.Finisher_View(hicard,inn.F),Gamer.Finisher_View(lowcard,inn.F));
                               }
                           } 
                        }
                    }
                }
            }
            if (debug) {
                System.out.println("\n");
            }
        }
        return ret;
    }
   
    public static int AV_Obstruction_Num(World inn, int L,int Pos) {
        int ret=0;
        Card hicard= inn.P.PeekCard(L,Pos);
        if (hicard==null)
            return 0;
        else {
            int hi_num= Gamer.Finisher_Num(hicard, inn.F);
            if (Pos+1<=20) {
                for (int P=Pos+1; P<21; P++) {
                    Card lowcard=inn.P.PeekCard(L, P);
                    if (lowcard==null)
                        break;
                    int low_num= Gamer.Finisher_Num(lowcard, inn.F);
                    int av= inn.P.Available();
                    if (lowcard.Suit==hicard.Suit) {
                        if (hi_num< low_num)
                            ret++;
                    }else {
                        if (low_num- hi_num > av)
                            ret++;
                    }                        
                }
            }
        }
        return ret;
    }
    
   public static Problem EXAMPLE_PROBLEM() {
       Card[][] arr=new Card[8][21];
        Buffer b=new Buffer();
        b.Add(CardDeck.GetCard("5C"));
        b.Add(CardDeck.GetCard("12S"));
        arr[0][0]= CardDeck.GetCard("13H");
        arr[0][1]= CardDeck.GetCard("12C");
        arr[0][2]= CardDeck.GetCard("11H");
        arr[0][3]= CardDeck.GetCard("10C");
        arr[0][4]= CardDeck.GetCard("9H");
        arr[0][5]= CardDeck.GetCard("8S");
        arr[0][6]= CardDeck.GetCard("7D");

        arr[1][0]= CardDeck.GetCard("13S");

        arr[2][0]= CardDeck.GetCard("2H");
        arr[2][1]= CardDeck.GetCard("6D");
        arr[2][2]= CardDeck.GetCard("5D");
        arr[2][3]= CardDeck.GetCard("11D");
        arr[2][4]= CardDeck.GetCard("2C");
        arr[2][5]= CardDeck.GetCard("8C");
        arr[2][6]= CardDeck.GetCard("9D");

        arr[3][0]= CardDeck.GetCard("8H");
        arr[3][1]= CardDeck.GetCard("13D");
        arr[3][2]= CardDeck.GetCard("5H");
        arr[3][3]= CardDeck.GetCard("4C");
        arr[3][4]= CardDeck.GetCard("3D");

        arr[4][0]= CardDeck.GetCard("10S");
        arr[4][1]= CardDeck.GetCard("7H");
        arr[4][2]= CardDeck.GetCard("3H");
        arr[4][3]= CardDeck.GetCard("11S");
        arr[4][4]= CardDeck.GetCard("6C");
        arr[4][5]= CardDeck.GetCard("10D");
        arr[4][6]= CardDeck.GetCard("9S");

        arr[5][0]= CardDeck.GetCard("12D");
        arr[5][1]= CardDeck.GetCard("11C");
        arr[5][2]= CardDeck.GetCard("10H");
        arr[5][3]= CardDeck.GetCard("9C");
        arr[5][4]= CardDeck.GetCard("8D");
        arr[5][5]= CardDeck.GetCard("7C");

        arr[6][0]= CardDeck.GetCard("12H");
        arr[6][1]= CardDeck.GetCard("4H");
        arr[6][2]= CardDeck.GetCard("2D");
        arr[6][3]= CardDeck.GetCard("6S");
        arr[6][4]= CardDeck.GetCard("4S");
        arr[6][5]= CardDeck.GetCard("6H");
        arr[6][6]= CardDeck.GetCard("5S");
        arr[6][7]= CardDeck.GetCard("4D");
        arr[6][8]= CardDeck.GetCard("3C");

        arr[7][0]= CardDeck.GetCard("1H");
        arr[7][1]= CardDeck.GetCard("7S");
        arr[7][2]= CardDeck.GetCard("13C");
        return new Problem(arr,b);        
    }
        
   public static World EXAMPLE_WORLD() {
        Problem P= Gamer.EXAMPLE_PROBLEM(); 
        World ret=new World(P);
        if (ret.F.Top(CardSuit.CLUB).Equals(CC("1C")) &&
            ret.F.Top(CardSuit.DIAMOND).Equals(CC("1D")) &&
            ret.F.Top(CardSuit.HEART)==null &&
            ret.F.Top(CardSuit.SPADE).Equals(CC("3S")))
            return ret;
        else
            return null;
    }
   public static Vector<Card> L1a(World inn) {
        Vector<Card> ret= new Vector<Card>();
        for (int i=1; i<=8; i++) {
            Card hand= inn.P.Peek(i);
            if (hand!=null && hand.Suit!= CardSuit.ERR)
                ret.add(hand);
        }
        return ret;
    }  
       public static Vector<Card> L1b(World inn) {
        Vector<Card> ret=new Vector<Card>();
        int sz=inn.P.GetBuffer().size();
        for (int i=0; i<sz; i++) {
            Card hand=inn.P.GetBuffer().get(i);
            if (hand!=null && hand.Suit!=CardSuit.ERR) {
                ret.add(hand);
            }
        }
        return ret;
    }
    public static World MissionImpossible() {
        Card[][] arr=new Card[8][21];
        Buffer b=new Buffer();
        arr[0][0]= CardDeck.GetCard("1S");
        arr[0][1]= CardDeck.GetCard("10S");
        arr[0][2]= CardDeck.GetCard("12S");
        arr[0][3]= CardDeck.GetCard("7S");
        arr[0][4]= CardDeck.GetCard("4S");
        arr[0][5]= CardDeck.GetCard("9S");
        arr[0][6]= CardDeck.GetCard("2S");
        
        arr[1][0]= CardDeck.GetCard("1H");
        arr[1][1]= CardDeck.GetCard("10H");
        arr[1][2]= CardDeck.GetCard("12H");
        arr[1][3]= CardDeck.GetCard("7H");
        arr[1][4]= CardDeck.GetCard("4H");
        arr[1][5]= CardDeck.GetCard("9H");
        arr[1][6]= CardDeck.GetCard("2H");

        arr[2][0]= CardDeck.GetCard("1D");
        arr[2][1]= CardDeck.GetCard("10D");
        arr[2][2]= CardDeck.GetCard("12D");
        arr[2][3]= CardDeck.GetCard("7D");
        arr[2][4]= CardDeck.GetCard("4D");
        arr[2][5]= CardDeck.GetCard("9D");
        arr[2][6]= CardDeck.GetCard("2D");

        arr[3][0]= CardDeck.GetCard("1C");
        arr[3][1]= CardDeck.GetCard("10C");
        arr[3][2]= CardDeck.GetCard("12C");
        arr[3][3]= CardDeck.GetCard("7C");
        arr[3][4]= CardDeck.GetCard("4C");
        arr[3][5]= CardDeck.GetCard("9C");
        arr[3][6]= CardDeck.GetCard("2C");

        arr[4][0]= CardDeck.GetCard("3S");
        arr[4][1]= CardDeck.GetCard("8S");
        arr[4][2]= CardDeck.GetCard("5S");
        arr[4][3]= CardDeck.GetCard("6S");
        arr[4][4]= CardDeck.GetCard("11S");
        arr[4][5]= CardDeck.GetCard("13S");

        arr[5][0]= CardDeck.GetCard("3D");
        arr[5][1]= CardDeck.GetCard("8D");
        arr[5][2]= CardDeck.GetCard("5D");
        arr[5][3]= CardDeck.GetCard("6D");
        arr[5][4]= CardDeck.GetCard("11D");
        arr[5][5]= CardDeck.GetCard("13D");
        
        arr[6][0]= CardDeck.GetCard("3H");
        arr[6][1]= CardDeck.GetCard("8H");
        arr[6][2]= CardDeck.GetCard("5H");
        arr[6][3]= CardDeck.GetCard("6H");
        arr[6][4]= CardDeck.GetCard("11H");
        arr[6][5]= CardDeck.GetCard("13H");


        
        arr[7][0]= CardDeck.GetCard("3C");
        arr[7][1]= CardDeck.GetCard("8C");
        arr[7][2]= CardDeck.GetCard("5C");
        arr[7][3]= CardDeck.GetCard("6C");
        arr[7][4]= CardDeck.GetCard("11C");
        arr[7][5]= CardDeck.GetCard("13C");
        
        World ret=new World(new Problem(arr,b));
        if (ret.F.Top(CardSuit.CLUB)==null &&
            ret.F.Top(CardSuit.DIAMOND)==null &&
            ret.F.Top(CardSuit.HEART)==null &&
            ret.F.Top(CardSuit.SPADE)==null)
            return ret;
        else
            return null;            
    }
}
