package C2015;

public class CardDeck {
	 private static Card[] arr = new Card[52];
     public static boolean ready = false;
    // private static CardDeck INSTANCE = new CardDeck();
     public static Card errCard = new Card();
     public static boolean Create()
     {
         if (!ready)
         {
             for (int i = 0; i <= 51; i++)
             {
                 arr[i] = new Card(i);
             }
             ready = true; 
         }
         return ready;
     }
     public static void Destroy()
     {
         for (int i = 0; i < 52; i++)
         {
             arr[i] = null;
         }
         ready = false;
     }
     public static Card GetCard(int inn)
     {
         if (inn >= 0 && inn <= 51)
             return (arr[inn]);
         return null;
     }

     
     public static Card GetCard(int V, CardSuit S)
     {
         if (V >= 1 && V <= 13)
         {
        	 if (S.ord<4) 
        		 return (arr[(V - 1) * 4 +  S.ord]);
        	 else
        		 return null;
         }
         return null;
     }
     public static Card GetCard(String inn)
     {
         if (inn != null)
         {
             int V = Card.GetValueFromString(inn);
             CardSuit S = Card.GetSuitFromString(inn);
             if (V >= 1 && V <= 13 && S != CardSuit.ERR)
                 return GetCard(V, S);             
         }
         return null;
     }
     //public static int  NumCC=0;  //給CC類別的自動生成使用
}
