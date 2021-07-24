package Session9;

public class EditDistance {

	private static int sol(String s1, String s2, int n, int m) {
		// TODO Auto-generated method stub

		if(n == 0 && m == 0) {
			return 0;
		}
		if(n == 0) {
			return m;
		}
		
		if(m == 0) {
			return n;
		}
		if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return sol(s1, s2, n - 1, m - 1);
		} else {
			int insert = sol(s1, s2, n, m - 1);
			int replace = sol(s1, s2, n - 1, m - 1);
			int delete = sol(s1, s2, n - 1, m);
			
			int myAns = Math.min(insert, Math.min(replace, delete)) + 1;
			return myAns;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "intention";
		String s2 = "execution";
		
		System.out.println(sol(s1, s2, s1.length(), s2.length()));
	}

}
