package Session4;

public class LexicoCounting {

	private static void lexicoPrint(int start, int end) {
		// TODO Auto-generated method stub
		
		if(start > end) {
			return;
		}
		
		System.out.println(start);
		int callDigit = 0;
		if(start == 0) {
			callDigit = 1;
		}
		
		while(callDigit <= 9) {
			lexicoPrint(start * 10 + callDigit, end);
			callDigit++;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lexicoPrint(0, 1000);
	}

}
