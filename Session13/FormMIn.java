package Session13;

import java.util.Stack;

public class FormMIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "IDIIIIDD";
		
		Stack<Integer> st = new Stack<>();
		
		//0 -> 1, 1 > 2, 2 > 3
		
		for(int i = 0; i <= str.length(); i++) {
			st.push(i + 1);
			
			if(i == str.length() || str.charAt(i) == 'I') {
				
				while(!st.isEmpty()) {
					System.out.print(st.pop());
				}
			}
		}
	}

}
