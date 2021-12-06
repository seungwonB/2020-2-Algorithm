

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree root;
		BinaryTree LeftTemp; 
		BinaryTree RightTemp;

		BinaryTree LeftSubroot;
		BinaryTree RightSubroot;

		BinaryTree empty = new BinaryTree();

		LeftTemp = new BinaryTree(empty, 'A', empty); //왼쪽과 오른쪽은 비어있고 가운데에만 값 저장
		RightTemp = new BinaryTree(empty, 'B', empty); // 위와 동일

		LeftSubroot = new BinaryTree(LeftTemp, '+', RightTemp); // LeftTemp와 RightTemp를 각각 왼, 오에 저장 그리고 가운데에 값 저장

		LeftTemp = new BinaryTree(empty, 'C', empty);
		RightTemp = new BinaryTree(empty, 'D', empty);

		RightSubroot = new BinaryTree(LeftTemp, '/', RightTemp); // 위와 동일
		root = new BinaryTree(LeftSubroot, '*', RightSubroot); 

		System.out.println("====root====");
		root.show(); 

		System.out.println("=====root's right subTree");
		root.rightSubTree().show();
		System.out.println("=====root's left subTree");
		root.leftSubTree().show();

	}

}
