package Session3;

public class GenAllSubsequences {

	private static void gen(String inp, String out) {
		// TODO Auto-generated method stub

		if(inp.length() == 0) {
			System.out.println(out);
			return;
		}
		
		
		char cc = inp.charAt(0);
		gen(inp.substring(1), out);
		gen(inp.substring(1), out + cc);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		gen("abc", "");
	}

}
