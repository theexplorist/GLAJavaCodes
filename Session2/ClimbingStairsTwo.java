package Session2;

public class ClimbingStairsTwo {

	private static int ways(int n) {
		// TODO Auto-generated method stub

		if(n == 0) {
			return 1;
		}
		
		if(n < 0) {
			return 0;
		}
		int c1 = ways(n - 1);
		int c2 = ways(n - 2);
		
		return c1 + c2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ways(2));
	}

}
