package C2015;
class Nothing {
	public static int NumCC=0;
}
public enum CC {   //列出所有的牌,可以讓除錯區的寫法簡單一點
	C1,D1,H1,S1,
	C2,D2,H2,S2,
	C3,D3,H3,S3,
	C4,D4,H4,S4,
	C5,D5,H5,S5,
	C6,D6,H6,S6,
	C7,D7,H7,S7,
	C8,D8,H8,S8,
	C9,D9,H9,S9,
	C10,D10,H10,S10,
	C11,D11,H11,S11,
	C12,D12,H12,S12,
	C13,D13,H13,S13;
	public final Card that;
	private static boolean init=SHistory.Create();  //創建SHistory物件和CardDeck物件
	CC() {
		that=CardDeck.GetCard(Nothing.NumCC++);		
	}
}
