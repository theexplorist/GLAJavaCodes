package Session10;

public class FirstBadVersion {

	public static boolean utilIsBad(char version) {
		if(version == 'B') {
			return true;
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] versions = {'G', 'G', 'G', 'G', 'B'};
		
		int n = versions.length;
		int l = -1, r = n - 1;
		
		while(r > l + 1) { // l and r are adjacent - break -> r = l + 1
			
			int mid = (l + r) / 2;
			
			if(utilIsBad(versions[mid])) { //version mid is bad
				r = mid;
			} else {
				l = mid;
			}
		}
		
		System.out.println(r);
	}

}
