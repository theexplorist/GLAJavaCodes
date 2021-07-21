package Session6;

public class LetterCombinations {

	static String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	private static void sol(String inp, String out) {
		// TODO Auto-generated method stub
		if(inp.length() == 0) {
			System.out.println(out);
			return;
		}

		char currentDigitChar = inp.charAt(0); // '2'
		int currDigInt = currentDigitChar - '0'; //2
		
		String mappedString = mapping[currDigInt]; //"abc"
		
		for(int i = 0; i < mappedString.length(); i++) {
			String bachiHuiString = inp.substring(1); //27 -> 7
			sol(bachiHuiString, out + mappedString.charAt(i));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sol("273", "");
	}

}
