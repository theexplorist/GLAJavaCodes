package Session12;

import java.util.Stack;

public class StockSpanOptimised {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 1, 1, 2, 1, 4, 6 };

		int n = arr.length;

		int[] span = new int[n];

		span[0] = 1;

		Stack<Integer> st = new Stack<>(); //building ke indexes
		st.add(0);
		for (int curr = 1; curr < n; curr++) {

			//arr[st.peek] < arr[curr]
			
			while(!st.isEmpty() && arr[st.peek()] < arr[curr]) {
				st.pop();
			}
			
			//jaise hi tumhe prev greater building mil jaegi
			
			//span curr = curr Ind - Prev greater building ind
			
			span[curr] = st.isEmpty() ? curr + 1 : curr - st.peek();
			st.push(curr);
		}
		
		for(int e : span) {
			System.out.print(e + " ");
		}
	}

}
