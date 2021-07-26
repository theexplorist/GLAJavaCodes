package Session10;

public class LIS {

	private static int longestInc(int[] arr, int prev, int curr, int n) {
		// TODO Auto-generated method stub

		if(curr == n) {
			return 0;
		}
		int inc = 0, exc = 0;
		if(prev == -1 || arr[prev] < arr[curr]) {
			inc =  1 + longestInc(arr, curr, curr + 1, n);
		}
		
		exc = longestInc(arr, prev, curr + 1, n);
		
		return Math.max(inc, exc);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {10,9,2,5,3,7,101,18};
		
		int n = arr.length;
		
		System.out.println(longestInc(arr, -1, 0, n));
	}

}
