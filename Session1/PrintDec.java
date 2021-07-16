package Session1;

public class PrintDec {

	private static void dec(int n) {
		// TODO Auto-generated method stub
        //push/build
		if (n == 0) {
			return;
		}
		System.out.println(n); // my work
		dec(n - 1);// recursive work
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		dec(5);
	}

}
