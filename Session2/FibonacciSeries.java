package Session2;

public class FibonacciSeries {

	private static int fib(int n) {
		// TODO Auto-generated method stub

		if(n == 0 || n == 1) {
			return n;
		}
		int c1 = fib(n - 1);
		int c2 = fib(n - 2);
		
		return c1 + c2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fib(5));
	}

}
