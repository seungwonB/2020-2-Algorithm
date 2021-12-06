
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
					weights[i][j] = 999; // �ϴ� �������� 999�� �ʱ�ȭ
			}
		}
	}

	public void insertEdge(int i, int k, int w) {
		if (weights[i][k] == 999) //���Ե� �����鿡 ����ġ �ΰ�
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
		boolean[] s = new boolean[vertex_size]; //�ִ� ��ΰ� �̹� ã������ Ȯ���� ������ ����
		int[] dist = new int[vertex_size]; // �ִ� �Ÿ��� ������ �迭

		for (int i = 0; i < vertex_size; i++) { //�迭 �ʱ�ȭ
			s[i] = false; //�湮���� �ʾҴٴ� ���� false
			dist[i] = weights[v][i]; 
		}

		s[v] = true; // ���۳�� �湮
		dist[v] = 0;

		for (int i = 0; i < vertex_size - 2; i++) {
			int min = 999; //�ּҰ��� ������ ����	
			
			int u = v; //���� �ֱٿ� s�� ÷���� ��带 ����Ű���� �ϴ� ����
			
			for (int j = 0; j < vertex_size; j++) {
				if ((min > dist[j]) && (s[j] == false))
					min = dist[j]; //�湮���� ���� ����� �ּҰ��� ���� 
				if (dist[j] == min)
					u = j; //�ּҰ��� ���� ��带 u��� ����
			}
			
			s[u] = true; //ã�� ���� true�� �湮�ߴٴ� ���� ǥ��

			for (int w = 0; w < vertex_size; w++) {
				if (s[w] == false) { //�湮�� ���� �ʾҴٸ� ������ dist�� ���Ӱ� ���� ������ dist�� ���ؾߵ�
					// ������ �ִ� w�� dist�� ����u�ΰ��� ����ġ + u����w�� ���� ����ġ�� ���Ͽ� �� ���� ���� dist[w]�� ����
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
