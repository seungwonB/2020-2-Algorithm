

class BinaryTree {
	private TreeNode root = new TreeNode();

	public BinaryTree() { //공백생성자
		this.root = null;
	}  

	public BinaryTree(BinaryTree left, Object data, BinaryTree right) { //매개변수 3개를 갖는 생성자
		this.root.setItem(data);
		this.root.setLeft(left.root);
		this.root.setRight(right.root);
	}

	public boolean isEmpty() {
		if (this.root == null)
			return true;
		else
			return false;
	}

	public Object rootData() {
		if (this.isEmpty()) {
			System.out.println("Tree is Empty!!");
			return null;
		} else
			return root.getItem();
	}

	public BinaryTree leftSubTree() {
		if (this.root.getLeft() == null)
			return null;
		else {
			BinaryTree left = new BinaryTree(); 
			left.root = this.root.getLeft(); //루트의 왼쪽 값
			return left; //반환타입이 BinaryTree이기 때문에 this.root.getLeft()는 반환불가 getLeft는 TreeNode임
		}
	}

	public BinaryTree rightSubTree() {
		if (this.root.getRight() == null)
			return null;
		else {
			BinaryTree right = new BinaryTree();
			right.root = this.root.getRight();
			return right;
		}
	}

	public void show() {
		BinaryTree right = this.rightSubTree();
		BinaryTree left = this.leftSubTree();
		
		System.out.println("root item = " + this.rootData());
		System.out.println("left item = " + left.root.getItem()); //this.leftSubTree().root.getItem();
		System.out.println("right item = " + right.root.getItem()); //this.rightSubTree().root.getItem();
	}

}