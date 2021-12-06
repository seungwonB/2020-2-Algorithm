
public class WGraph {
	private int vertex_size;
	private int[][] weights;

	public WGraph(int vertex_size) {
		this.weights = new int[vertex_size][vertex_size];
		this.vertex_size = vertex_size;

		for (int i = 0; i < this.vertex_size; i++) {
			for (int j = 0; j < this.vertex_size; j++) {
				if (i == j)
					weights[i][j] = 0; // 자기 자신은 0으로 초기화
				else
					weights[i][j] = 999; // 무한(임의의수 999)으로 초기화
			}
		}
	}

	public void insertEdge(int i, int j, int w) {
		if (weights[i][j] == 999)
			weights[i][j] = w; // 삽입되는 간선에 가중치 부과
	}

	// 음의 가중치가 허용된 최단 경로
	public void BellmanFord(int v) {
		int[] dist = new int[vertex_size]; // 각 간선의 최단경로를 저장하는 배열

		for (int i = 0; i < vertex_size; i++) {
			dist[i] = weights[v][i]; // 시작정점v를 기준으로 dist 초기화
		}

		for (int k = 2; k < vertex_size; k++) { // 시작 정점과 도달하는 정점 2개를 제외
			for (int u = 0; u < vertex_size; u++) {
				if (u != v) { // 시작 정점과 같지 않는 정점들에 대해서
					for (int i = 0; i < vertex_size; i++) {
						if (weights[i][u] != 0 || weights[i][u] != 999) { // 자기 자신이 아니고 간선이 있는 경우
							// i에서 u로 가는 모든 경로를 비교 하여 가장 짧은 기리를 택한다.
							// 정점v에서 i로 가는 가중치와 i에서 u로 가는 가중치를 더한 값이 정점v에서 u로가는 가중치보다 더 작으면 그 가중치를 택한다.
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

	// 모든 정점 쌍의 최단 경로
	public void allShortestPath() {
		int[][] dist = new int[vertex_size][vertex_size]; // 가중치 인접행렬 dist
		int i, j, k;

		for (i = 0; i < vertex_size; i++) {
			for (j = 0; j < vertex_size; j++) {
				dist[i][j] = weights[i][j]; // 가중치 인접 행렬에 가중치 복사
			}
		}

		for (k = 0; k < vertex_size; k++) {
			System.out.printf("Stage : %d\n", k);
			for (i = 0; i < vertex_size; i++) {
				for (j = 0; j < vertex_size; j++) {
					// i에서j로 가는 가중치를 중간에 i가 k를 거쳐서 k에서 j로 가는 길이와 비교를 한다. 
					// 그래서 그 중 더 짧은 길이를 가중치로 저장한다.
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
