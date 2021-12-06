
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
			matrix[i][j] = true; // 삽입된 정점들은 true로 표시
	}

	public void allShortestPath() {
		boolean[][] dist = new boolean[vertex_size][vertex_size];
		int i, j, k;

		for (i = 0; i < vertex_size; i++) {
			for (j = 0; j < vertex_size; j++) {
				dist[i][j] = matrix[i][j]; // 모든 행렬 false로 초기화 작업
			}
		}
		// 이행적 폐쇄 행렬은 정점i에서 j까지 0보다 큰 길이의 경로가 있으면dist+[i,j] = true고 그렇지 않으면 dist+[i,j]=0이 되는 행렬
		for (k = 0; k < vertex_size; k++) {
			for (i = 0; i < vertex_size; i++) {
				for (j = 0; j < vertex_size; j++) {
					if (dist[i][k] && dist[k][j]) { // 정점i에서 k로가는 간선이 있고 정점k에서 j로 가는 간선이 있으면
						dist[i][j] = true; // 정점 i에서 j로 가는 간선이 있다는 뜻이다.
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
		// 반사 이행적 폐쇄 행렬은 정점 i에서 j까지의 경로 길이가 0 이상인 경로가 있으면 dist*[i,j]=1이고, 그렇지 않으면 dist*[i,j]=0인 행렬이다.
		for (k = 0; k < vertex_size; k++) {
			for (i = 0; i < vertex_size; i++) {
				for (j = 0; j < vertex_size; j++) {
					if (dist[i][k] || dist[k][j]) //정점 i에서 k로 가는 경로가 있거나 k에서 j로 가는 경로가 있으면
						dist[i][i] = true; //자기자신 또한 true
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
