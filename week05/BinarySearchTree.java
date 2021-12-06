import java.util.*;

public class BinarySearchTree {
	private TreeNode rootNode;

	// �����ϴ� �޼ҵ�
	public void BSTinsert(Object k) {
		TreeNode p = rootNode;
		TreeNode q = p;

		while (p != null) {
			q = p;
			if (k instanceof Integer) {
				if (objectCompareToInteger(k, p.getKey()) < 0) { // �����ϰ��� �ϴ� ���� ���� ����� ������ ������
					p = p.getLeft(); // �������� ��������
				} else // ũ��
					p = p.getRight(); // ���������� ��������.
			} else {
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");
				return;
			}
		}
		TreeNode newNode = new TreeNode(k);

		if (rootNode == null)
			rootNode = newNode;
		else {
			if (k instanceof Integer) {
				if (objectCompareToInteger(k, q.getKey()) < 0) { // Ű ���� ����� ������ ������
					q.setLeft(newNode); // ������ �� ��忡 ���� ��Ų��.
				} else { // ũ��
					q.setRight(newNode); // �������� �� ��忡 ���� ��Ų��.
				}
			} else {
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");
				return;
			}
		}
	}

	// �˻��ϴ� �޼ҵ�
	public TreeNode BSTsearch(Object k) {
		TreeNode t = rootNode;
		while (t != null) {
			if (k instanceof Integer) {
				if (objectCompareToInteger(k, t.getKey()) < 0)
					t = t.getLeft(); // ������ �������� ��������
				else if (objectCompareToInteger(k, t.getKey()) > 0)
					t = t.getRight(); // ũ�� ���������� ��������
				else
					return t; // ������ t�� ��ȯ
			} else {
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");
				return null;
			}
		}
		return null;
	}

	// �ִ� Ű �� Ž��
	private TreeNode maxNode(TreeNode root) {
		TreeNode p = root;
		if (p.getRight() == null)
			return p; // �������� ��Ʈ���� ũ�ϱ� ������ ���� ������ ��Ʈ�� �ִ� ��
		else
			return p.getRight(); // �����ʰ� ��ȯ
	}

	// �����ϴ� �޼ҵ�
	private TreeNode delete(TreeNode root, Object k) {
		TreeNode p = root; // ����(�ڽ�)
		TreeNode q = root; // �θ�
		while (p != null) {
			q = p;
			if (k instanceof Integer) {
				if (objectCompareToInteger(k, p.getKey()) < 0) // insert�� ����
					p = p.getLeft();
				else if (objectCompareToInteger(k, p.getKey()) > 0)
					p = p.getRight();

			} else {
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");
			}
			if (objectCompareToInteger(k, p.getKey()) == 0)
				break;
		}
		if (p == null) // �ƹ��͵� �� �� ���� ���
		{
			System.out.println("�ش� ���� �������� �ʽ��ϴ�.");
			return null;
		}
		if ((p.getLeft() == null) && p.getRight() == null) { // �ܸ� ����� ���
			if (p == root) { // ��Ʈ�� null�� �־��ָ� ��
				p = null;
			} else if (q.getLeft() == p) { // �����ڽ��� ��� ������ �θ��� left�� �����ָ��
				q.setLeft(null);
			} else {
				q.setRight(null); // ���� ����
			}
		} else if ((p.getLeft() == null) || (p.getRight() == null)) { // �ڽ��� �ϳ��� ���
			if (p == root) { // ��Ʈ�̸�
				if (p.getLeft() == null) // �����ڽ��� ������
					p = p.getRight(); // ������ �ڽ��� ��Ʈ�� �ö���� ��.
				else // �����ڽ��� ������
					p = p.getLeft(); // ���� �ڽ��� ��Ʈ�� �ö���� ��.
			} else if (p.getLeft() != null) { // �����ڽ��� �ִ� ���
				if (q.getLeft() == p) // �θ��� ������ ���� ������ �θ� �ڽ��� ����Ű�� �����ڽ��� ����Ű���.
					q.setLeft(p.getLeft());
				else // �θ��� ������ ���� ������
					q.setRight(p.getLeft()); // �ڽ��� ����Ű�� ������ �θ��� �������� ����Ű�� ��.
			} else { // �������ڽ��� �ִ� ���
				if (q.getRight() == p) // �θ��� ������ �ڽ��� ���� ��
					q.setRight(p.getRight()); // �θ��� �������� �ڽ��� �������� ����Ű�� .
				else // �θ��� ������ �ڽ��� ���� ��
					q.setLeft(p.getRight()); // �θ��� ������ �ڽ��� ������ ����Ű��.
			}
		} else { // �ڽ��� ���� ���
			q = maxNode(p.getLeft()); // ���ʿ��� �ִ밪�� ã�Ƽ�
			p.setKey(q.getKey()); // �����ϰ��� �ϴ� ���� ��ü
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

	//�����ϴ� �޼ҵ��̴�. ��Ʈ ��带 �߽����� ����(������) ����Ʈ���� bBST, ������(ū��) ����Ʈ���� cBST�� ����� �ȴ�.
	public boolean split(BinarySearchTree bBST, BinarySearchTree cBST, Object x) {
		TreeNode Small = new TreeNode(); // ���� ����(����)�� ������ left tree�� �����ϴ� ��ġ
		TreeNode Large = new TreeNode(); // ū ����(������)�� ������ right tree�� �����ϴ� ��ġ
		TreeNode S = Small; // ���� ������ ��ȸ������ ó���� small��带 ����Ų��.
		TreeNode L = Large; // ū ������ ��ȸ������ ó���� large��带 ����Ų��.
		TreeNode p = this.rootNode; //��� ��ȸ������ �������� ��ġ�� ����Ų��.

		while (p != null) {
			if (x instanceof Integer) {
				if (objectCompareToInteger(x, p.getKey()) == 0) { // x���� key���� ������
					S.setRight(p.getLeft()); //S�� small����� �������̹Ƿ� p�� �����ڽİ� �����Ѵ�.
					L.setLeft(p.getRight()); //L�� Large����� �������̹Ƿ� p�� ������ �ڽİ� �����Ѵ�.
					bBST.setRootNode(Small.getRight()); //���� ����Ʈ�� bBST�� ���ҵȴ�.
					cBST.setRootNode(Large.getLeft()); //������ ����Ʈ�� cBST�� ���ҵȴ�.
					return true;
				}//�����ϰ��� �ϴ� x�� key������ ���� �� �� ����Ʈ���� bBST�� ���Ѵ�. 
				else if (objectCompareToInteger(x, p.getKey()) < 0) { 
					L.setLeft(p); //Large��带 ����Ű�� L�� P�� ����Ű�� �Ѵ�.
					L = p; //L�� P�� �ű��. �� �۾����� ������ ������ ������ ����Ʈ���� ã�� �����̴�.
					p = p.getLeft(); //x�� �� �۱� ������ �������� ��������.
				} else { //�����ϰ��� �ϴ� x�� key�� ���� Ŭ �� �� ����Ʈ���� cBST�� ���Ѵ�.
					S.setRight(p); //Small��带 ����Ű�� S�� P�� ����Ű�� �Ѵ�.
					S = p; // S�� P�� �ű��. �� �۾����� ������ ������ ���� ����Ʈ���� ã�� �����̴�.
					p = p.getRight(); //x�� �� ũ�� ������ ���������� ��������. 
				}
			}
		}
		//p�� ���̵Ǿ� �ݺ����� ���������� split�� ���� ���� ���̹Ƿ� ��� ���� �־��ش�.
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
