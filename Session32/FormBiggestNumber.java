package Session32;

public class FormBiggestNumber {

	private static int compare(int curr, int curr_1) { //x = curr, y = curr_1
		// TODO Auto-generated method stub
		String xy = curr + "" + curr_1;
		String yx = curr_1 + "" + curr;
		
		int vxy = Integer.valueOf(xy);
		int vyx = Integer.valueOf(yx);
		if(vxy > vyx) {
			// no swap
			//return -ve number
			return -1;
		} else {
			return 1;
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {54, 546, 548, 60};
		int n = arr.length;
		
		for(int cp = 1; cp <= n - 1; cp++) { //1, 2, 3
			
			for(int curr = 0; curr <= n - cp - 1; curr++) {
				
				//YX > XY then swap
				if(compare(arr[curr], arr[curr + 1]) > 0) {
					int temp = arr[curr];
					arr[curr] = arr[curr + 1];
					arr[curr + 1] = temp;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
	}

}
