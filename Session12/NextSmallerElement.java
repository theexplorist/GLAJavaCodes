package Session12;

import java.util.Stack;

public class NextSmallerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1, 5, 6, 2, 3};
		int n = arr.length;
		
		Stack<Integer> st = new Stack<>();
		
		int[] nge = new int[n];
		st.push(0);
		
		for(int curr = 1; curr < arr.length; curr++) {
			
			//is curr building nse of top building?
			while(!st.isEmpty() && arr[st.peek()] > arr[curr]) {
				nge[st.pop()] = arr[curr];
				//System.out.println(st.pop() + "->" + arr[curr]);
			}
			
			st.push(curr);
		}
		
		while(!st.isEmpty()) {
			nge[st.pop()] = -1;
			//System.out.println(st.pop() + "->" + -1);
		}
		
		for(int i = 0; i < n; i++) {
			//arr[i] = nge[i]
			
			System.out.println(arr[i] + "->" + nge[i]);
		}
	}

}
