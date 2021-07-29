package Session13;

import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 1, 5, 6, 2, 3 };

		int n = arr.length;
		Stack<Integer> st = new Stack<>();

		int[] nse = new int[n];
		st.push(0);

		for (int curr = 1; curr < arr.length; curr++) {

			// is curr building nse of top building?
			while (!st.isEmpty() && arr[st.peek()] > arr[curr]) {
				nse[st.pop()] = curr;
				// System.out.println(st.pop() + "->" + arr[curr]);
			}

			st.push(curr);
		}

		while (!st.isEmpty()) {
			nse[st.pop()] = n;
			// System.out.println(st.pop() + "->" + -1);
		}

		for (int i = 0; i < n; i++) {
			// arr[i] = nge[i]

			System.out.println(arr[i] + "->" + nse[i]);
		}
		
		int[] pse = new int[n];
		st.push(0); // height
		pse[0] = -1;
		// System.out.println(arr[0] + "->" + -1);
		for (int curr = 1; curr < n; curr++) {

			while (!st.isEmpty() && arr[curr] <= arr[st.peek()]) {

				st.pop();
			}

			if (!st.isEmpty()) {
				pse[curr] = st.peek();
			} else {
				pse[curr] = -1;
			}

			st.push(curr);
		}

		System.out.println("-------------------------------");
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + "->" + pse[i]);
		}
		
		int maxArea = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			//ith building width
			int width = nse[i] - pse[i] - 1;
			int area = width * arr[i];
			
			maxArea = Math.max(maxArea, area);
			System.out.print(area + " ");
		}
		System.out.println();
		System.out.println(maxArea);
	}

}
