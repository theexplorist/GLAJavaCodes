package Session17;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<List<Integer>> big = new ArrayList<>();
		
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		big.add(l1);//2k
		big.add(l2);//1k
		
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(big);
		
		l1.add(2);
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(big);
		
		big.add(new ArrayList<>(l1));
		System.out.println(big );
		l1.add(3);
		
		System.out.println(l1);//[2, 3]
		System.out.println(l2);//[]
		System.out.println(big);//
	}

}
