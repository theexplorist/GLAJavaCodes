package Session2;

public class FirstOccurence {

	private static int sol(int[] arr, int curr, int n, int search) {
		// TODO Auto-generated method stub
		if(curr == n) { //-ve base case
			return -1;
		} 
		
		if(arr[curr] == search) { //+ve
			return curr;
		} 
		
		int recAns = sol(arr, curr + 1, n, search);
		return recAns;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 2, 4, 2, 5};
		int n = 5;
		System.out.println(sol(arr, 0, n, 7));
	}

}
