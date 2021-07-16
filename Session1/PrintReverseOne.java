package Session1;

public class PrintReverseOne {

	private static void reversee(int[] arr, int curr) {
		// TODO Auto-generated method stub

		if(curr == -1) {
			return;
		}
		System.out.println(arr[curr]);
		reversee(arr, curr - 1); //tail
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6, 7, 8, 9};
		int curr = 3;
		reversee(arr, curr);

	}

}
