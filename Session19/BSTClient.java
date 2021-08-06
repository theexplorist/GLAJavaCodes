package Session19;

public class BSTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] in = {10, 20, 30, 40, 50, 60, 70};
		
		BSTFromInOrder bst = new BSTFromInOrder(in);
		
		bst.display();
		
		System.out.println("***********************");
		//bst.replaceWithLarger();
		bst.printInRange(25, 50);//inclusive
		//bst.display();
	}

}
