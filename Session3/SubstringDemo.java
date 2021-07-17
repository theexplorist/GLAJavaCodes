package Session3;

public class SubstringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "coding";
		System.out.println(s.substring(2));
		System.out.println(s.substring(2, 5));
		
		int ci = 3;
		System.out.println(s.substring(0, ci) + s.substring(ci + 1));
	}

}
