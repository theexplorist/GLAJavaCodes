package Session13;

import java.util.Stack;

public class PrevSmallerElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 1, 5, 6, 2, 3 };

		int n = arr.length;
		int[] pse = new int[n];
		Stack<Integer> st = new Stack<>();

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

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + "->" + pse[i]);
		}
	}

}
