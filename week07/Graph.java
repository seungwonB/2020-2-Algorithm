
public class Graph {
	private int[][] matrix;
	private int size;

	public Graph(int size) {
		this.matrix = new int[size][size];
		this.size = size;
	}

	public void add(int i, int k) {
		if(i >= size || k >= size) {
			System.out.println("그래프에 없는 정점입니다.");
		}
		matrix[i][k] = 1; //i와 k를 잇는 간선이 생기기때문에 각각 1을 삽입
		matrix[k][i] = 1; //무방향이기때문에 그 반대도 1을 삽입
	}

	public void delete(int i, int k) {
		matrix[i][k] = 0; //간선 삭제되기 때문에 0
		matrix[k][i] = 0; //무방향이기때문에 그 반대도 0
	}

	public void show() {
		if (this.size == 0) {
			System.out.println("No Matrix");
			return;
		}
		for (int i = 0; i < size; i++) {
			String temp = "";
			for (int j = 0; j < size; j++) {
				if (this.matrix[i][j] == 1) {
					temp += j + " ";
				}
			}
			if (!temp.equals("")) {
				System.out.println(i + " : " + temp);
			}
		}
	}
}
