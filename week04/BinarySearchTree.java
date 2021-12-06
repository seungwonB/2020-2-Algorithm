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
				if ((int) k < (int) p.getKey()) { // �����ϰ��� �ϴ� ���� ���� ����� ������ ������
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
				if ((int) k < (int) q.getKey()) { // Ű ���� ����� ������ ������
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
				if ((int) k < (int) t.getKey())
					t = t.getLeft(); // ������ �������� ��������
				else if ((int) k > (int) t.getKey())
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
				if ((int) k < (int) p.getKey()) // insert�� ����
					p = p.getLeft();
				else if ((int) k > (int) p.getKey())
					p = p.getRight();
				else
					break;
			} else {
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");
			}
			if ((int) k == (int) p.getKey()) // ���� ������ break
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
}
