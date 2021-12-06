
public class BSTInteger_split {
	public static void main(String args[])
	{
		BinarySearchTree aBST = new BinarySearchTree();
		
		System.out.println("[INFO] Insert ");
		
		aBST.BSTinsert(11);
		aBST.BSTinsert(9);
		aBST.BSTinsert(14);
		aBST.BSTinsert(22);
		aBST.BSTinsert(18);
		aBST.BSTinsert(16);
		aBST.BSTinsert(17);
		aBST.BSTinsert(15);
		
		System.out.println("===aBST print===");
		aBST.print();
		
		
		BinarySearchTree bBST = new BinarySearchTree();
		BinarySearchTree cBST = new BinarySearchTree();
		
		
		
		System.out.println("[INFO] Split 16");
		aBST.split(bBST,cBST,16);
		
		System.out.println("Left Tree");
		bBST.print();
		
		System.out.println("Right Tree");
		cBST.print();
		
		bBST = new BinarySearchTree();
		cBST = new BinarySearchTree();
		
		aBST = new BinarySearchTree();
		
		System.out.println("===aBST print===");
		
		aBST.BSTinsert(11);
		aBST.BSTinsert(9);
		aBST.BSTinsert(14);
		aBST.BSTinsert(22);
		aBST.BSTinsert(18);
		aBST.BSTinsert(16);
		aBST.BSTinsert(17);
		aBST.BSTinsert(15);
		
		aBST.print();
		
		System.out.println("[INFO] Split 19");
		aBST.split(bBST,cBST,19);
		
		System.out.println("Left Tree");
		bBST.print();
		
		System.out.println("Right Tree");
		cBST.print();
	}
}
