import java.util.*;

public class BinarySearchTree {
	private TreeNode rootNode;

	// 삽입하는 메소드
	public void BSTinsert(Object k) {
		TreeNode p = rootNode;
		TreeNode q = p;

		while (p != null) {
			q = p;
			if (k instanceof Integer) {
				if (objectCompareToInteger(k, p.getKey()) < 0) { // 삽입하고자 하는 값이 현재 노드의 값보다 작으면
					p = p.getLeft(); // 왼쪽으로 내려가고
				} else // 크면
					p = p.getRight(); // 오른쪽으로 내려간다.
			} else {
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
				return;
			}
		}
		TreeNode newNode = new TreeNode(k);

		if (rootNode == null)
			rootNode = newNode;
		else {
			if (k instanceof Integer) {
				if (objectCompareToInteger(k, q.getKey()) < 0) { // 키 값이 노드의 값보다 작으면
					q.setLeft(newNode); // 왼쪽을 새 노드에 연결 시킨다.
				} else { // 크면
					q.setRight(newNode); // 오른쪽을 새 노드에 연결 시킨다.
				}
			} else {
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
				return;
			}
		}
	}

	// 검색하는 메소드
	public TreeNode BSTsearch(Object k) {
		TreeNode t = rootNode;
		while (t != null) {
			if (k instanceof Integer) {
				if (objectCompareToInteger(k, t.getKey()) < 0)
					t = t.getLeft(); // 작으면 왼쪽으로 내려가고
				else if (objectCompareToInteger(k, t.getKey()) > 0)
					t = t.getRight(); // 크면 오른쪽으로 내려가고
				else
					return t; // 같으면 t값 반환
			} else {
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
				return null;
			}
		}
		return null;
	}

	// 최대 키 값 탐색
	private TreeNode maxNode(TreeNode root) {
		TreeNode p = root;
		if (p.getRight() == null)
			return p; // 오른쪽이 루트보다 크니까 오른쪽 값이 없으면 루트가 최대 값
		else
			return p.getRight(); // 오른쪽값 반환
	}

	// 삭제하는 메소드
	private TreeNode delete(TreeNode root, Object k) {
		TreeNode p = root; // 현재(자식)
		TreeNode q = root; // 부모
		while (p != null) {
			q = p;
			if (k instanceof Integer) {
				if (objectCompareToInteger(k, p.getKey()) < 0) // insert와 동일
					p = p.getLeft();
				else if (objectCompareToInteger(k, p.getKey()) > 0)
					p = p.getRight();

			} else {
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");
			}
			if (objectCompareToInteger(k, p.getKey()) == 0)
				break;
		}
		if (p == null) // 아무것도 할 수 없는 경우
		{
			System.out.println("해당 값이 존재하지 않습니다.");
			return null;
		}
		if ((p.getLeft() == null) && p.getRight() == null) { // 단말 노드일 경우
			if (p == root) { // 루트에 null을 넣어주면 됨
				p = null;
			} else if (q.getLeft() == p) { // 좌측자식일 경우 간단히 부모의 left를 끊어주면됨
				q.setLeft(null);
			} else {
				q.setRight(null); // 위와 동일
			}
		} else if ((p.getLeft() == null) || (p.getRight() == null)) { // 자식이 하나인 경우
			if (p == root) { // 루트이면
				if (p.getLeft() == null) // 좌측자식이 없으면
					p = p.getRight(); // 오른쪽 자식이 루트로 올라오면 됨.
				else // 우측자식이 없으면
					p = p.getLeft(); // 좌측 자식이 루트로 올라오면 됨.
			} else if (p.getLeft() != null) { // 왼쪽자식이 있는 경우
				if (q.getLeft() == p) // 부모의 좌측에 값이 있으면 부모가 자식이 가리키던 왼쪽자식을 가리키면됨.
					q.setLeft(p.getLeft());
				else // 부모의 우측에 값이 있으면
					q.setRight(p.getLeft()); // 자식이 가리키던 왼쪽을 부모의 오른쪽이 가리키면 됨.
			} else { // 오른쪽자식이 있는 경우
				if (q.getRight() == p) // 부모의 우측에 자식이 있을 때
					q.setRight(p.getRight()); // 부모의 오른쪽이 자식의 오른쪽을 가리키게 .
				else // 부모의 좌측에 자식이 있을 때
					q.setLeft(p.getRight()); // 부모의 좌측은 자식의 우측을 가리키게.
			}
		} else { // 자식이 둘인 경우
			q = maxNode(p.getLeft()); // 왼쪽에서 최대값을 찾아서
			p.setKey(q.getKey()); // 삭제하고자 하는 값을 대체
		}
		return root;
	}

