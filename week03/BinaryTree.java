package practice;

class BinaryTree {
	private TreeNode root = new TreeNode();
	//공백생성자
	public BinaryTree() {
		this.root = null;
	}
	//매개변수 1개를 갖는 생성자
	public BinaryTree(Object data) {
		this.root.setItem(data);
	}
	//매개변수 3개를 갖는 생성자
	public BinaryTree(BinaryTree left, Object data, BinaryTree right) {
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
			left.root = this.root.getLeft(); //루트의 왼쪽 값 즉 서브트리라고 보면 됨.
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

	public void preOrder_recursion() {
		preOrder_recursion_methods(this.root);
	}
	
	private void preOrder_recursion_methods(TreeNode T) {
		if (T != null) {
			//루트 노드를 방문
			System.out.print(T.getItem()+" ");
			//왼쪽 서브 트리를 전위 순회한다.
			preOrder_recursion_methods(T.getLeft());
			//오른쪽 서브 트리를 전위 순회한다.
			preOrder_recursion_methods(T.getRight());
		}
	}

	public void inOrder_recursion() {
		inOrder_recursion_methods(this.root);
	}

	private void inOrder_recursion_methods(TreeNode T) {
		if (T != null) {
			//왼쪽 서브 트리를 중위 순회한다.
			inOrder_recursion_methods(T.getLeft());
			//루트 노드 방문
			System.out.print(T.getItem() + " ");
			//오른쪽 서브 트리를 중위 순회한다.
			inOrder_recursion_methods(T.getRight());
		}
	}

	public void postOrder_recursion() {
		postOrder_recursion_methods(this.root);
	}

	private void postOrder_recursion_methods(TreeNode T) {
		if (T != null) {
			//왼쪽 서브 트리를 후위 순회한다.
			postOrder_recursion_methods(T.getLeft());
			//오른쪽 서브 트리를 후위 순회한다.
			postOrder_recursion_methods(T.getRight());
			//루트 노드 방문
			System.out.print(T.getItem()+" ");
		}
	}

	public BinaryTree copy() {
		BinaryTree newTree = new BinaryTree();
		newTree.root = theCopy(root);
		return newTree;
	}

	private TreeNode theCopy(TreeNode t) {
		if (t == null)
			return null;
		else {
			//트리노드 l에 왼쪽 서브 트리 복사
			TreeNode l = theCopy(t.getLeft());
			//트리노드 r에 오른쪽 서브 트리 복사
			TreeNode r = theCopy(t.getRight());
			//노드는 l , item, r 필드로 구성됨. newNode에 복사
			TreeNode newNode = new TreeNode(l, t.getItem(), r);
			return newNode;
		}
	}

	public boolean equals(BinaryTree tr) {
		return theEqual(this.root, tr.root);
	}

	private boolean theEqual(TreeNode s, TreeNode t) {
		if (s == null && t == null) { 
			return true;
		} else if (s != null && t != null) { //s와t가 널이 아닌 경우는 데이터가 있다는 뜻으로 검사해야 된다.
			if (s.getItem().equals(t.getItem())) { //먼저 item값이 같으면
				if (theEqual(s.getLeft(), t.getLeft())) { //왼쪽 값을 확인하고
					if (theEqual(s.getRight(), t.getRight())) { //오른쪽 값도 같으면 완전 동등하다는 뜻
						return theEqual(s.getRight(), t.getRight());
					} else
						return false;
				} else
					return false;
			} else
				return false;
		} else
			return false;
	}

	public void show() {
		BinaryTree right = this.rightSubTree();
		BinaryTree left = this.leftSubTree();

		System.out.println("root item = " + this.rootData());
		System.out.println("left item = " + left.root.getItem()); // this.leftSubTree().root.getItem();
		System.out.println("right item = " + right.root.getItem()); // this.rightSubTree().root.getItem();
	}

}