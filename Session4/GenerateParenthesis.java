package Session4;

public class GenerateParenthesis {

	private static void genP(String ans, int oc, int cc, int n) {
		// TODO Auto-generated method stub

		//Base case
		if(oc == n && cc == n) {
			System.out.println(ans);
			return;
		}
		// '('
		
		if(oc < n) {
			genP(ans + '(', oc + 1, cc, n);
		}
		
		// ')'
		
		if(oc > cc) {
			genP(ans + ')', oc, cc + 1, n);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		genP("", 0, 0,3);
	}
}
