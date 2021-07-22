package Session7;

import java.util.Arrays;

public class FibonacciSeries {

	private static int fib(int n, int[] dp) {
		// TODO Auto-generated method stub

		if(n == 0 || n == 1) {
			return n;
		}
		
		if(dp[n] != -1) {
			return dp[n];
		}
		
		//first time
		int c1 = fib(n - 1, dp);
		int c2 = fib(n - 2, dp);
		
		return dp[n] = c1 + c2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(fib(n, dp));
	}

}
