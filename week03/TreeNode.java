package practice;

public class TreeNode {
	private Object item;
	private TreeNode left;
	private TreeNode right;
	//공백생성자
	public TreeNode() {
		this.item = null;
		this.left = null;
		this.right = null;
	}
	//item만 갖는 생성자
	public TreeNode(Object item) {
		this.item = item;
		this.left = null;
		this.right = null;
	}
	//3개 모두 갖는 생성자
	public TreeNode(TreeNode left, Object item, TreeNode right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}
	//private인 item,left,right를 접근하기 위한 getter setter
	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}