	public void BSTdelete(Object k) {
		rootNode = delete(rootNode, k);
	}

	private void printNode(TreeNode n) {
		if (n != null) {
			System.out.print("(");
			printNode(n.getLeft());
			System.out.print(" " + n.getKey() + " ");
			printNode(n.getRight());
			System.out.print(")");
		}
	}

	public void print() {
		printNode(rootNode);
		System.out.println();
	}

	@SuppressWarnings("unused")
	private int objectCompareToInteger(Object s1, Object s2) {
		if ((int) s1 < (int) s2)
			return -1;
		else if ((int) s1 > (int) s2)
			return 1;
		else
			return 0;
	}

	//분할하는 메소드이다. 루트 노드를 중심으로 왼쪽(작은값) 서브트리는 bBST, 오른쪽(큰값) 서브트리는 cBST로 만들면 된다.
	public boolean split(BinarySearchTree bBST, BinarySearchTree cBST, Object x) {
		TreeNode Small = new TreeNode(); // 작은 값들(왼쪽)의 노드생성 left tree가 시작하는 위치
		TreeNode Large = new TreeNode(); // 큰 값들(오른쪽)의 노드생성 right tree가 시작하는 위치
		TreeNode S = Small; // 작은 값들의 순회포인터 처음엔 small노드를 가리킨다.
		TreeNode L = Large; // 큰 값들의 순회포인터 처음엔 large노드를 가리킨다.
		TreeNode p = this.rootNode; //노드 순회포인터 현재노드의 위치를 가리킨다.

		while (p != null) {
			if (x instanceof Integer) {
				if (objectCompareToInteger(x, p.getKey()) == 0) { // x값과 key값이 같으면
					S.setRight(p.getLeft()); //S는 small노드의 포인터이므로 p의 왼쪽자식과 연결한다.
					L.setLeft(p.getRight()); //L은 Large노드의 포인터이므로 p의 오른쪽 자식과 연결한다.
					bBST.setRootNode(Small.getRight()); //왼쪽 서브트리 bBST로 분할된다.
					cBST.setRootNode(Large.getLeft()); //오른쪽 서브트리 cBST로 분할된다.
					return true;
				}//분할하고자 하는 x가 key값보다 작을 때 이 서브트리는 bBST에 속한다. 
				else if (objectCompareToInteger(x, p.getKey()) < 0) { 
					L.setLeft(p); //Large노드를 가리키던 L이 P를 가리키게 한다.
					L = p; //L은 P로 옮긴다. 이 작업들의 이유는 연결할 오른쪽 서브트리를 찾기 위함이다.
					p = p.getLeft(); //x가 더 작기 때문에 왼쪽으로 내려간다.
				} else { //분할하고자 하는 x가 key값 보다 클 때 이 서브트리는 cBST에 속한다.
					S.setRight(p); //Small노드를 가리키던 S가 P를 가리키게 한다.
					S = p; // S는 P로 옮긴다. 이 작업들의 이유는 연결할 왼쪽 서브트리를 찾기 위함이다.
					p = p.getRight(); //x가 더 크기 때문에 오른쪽으로 내려간다. 
				}
			}
		}
		//p가 널이되어 반복문을 빠져나오면 split할 값이 없는 것이므로 모두 널을 넣어준다.
		S.setRight(null); 
		L.setLeft(null); 
		bBST.setRootNode(Small.getRight()); 
		cBST.setRootNode(Large.getLeft()); 
		return false;
	}

	private void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}

	public TreeNode getRootNode() {
		return rootNode;
	}
}
