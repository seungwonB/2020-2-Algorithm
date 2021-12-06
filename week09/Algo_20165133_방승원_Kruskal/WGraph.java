
public class WGraph {
	private int vertex_size; //������ ��
	private int e; //������ ��
	private int[][] weights; //����ġ�� �����ϴ� �迭

	//����ġ �׷���
	public WGraph(int vertex_size) {
		this.weights = new int[vertex_size][vertex_size]; //������ ����ŭ �迭 ����
		this.vertex_size = vertex_size; 
		e = 0;
		for (int i = 0; i < this.vertex_size; i++) {
			for (int j = 0; j < this.vertex_size; j++) {
				if (i == j)
					weights[i][j] = 0; //�ڱ� �ڽ��� ����ġ�� �������� �����Ƿ� 0���� �ʱ�ȭ
				else
					weights[i][j] = -1; //������ ��� �ϴ� -1�� �ʱ�ȭ
			}
		}
	}

	public void insertEdge(int i, int k, int w) {
		if (weights[i][k] == -1 && weights[k][i] == -1) { //���Ե� i��k��
			weights[i][k] = w; //����ġ �ΰ�
			weights[k][i] = w; //����ġ �ΰ�
			e++; //������ �� ����
		}
	}
	//�׷��� ���
	public void print() {
		for (int i = 0; i < vertex_size; i++) {
			for (int j = 0; j < vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]); //�ڱ� �ڽ��� 0, ����Ǿ� ������ ����ġ, ���� �Ǿ����� ������ -1 ���
			}
			System.out.println();
		}
	}

	public Edge[] kruskal() {
		Edge[] T = new Edge[(vertex_size - 1)]; //�ּ� ��� ���� Ʈ��
		MinHeap edgeList = new MinHeap(); //�׷��c�� ���� ����Ʈ ��������.

		for (int i = 0; i < vertex_size; i++) { 
			for (int j = i + 1; j < vertex_size; j++) {
				if (weights[i][j] != -1) { //����ġ�� �����Ѵٸ�
					Edge item = new Edge(i, j, weights[i][j]); //������� ����ġ��
					edgeList.insert(item); //����Ʈ�� ����
				}
			}
		}

		UnionFind u = new UnionFind(vertex_size); //�׷����� ����Ŭ�� ����� �ȵǹǷ� ����Ŭ�� �����ϰ� ������ �պ��ϴ� UnionFind
		int p = -1;

		while (p < vertex_size - 2 && edgeList.numberElements() > 0) { //Ʈ���� ���Ե� ���� ��, �˻��� ���� ��
			Edge e = edgeList.delete(); //����ġ�� ���� ���� ���� ����
			if (!u.find(e.getStart(), e.getEnd())) { //������ ���� start�� end���� ������ ���� �ִ��� Ȯ��. ���� ��� ��� ����
				p++;
				T[p] = e; //�����ߴ� ���� Ʈ���� ����
				u.union(e.getStart(), e.getEnd()); //������ �μӵ� �� ���� �׷��� �պ�
			}
		}
		return T;
	}

}
