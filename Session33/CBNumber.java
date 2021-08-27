package Session33;

public class CBNumber {

	private static boolean kyaVisHai(boolean[] vis, int si, int ei) { //si -> Inc, ei -> exc
		// TODO Auto-generated method stub

		for(int i = si; i < ei; i++) {
			if(vis[i] == true) {
				return true;
			}
		}
		
		return false;
	}
	private static boolean kyaCBHai(String subStr) {
		// TODO Auto-generated method stub

		long subStrVal = Long.valueOf(subStr);
		
		if(subStrVal == 0 || subStrVal == 1) {
			return false;
		}
		
		long[] list = {2,3,5,7,11,13,17,19,23,29};
		
		for(long e : list) {
			if(e == subStrVal) {
				return true;
			}
		}
		
		for(long e : list) {
			if(subStrVal % e == 0) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "4993";
		boolean[] vis = new boolean[str.length()];
		
		int ct = 0;
		for(int l = 1; l <= str.length(); l++) {
			for(int si = 0; si <= str.length() - l ; si++) {
				int ei = si + l;
				
				String subStr = str.substring(si, ei);
				
				if(kyaCBHai(subStr) == true && kyaVisHai(vis, si, ei) == false) {
					ct++;
					for(int i = si; i < ei; i++) {
						vis[i] = true;
					}
				}
					 
				
			}
		}
		
		System.out.println(ct);
	}

}
