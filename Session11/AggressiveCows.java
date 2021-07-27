package Session11;

import java.util.Arrays;

public class AggressiveCows {

	private static boolean canPlaced(int[] stalls, int numCows, int minDist) {
		// TODO Auto-generated method stub

		int posPlaced = stalls[0]; //1
		int numPlaced = 1;
		
		for(int curr = 1; curr < stalls.length; curr++) {
			
			if(numPlaced == numCows) {
				return true;
			}
			if(stalls[curr] - posPlaced >= minDist) {
				numPlaced++;
				posPlaced = stalls[curr];
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] stalls = {1, 2, 8, 4, 9};
		int n = stalls.length;
		Arrays.sort(stalls);
		int cows = 3;
		int l = 0;//ache dost
		int r = stalls[n - 1] - stalls[0]; //iyer-jethalal
		
		while(r > l + 1) {
			int minDist = (l + r) / 2;//mid
			
			if(canPlaced(stalls, cows, minDist)) {
				l = minDist;
			} else {
				r = minDist;
			}
		}
		
		System.out.println(l);
	}

}
