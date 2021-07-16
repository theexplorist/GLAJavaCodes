package Session1;

public class PrintReverseTwo {

	private static void reversee(int[] arr, int curr, int n) {
		// TODO Auto-generated method stub

		if(curr == n) {
			return;
		}
		reversee(arr, curr + 1, n); //king/head
		System.out.println(arr[curr]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {6, 7, 8, 9};
		int curr = 0;
		reversee(arr, curr, arr.length);
	}

}
