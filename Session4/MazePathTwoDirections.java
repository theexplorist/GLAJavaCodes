package Session4;

public class MazePathTwoDirections {

	static int count;
	private static int mazePrint(int cr, int cc, int er, int ec, String path) {
		// TODO Auto-generated method stub

		if(cr > er || cc > ec) {
			return 0; //laat
		}
		
		if(cr == er && cc == ec) {
			count++;
			System.out.println(path);
			return 1;
		}
		
		int ct = 0;
		//2 choices
		ct = ct + mazePrint(cr, cc + 1, er, ec, path + 'R');
		ct = ct + mazePrint(cr + 1, cc, er, ec, path + 'D'); 
		return ct;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		int t = 2;
		while(t-- != 0) {
			int n = 3, m = 3;
			count = 0; //reinit
			int ans = mazePrint(0, 0, n - 1, m - 1, "");
		
			System.out.println(ans);
		}
		
	}

}
