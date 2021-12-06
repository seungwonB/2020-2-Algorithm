
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
					weights[i][j] = 999; // 일단 나머지는 999로 초기화
			}
		}
	}

	public void insertEdge(int i, int k, int w) {
		if (weights[i][k] == 999) //삽입된 정점들에 가중치 부과
			weights[i][k] = w; 
	}

	public void print() {
		for (int i = 0; i < vertex_size; i++) {
			for (int j = 0; j < vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]);
			}
			System.out.println();
		}
	}

	public void shortestPath(int v) {
		boolean[] s = new boolean[vertex_size]; //최단 경로가 이미 찾아져서 확정된 정점의 집합
		int[] dist = new int[vertex_size]; // 최단 거리를 저장할 배열

		for (int i = 0; i < vertex_size; i++) { //배열 초기화
			s[i] = false; //방문하지 않았다는 뜻의 false
			dist[i] = weights[v][i]; 
		}

		s[v] = true; // 시작노드 방문
		dist[v] = 0;

		for (int i = 0; i < vertex_size - 2; i++) {
			int min = 999; //최소값을 가지는 변수	
			
			int u = v; //가장 최근에 s에 첨가된 노드를 가리키도록 하는 변수
			
			for (int j = 0; j < vertex_size; j++) {
				if ((min > dist[j]) && (s[j] == false))
					min = dist[j]; //방문하지 않은 노드의 최소값을 저장 
				if (dist[j] == min)
					u = j; //최소값을 가진 노드를 u라고 지정
			}
			
			s[u] = true; //찾은 노드는 true로 방문했다는 것을 표시

			for (int w = 0; w < vertex_size; w++) {
				if (s[w] == false) { //방문이 되지 않았다면 기존의 dist와 새롭게 생긴 간선의 dist를 비교해야됨
					// 기존에 있던 w의 dist와 정점u로가는 가중치 + u에서w로 가는 가중치를 비교하여 더 작은 값을 dist[w]에 저장
					if (dist[w] > (dist[u] + weights[u][w])) 
						dist[w] = dist[u] + weights[u][w];
				}
			}

			System.out.printf("===== STAGE %d =====", (i + 1));
			System.out.println("\nselect vertex : " + u);

			for (int k = 0; k < vertex_size; k++) {
				System.out.print(dist[k] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
