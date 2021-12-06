
public class WGraph {
	private int vertex_size;
	private int[][] weights;

	public WGraph(int vertex_size) {
		this.weights = new int[vertex_size][vertex_size];
		this.vertex_size = vertex_size;

		for (int i = 0; i < this.vertex_size; i++) {
			for (int j = 0; j < this.vertex_size; j++) {
				if (i == j)
					weights[i][j] = 0; // �ڱ� �ڽ��� 0���� �ʱ�ȭ
				else
					weights[i][j] = 999; // ����(�����Ǽ� 999)���� �ʱ�ȭ
			}
		}
	}

	public void insertEdge(int i, int j, int w) {
		if (weights[i][j] == 999)
			weights[i][j] = w; // ���ԵǴ� ������ ����ġ �ΰ�
	}

	// ���� ����ġ�� ���� �ִ� ���
	public void BellmanFord(int v) {
		int[] dist = new int[vertex_size]; // �� ������ �ִܰ�θ� �����ϴ� �迭

		for (int i = 0; i < vertex_size; i++) {
			dist[i] = weights[v][i]; // ��������v�� �������� dist �ʱ�ȭ
		}

		for (int k = 2; k < vertex_size; k++) { // ���� ������ �����ϴ� ���� 2���� ����
			for (int u = 0; u < vertex_size; u++) {
				if (u != v) { // ���� ������ ���� �ʴ� �����鿡 ���ؼ�
					for (int i = 0; i < vertex_size; i++) {
						if (weights[i][u] != 0 || weights[i][u] != 999) { // �ڱ� �ڽ��� �ƴϰ� ������ �ִ� ���
							// i���� u�� ���� ��� ��θ� �� �Ͽ� ���� ª�� �⸮�� ���Ѵ�.
							// ����v���� i�� ���� ����ġ�� i���� u�� ���� ����ġ�� ���� ���� ����v���� u�ΰ��� ����ġ���� �� ������ �� ����ġ�� ���Ѵ�.
							if (dist[u] > dist[i] + weights[i][u])
								dist[u] = dist[i] + weights[i][u];
						}
					}
				}
			}
		}

		System.out.println("\n==== Best Path ====");
		for (int i = 0; i < vertex_size; i++) {
			System.out.print(dist[i] + " ");
		}
		System.out.println();
	}

	// ��� ���� ���� �ִ� ���
	public void allShortestPath() {
		int[][] dist = new int[vertex_size][vertex_size]; // ����ġ ������� dist
		int i, j, k;

		for (i = 0; i < vertex_size; i++) {
			for (j = 0; j < vertex_size; j++) {
				dist[i][j] = weights[i][j]; // ����ġ ���� ��Ŀ� ����ġ ����
			}
		}

		for (k = 0; k < vertex_size; k++) {
			System.out.printf("Stage : %d\n", k);
			for (i = 0; i < vertex_size; i++) {
				for (j = 0; j < vertex_size; j++) {
					// i����j�� ���� ����ġ�� �߰��� i�� k�� ���ļ� k���� j�� ���� ���̿� �񱳸� �Ѵ�. 
					// �׷��� �� �� �� ª�� ���̸� ����ġ�� �����Ѵ�.
					if (dist[i][j] > (dist[i][k] + dist[k][j])) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
					System.out.printf("[ %3d ]", dist[i][j]);
				}
				System.out.println();
			}
		}
	}

	public void print() {
		for (int i = 0; i < vertex_size; i++) {
			for (int j = 0; j < vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]);
			}
			System.out.println();
		}
	}
}
