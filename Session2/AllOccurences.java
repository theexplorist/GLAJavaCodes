package Session2;

public class AllOccurences {

	private static int[] sol(int[] arr, int curr, int n, int search, int count) {
		// TODO Auto-generated method stub

		if(curr == n) {
			int[] ans = new int[count];
			if(count == 0) {
				System.out.println(-1);
			}
			return ans;
		}
		if(arr[curr] == search) {
			int[] recA = sol(arr, curr + 1, n, search, count + 1);
			//modification
			recA[count] = curr;
			return recA;
		} else {
			int[] recA = sol(arr, curr + 1, n, search, count);
			return recA;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 2, 4, 2, 5, 2};
		int n = 6;
		int[] ans = sol(arr, 0, n, 7, 0);
	
		for(int indices : ans) {
			System.out.println(indices);
		}
	}

}
