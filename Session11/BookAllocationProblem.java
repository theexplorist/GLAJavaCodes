package Session11;

public class BookAllocationProblem {

	private static boolean canReadAll(int[] pages, int maxC, int numStudents) {
		// TODO Auto-generated method stub

		int studentNumber = 1;
		int pagesRead = 0;
		
		int i = 0;
		
		while(i < pages.length) {
			
			if(studentNumber > numStudents) {
				return false;
			}
			if(pagesRead + pages[i] <= maxC) {
				pagesRead += pages[i];
				i++;
			} else {
				studentNumber++;
				pagesRead = 0;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 12, 34, 67, 90 };
		int n = arr.length;

		int l = 0, r = 12 + 34 + 67 + 90;

		while (r > l + 1) {
			int mid = (l + r) / 2; // maxC

			if (canReadAll(arr, mid, 2)) {
				r = mid;
			} else {
				l = mid;
			}

		}
		
		System.out.println(r);
	}

}
