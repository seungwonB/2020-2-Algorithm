import java.util.*;

public class Graph {
	private Queue<Integer>[] Q; // ���� i�� �����ļ��ڸ� �����ϴ� ť
	private Queue<Integer> ZeroPredQ; // �����ڰ� ���� �������� �����ϴ� ť
	private LinkedList<Integer> sortedList; // ���� ���� ����� �����ϴ� ����Ʈ

	private int[] indegree; // ������ ���������� �����ϴ� �迭
	private int n; // ���� ��

	public Graph(int vertex) { // ������
		n = vertex; // ���� ��
		Q = new Queue[n]; // ���� �� ��ŭ ť �迭 ����
		ZeroPredQ = new LinkedList<Integer>();
		sortedList = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			Q[i] = new LinkedList<Integer>(); // �� Q[i]�� ���� �ʱ�ȭ
		}
		indegree = new int[n];
	}

	public void insertEdge(int head, int tail) {
		Q[head].add(tail); // Q�� �� ����
		indegree[tail]++; // �������� ����
	}

	// ���� ���� �˰���
	public void topologicalSort() {
		int i, v, successor;
		for (i = 0; i < n; i++) {
			if (indegree[i] == 0) // �����ڰ� ���� ���
				ZeroPredQ.add(i); // i�� �����Ͽ� ��
		}

		if (ZeroPredQ.isEmpty()) { // �����̸� ����Ŭ�� �����Ѵٴ� ����.
			System.out.println("network has a cycle"); 
			return;
		}

		while (!ZeroPredQ.isEmpty()) {
			v = ZeroPredQ.remove(); // �����ڰ� ���� ���� �����Ͽ� ����
			sortedList.add(v); // ���������� 0�� �������� ���ĵ� ��� ����Ʈ�� ����
			if (Q[v].isEmpty()) // ���� v�� �ļ��ڰ� ������ 
				continue; // ���� while ������
			else // �ļ��ڰ� ������
				successor = Q[v].remove(); // �� �ļ��ڸ� successor�� ����
			while (true) { // ���������� ������ ��� �����ϴ� �ݺ���
				indegree[successor]--; // �ļ����� �������� 1���� 
				if (indegree[successor] == 0) // �����ϴٺ��� ������ 0�� �� -> �� �����ڰ� ����
					ZeroPredQ.add(successor); // �����ڰ� ������ ����
				if (!Q[v].isEmpty()) // ������ �����ִٸ�
					successor = Q[v].remove(); // �ٽ� ����
				else
					break; // ��� �����Ǿ����� �ݺ��� ����
			}
		}

		System.out.println("Topological Order is : ");
		while (!sortedList.isEmpty())
			System.out.print(sortedList.remove() + " ");
		System.out.println();
		System.out.println("End.");
	}
}
