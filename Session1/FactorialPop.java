package Session1;

public class FactorialPop {

	private static int fact(int n) {
		// TODO Auto-generated method stub

		if(n == 0 || n == 1) { //base case
			return 1;
		}
		/*
		int recAns = fact(n - 1); //faith - recursive call
		int meraKaam = recAns * n; //my work 
		return meraKaam;
		*/
		
		return n * fact(n - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fact(3));
	}

}
