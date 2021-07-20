package Session5;

public class All {

	private static boolean isPalindrome(String partition) {
		// TODO Auto-generated method stub

		int l = 0, r = partition.length() - 1;
		
		while(l < r) {
			if(partition.charAt(l) != partition.charAt(r)) {
				return false;
			}
			
			l++;
			r--;
		}
		return true;
	}
	private static void partition(String inp, String out) {
		// TODO Auto-generated method stub

		if(inp.length() == 0) {
			System.out.println(out);
			return;
		}
		for(int i = 1; i <= inp.length(); i++) {
			if(isPalindrome(inp.substring(0, i)))
			partition(inp.substring(i), out + inp.substring(0, i) + '|');
		}
	}
	
	public static void main(String[] args) {
		partition("nitin", "");
	}
}
