package Session12;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> st = new Stack<>();
		System.out.println(st.isEmpty());
		st.push(1);
		
		//System.out.println(st.peek());
		
		st.push(2);
		
		//System.out.println(st.peek());
		
		st.push(3);
		
		System.out.println(st.pop());
		System.out.println(st.peek());
		
		System.out.println(st.isEmpty());
		
	}

}
