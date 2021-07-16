package Session2;

public class BoardPath {

	private static int ways(int curr, int dest) {
		// TODO Auto-generated method stub

		if(curr == dest) {
			return 1;
		}
		
		if(curr > dest) {
			return 0;
		}
		int c1 = ways(curr + 1, dest);
		int c2 = ways(curr + 2, dest);
		int c3 = ways(curr + 3, dest);
		int c4 = ways(curr + 4, dest);
		int c5 = ways(curr + 5, dest);
		int c6 = ways(curr + 6, dest);
		
		return c1 + c2 + c3 + c4 + c5 + c6 ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ways(0, 10));
	}

}
