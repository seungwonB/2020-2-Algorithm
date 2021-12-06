import java.util.*;

public class Graph {
	private Node[] header;
	private int size;

	public Graph(int size) {
		this.header = new Node[size];
		this.size = size;

		for (int i = 0; i < size; i++) {
			this.header[i] = null;
		}
	}

	// ���� �켱 Ž�� : ���� i�� �湮�Ͽ� i�� ������ ���� �� ���� �湮���� ���� �������� ���ÿ� ����, ���ÿ��� ���� ���� �� �ٽ� �ݺ�,
	// ������ �Ǹ� ��������
	public void DFS(int i) {
		boolean[] visit = new boolean[header.length]; // ������ ����ŭ �迭 ����
		int j; // pop���� ������ ���� j

		for (j = 0; j < header.length; j++) {
			visit[j] = false; // ��� ������ �湮���� ���� ������ ��ũ
		}

		Stack<Integer> stack = new Stack<Integer>(); // �湮�� ������ �����ϴ� ����
		stack.push(i); // ���� ���� i�� ���ÿ� ����

		while (!stack.isEmpty()) { // ������ ������ �� ������ �ݺ�
			j = stack.pop(); // ���ÿ� �������� ����� ���� pop�Ͽ� j�� ����
			Node node = header[j]; // j�� �̵�

			if (visit[j] == false) { // ���� j�� �湮���� �ʾҴٸ�
				System.out.print(j + " "); // ���� j�� �湮�ϰ�
				visit[j] = true; // �湮�� ������ ��ũ
				while (node != null) { // ���� j�� ������ ���� �߿���
					if (visit[node.getVertex()] == false) // ���� �湮���� ���� �������� ���
						stack.push(node.getVertex()); // ���ÿ� ����
					node = node.getLink(); // ���� ���� �̵�
				}
			}
		}
	}

	// �ʺ� �켱 Ž�� : ���� i�� �湮 �� ������ ���� �� ���� �湮���� ���� ������ ť�� ����, ������ ���� �� �ٽ� �ݺ�, ť�� ������
	// �Ǹ� ���� ����
	public void BFS(int i) {
		boolean[] visit = new boolean[header.length];
		int idx;

		for (int j = 0; j < header.length; j++) {
			visit[j] = false; // ��� ������ �湮���� ���� ������ ��ũ
		}

		Queue<Integer> queue = new LinkedList<Integer>(); // ť�� �湮�� ������ �����ϴ� ť
		queue.add(i); // ���� ���� i�� ť�� ����
		while (!queue.isEmpty()) { // ť�� ������ �� ������ �ݺ�
			idx = queue.remove(); // ť���� ����
			Node node = header[idx]; // idx�� �̵�

			if (visit[idx] == false) { // ���� idx�� �湮���� �ʾҴٸ�
				System.out.print(idx + " "); // idx�� �湮�ϰ�
				visit[idx] = true; // �湮�� ������ ��ũ
			}
			while (node != null) { // ���� idx�� ������ ���� �߿���
				if (visit[node.getVertex()] == false) // ���� �湮���� ���� �������� ���
					queue.add(node.getVertex()); // ť�� ����
				node = node.getLink(); // ���� ���� �̵�
			}
		}
	}

	public void add(int i, int k) {
		Node newNode = new Node(k); // ���Ե� k�� ���� ���
		Node newNode2 = new Node(i);// ���Ե� i�� ���� ���

		if (header[i] == null) // ��尡 ������
			header[i] = newNode; // �ٷ� ������
		else {
			Node p = header[i]; // i�� ����Ű�� ������
			while (p.getLink() != null) { // ������ ���� ã�� ���� null�� �ƴ� ������ ���� ������ �Ѿ
				p = p.getLink();
			}
			p.setLink(newNode); // ������ ��ũ�� ������
		}
		if (header[k] == null) // k�� i�� ��������
			header[k] = newNode2;
		else {
			Node q = header[k];
			while (q.getLink() != null) {
				q = q.getLink();
			}
			q.setLink(newNode2);
		}

	}

	public void delete(int i, int k) {
		if (header[i] == null || header[k] == null) { // �� �� null�̸� ������ ���� ���ٴ� ��
			System.out.println("This is fault delete");
			return;
		}

		if (header[i].getVertex() == k) { // i�� vertex���� ������ ���� ������
			header[i] = header[i].getLink(); // i�� �� ���� ��忡 ��������ش�.
		} else {
			Node q = header[i]; // �����带 ����Ŵ
			Node p = q.getLink(); // �� ������带 ����Ŵ
			while (p.getVertex() == k) { // ���� ã�� �� ���� �̵�
				q = p;
				p = p.getLink();
			}
			q.setLink(p.getLink()); // ���� ã������ ������(������ ���� ���� ����� �� ����)�� link�� �� ����(p�� ����)�� ��������ش�.
			p.setLink(null);
		}
		if (header[k].getVertex() == i) { // ���� ����
			header[k] = header[k].getLink();
		} else {
			Node q = header[k];
			Node p = q.getLink();
			while (p.getVertex() == i) {
				q = p;
				p = p.getLink();
			}
			q.setLink(p.getLink());
			p.setLink(null);
		}
	}

	public void show() {
		if (this.size == 0) {
			System.out.println("No Vertex");
		}

		for (int i = 0; i < size; i++) {
			Node temp = header[i];

			System.out.print(i + " : ");

			while (temp != null) {
				System.out.print(temp.getVertex() + " ");
				temp = temp.getLink();
			}
			System.out.println();
		}
	}
}
