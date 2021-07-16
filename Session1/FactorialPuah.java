package Session1;

public class FactorialPuah {

	private static void fact(int n, int ans) {
		// TODO Auto-generated method stub
		if(n == 0 || n == 1) {
			System.out.println(ans);
			return;
		}
		fact(n - 1, n * ans);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		fact(5, 1);
	}

}
