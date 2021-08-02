package Session15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BusyMan {

	static class Pair {
		int start;
		int end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.start + " " + this.end;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		List<Pair> activities = new ArrayList<>();
		while (n-- != 0) {
			int start = s.nextInt();
			int end = s.nextInt();
			activities.add(new Pair(start, end));

		}

		System.out.println(activities);

		// sort end time
		Collections.sort(activities, new Comparator<Pair>() {

			@Override
			public int compare(Pair act1, Pair act2) { // act1 -> current, act2 -> current + 1
				// TODO Auto-generated method stub
				return act1.end - act2.end; //> 0 //swap , no swap
			}

		});
		
		System.out.println(activities);
		
		int numActivites = 1; //act 0
		
		int endtime = activities.get(0).end;
		
		for(int curr = 1; curr < activities.size(); curr++) {
			int startTime = activities.get(curr).start;
			
			if(startTime >= endtime) {
				numActivites++;
				endtime = activities.get(curr).end;
			}
		}
		
		System.out.println(numActivites);
	}

}
