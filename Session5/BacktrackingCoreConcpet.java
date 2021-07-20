package Session5;

public class BacktrackingCoreConcpet {

	private static void gharDestroy(boolean[] house, int roomNo) {
		// TODO Auto-generated method stub

		if(roomNo == house.length) {
			return;
		}
		house[roomNo] = true;
		gharDestroy(house, roomNo + 1);
		house[roomNo] = false; //backtracking
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[] house = new boolean[4];
		for(boolean b : house) {
			System.out.print(b + " ");
		}
		
		System.out.println();
		gharDestroy(house, 0);
		
		for(boolean b : house) {
			System.out.print(b + " ");
		}
	}

}
