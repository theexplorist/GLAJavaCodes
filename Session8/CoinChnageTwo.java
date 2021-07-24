package Session8;

import java.util.Arrays;

public class CoinChnageTwo {

	private static int sol(int[] coins, int curr, int n, int amount, int[][] dp) {
		// TODO Auto-generated method stub

		if(amount == 0) {
			return 1;
		}
		
		if(curr == n) {
			return 0;
		}
		
		if(dp[curr][amount] != -1) {
			return dp[curr][amount];
		}
		
		int inc = 0, exc = 0;
		
		if(coins[curr] <= amount) {
			inc = sol(coins, curr, n, amount - coins[curr], dp);
		}
		
		exc = sol(coins, curr + 1, n, amount, dp);
		
		dp[curr][amount] = inc + exc;
		return inc + exc;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] coins = {1, 2, 5};
		int n = 3;
		int amount = 5;
		int[][] dp = new int[n + 1][amount + 1];
		
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		int ans = sol(coins, 0, n, amount, dp);
		System.out.println(ans);
	}

}
