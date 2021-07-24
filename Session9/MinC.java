package Session9;

public class MinC {

	private static int minCost(int[][] grid, int cr, int cc, int er, int ec) {
		// TODO Auto-generated method stub

		if(cr > er || cc > ec) {
			return Integer.MAX_VALUE;
		}
		
		if(cr == er && cc == ec) {
			return grid[cr][cc];
		}
		int right = minCost(grid, cr, cc + 1, er, ec);
		int down = minCost(grid, cr + 1, cc, er, ec);
		
		int myAns = Math.min(right, down) + grid[cr][cc];
		return myAns;
	}
	public static void main(String[] args) {
		
		int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		System.out.println(minCost(grid, 0, 0, grid.length - 1, grid[0].length - 1));
	}
}
