
public class WGraph {
	private int vertex_size; // 정점의 수
	private int e; // 간선의 수
	private int[][] weights; // 가중치를 저장하는 배열

	// 가중치 그래프
	public WGraph(int vertex_size) {
		this.weights = new int[vertex_size][vertex_size]; // 정점의 수만큼 배열 생성
		this.vertex_size = vertex_size;
		e = 0;
		for (int i = 0; i < this.vertex_size; i++) {
			for (int j = 0; j < this.vertex_size; j++) {
				if (i == j)
					weights[i][j] = 0; // 자기 자신은 가중치가 존재하지 않으므로 0으로 초기화
				else
					weights[i][j] = -1; // 나머진 모두 일단 -1로 초기화
			}
		}
	}

	public void insertEdge(int i, int k, int w) {
		if (weights[i][k] == -1 && weights[k][i] == -1) { // 삽입될 i와k에
			weights[i][k] = w; // 가중치 부과
			weights[k][i] = w; // 가중치 부과
			e++; // 간선의 수 증가
		}
	}

	// 그래프 출력
	public void print() {
		for (int i = 0; i < vertex_size; i++) {
			for (int j = 0; j < vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]); // 자기 자신은 0, 연결되어 있으면 가중치, 연결 되어있지 않으면 -1 출력
			}
			System.out.println();
		}
	}

	public Edge[] kruskal() {
		Edge[] T = new Edge[(vertex_size - 1)]; // 최소 비용 신장 트리
		MinHeap edgeList = new MinHeap(); // 그래프의 간선 리스트 오름차순.

		for (int i = 0; i < vertex_size; i++) {
			for (int j = i + 1; j < vertex_size; j++) {
				if (weights[i][j] != -1) { // 가중치가 존재한다면
					Edge item = new Edge(i, j, weights[i][j]); // 정점들과 가중치를
					edgeList.insert(item); // 리스트에 저장
				}
			}
		}

		UnionFind u = new UnionFind(vertex_size); // 그래프는 사이클이 생기면 안되므로 사이클을 방지하고 집합을 합병하는 UnionFind
		int p = -1;

		while (p < vertex_size - 2 && edgeList.numberElements() > 0) { // 트리에 포함된 간선 수, 검사할 간선 수
			Edge e = edgeList.delete(); // 가중치가 가장 작은 값을 제거
			if (!u.find(e.getStart(), e.getEnd())) { // 제거한 값의 start와 end값을 가지는 값이 있는지 확인. 없을 경우 제어문 진입
				p++;
				T[p] = e; // 제거했던 값을 트리에 삽입
				u.union(e.getStart(), e.getEnd()); // 간선이 부속된 두 정점 그룹을 합병
			}
		}
		return T;
	}

	public Edge[] prim(int i) { // i는 시작 정점
		Edge[] T = new Edge[vertex_size - 1]; // 최소 비용 신장 트리
		int Tptr = -1; //인덱스

		MinHeap edgeList = new MinHeap(); // 그래프의 간선 리스트 오름차순.

		UnionFind uf = new UnionFind(vertex_size);

		for (int j = 0; j < vertex_size; j++) {
			if (weights[i][j] != -1 && weights[i][j] != 0) // 정점 0에 대해 다른 간선들의 가중치가 존재한다면(또한 자기자신이 아니면)
				edgeList.insert(new Edge(i, j, weights[i][j]));// 0에 부속한 간선만 리스트에 삽입
		}

		while (Tptr < vertex_size - 2) {
			Edge edge2 = edgeList.delete(); // 가중치가 가장 작은 값을 제거
			if (!uf.find(edge2.getStart(), edge2.getEnd())) {
				Tptr++;
				T[Tptr] = edge2; // 트리에 추가
				uf.union(i, edge2.getEnd()); // 합병
				for (int k = 0; k < vertex_size; k++) {
					if (weights[edge2.getEnd()][k] != -1 && weights[edge2.getEnd()][k] != 0)
						//트리에 추가된 간선의 end부분에 부속한 간선들을 리스트에 삽입하여 그 간선으로 다시 반복 작업 
						edgeList.insert(new Edge(edge2.getEnd(), k, weights[edge2.getEnd()][k]));
				}
			}
		}
		return T;
	}

}
