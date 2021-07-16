package Session1;

public class PrintInc {

	private static void inc(int n) {
		// TODO Auto-generated method stub
//pop
		if(n  == 0) {
			return;
		}
		
		inc(n - 1);//recursive work
		System.out.println(n); // my work
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		inc(5);
	}

}
