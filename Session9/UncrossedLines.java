package Session9;

import java.util.Arrays;

public class UncrossedLines {

	private static int lCS(int[] s1, int[] s2, int n, int m, int[][] dp) {
		// TODO Auto-generated method stub

		if(n == 0 || m == 0) {
			return 0;
		}
		
		if(dp[n][m] != -1) {
			return dp[n][m];
		}
		if(s1[n - 1] == s2[m - 1]) {
			return dp[n][m] = 1 + lCS(s1, s2, n - 1, m - 1, dp);
		} else {
			int c1 = lCS(s1, s2, n, m - 1, dp);
			int c2 = lCS(s1, s2, n - 1, m, dp);
			
			return dp[n][m] = Math.max(c1, c2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] s1 = {1, 4, 2};
		int[] s2 = {1, 2, 4};
		
		int[][] dp = new int[s1.length + 1][s2.length + 1];
		for(int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(lCS(s1, s2, s1.length, s2.length, dp));
	}

}
