package Session12;

public class StockSpanBrute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {50, 20, 30, 40, 10};
		
		int n = arr.length;
		
		int[] span = new int[n];
		
		span[0] = 1;
		
		for(int curr = 1; curr < n; curr++) {
			span[curr] = 1;
			
			for(int left = curr - 1; left >= 0; left--) {
				if(arr[left] < arr[curr]) {
					span[curr]++;
				} else { //curr <= left
					break;
				}
			}
		}
		
		for(int e : span) {
			System.out.println(e);
		}
		
	}

}
