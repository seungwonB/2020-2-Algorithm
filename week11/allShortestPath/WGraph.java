
public class WGraph {
	private int vertex_size;
	private boolean[][] matrix;

	public WGraph(int vertex_size) {
		this.matrix = new boolean[vertex_size][vertex_size];
		this.vertex_size = vertex_size;

		for (int i = 0; i < this.vertex_size; i++) {
			for (int j = 0; j < vertex_size; j++) {
				matrix[i][j] = false;
			}
		}
	}

	public void insertEdge(int i, int j) {
		if (!matrix[i][j])
			matrix[i][j] = true; // ���Ե� �������� true�� ǥ��
	}

	public void allShortestPath() {
		boolean[][] dist = new boolean[vertex_size][vertex_size];
		int i, j, k;

		for (i = 0; i < vertex_size; i++) {
			for (j = 0; j < vertex_size; j++) {
				dist[i][j] = matrix[i][j]; // ��� ��� false�� �ʱ�ȭ �۾�
			}
		}
		// ������ ��� ����� ����i���� j���� 0���� ū ������ ��ΰ� ������dist+[i,j] = true�� �׷��� ������ dist+[i,j]=0�� �Ǵ� ���
		for (k = 0; k < vertex_size; k++) {
			for (i = 0; i < vertex_size; i++) {
				for (j = 0; j < vertex_size; j++) {
					if (dist[i][k] && dist[k][j]) { // ����i���� k�ΰ��� ������ �ְ� ����k���� j�� ���� ������ ������
						dist[i][j] = true; // ���� i���� j�� ���� ������ �ִٴ� ���̴�.
					}
				}
			}
		}

		System.out.println("======== D+ ========");

		for (i = 0; i < vertex_size; i++) {
			for (j = 0; j < vertex_size; j++) {
				System.out.printf("[ %5b ]", dist[i][j]);
			}
			System.out.println();
		}
		// �ݻ� ������ ��� ����� ���� i���� j������ ��� ���̰� 0 �̻��� ��ΰ� ������ dist*[i,j]=1�̰�, �׷��� ������ dist*[i,j]=0�� ����̴�.
		for (k = 0; k < vertex_size; k++) {
			for (i = 0; i < vertex_size; i++) {
				for (j = 0; j < vertex_size; j++) {
					if (dist[i][k] || dist[k][j]) //���� i���� k�� ���� ��ΰ� �ְų� k���� j�� ���� ��ΰ� ������
						dist[i][i] = true; //�ڱ��ڽ� ���� true
				}
			}
		}

		System.out.println("======== D* ========");

		for (i = 0; i < vertex_size; i++) {
			for (j = 0; j < vertex_size; j++) {
				System.out.printf("[ %5b ]", dist[i][j]);
			}
			System.out.println();
		}
	}

	public void print() {
		for (int i = 0; i < vertex_size; i++) {
			for (int j = 0; j < vertex_size; j++) {
				System.out.printf("[ %5b ]", matrix[i][j]);
			}
			System.out.println();
		}
	}

}
