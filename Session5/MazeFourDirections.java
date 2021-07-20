package Session5;

public class MazeFourDirections {

	private static void mazePrint(int[][] maze, int cr, int cc, int er, int ec, String path, boolean[][] vis) {
		// TODO Auto-generated method stub

		if(cr < 0 || cc < 0 || cr > er || cc > ec || vis[cr][cc] == true || maze[cr][cc] == 1) {
			return;
		}
		
		if(cr == er && cc == ec) {
			System.out.println(path);
			return;
		}
		
		vis[cr][cc] = true;
		mazePrint(maze, cr - 1, cc, er, ec, path + 'U', vis);
		mazePrint(maze, cr + 1, cc, er, ec, path + 'D', vis);
		mazePrint(maze, cr, cc - 1, er, ec, path + 'L', vis);
		mazePrint(maze, cr, cc + 1, er, ec, path + 'R', vis);
		vis[cr][cc] = false; //backtracking step
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 4, m = 4;
		int[][] maze = {{0,1,0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}, {0, 1,1, 0}};
		mazePrint(maze, 0, 0, n - 1, m - 1, "", new boolean[n][m]);
		
		
	}

}
