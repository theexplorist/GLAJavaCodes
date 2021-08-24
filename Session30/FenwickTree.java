package Session30;

import java.util.Arrays;

public class FenwickTree {

	//1 to i, l = 1, r = pos/i
	private static int sumQuery(int[] fenw, int i) {
		// TODO Auto-generated method stub

		int sum = 0;
		
		while(i > 0) {
			sum += fenw[i];
			int l = intervalLength(i);
			i = i - l;
		}
		
		return sum;
	}
	
	//index = 1, val = arr[1]
	private static void update(int[] fenw, int index, int val) {
		// TODO Auto-generated method stub

		while(index < fenw.length) {
			fenw[index] += val;
			int l = intervalLength(index);
			index = index + l;
		}
	}
	private static int intervalLength(int pos) {
		// TODO Auto-generated method stub

		return pos & -pos;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {0, 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
		int[] fenw = new int[12];
		
		for(int i = 1; i < arr.length; i++) {
			update(fenw, i, arr[i]);
		}
		
		System.out.println(sumQuery(fenw, 7));
		//range sum
		int l = 4, r = 7;
		
		int s17 = sumQuery(fenw, r);
		int s13 = sumQuery(fenw, l - 1);
		System.out.println(s17 - s13);
		System.out.println(Arrays.toString(fenw));
//		update(fenw, 2, 3);
//		System.out.println(Arrays.toString(fenw));
	}

}
