
public class Graph {
	private int[][] matrix;
	private int size;

	public Graph(int size) {
		this.matrix = new int[size][size];
		this.size = size;
	}

	public void add(int i, int k) {
		if(i >= size || k >= size) {
			System.out.println("�׷����� ���� �����Դϴ�.");
		}
		matrix[i][k] = 1; //i�� k�� �մ� ������ ����⶧���� ���� 1�� ����
		matrix[k][i] = 1; //�������̱⶧���� �� �ݴ뵵 1�� ����
	}

	public void delete(int i, int k) {
		matrix[i][k] = 0; //���� �����Ǳ� ������ 0
		matrix[k][i] = 0; //�������̱⶧���� �� �ݴ뵵 0
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
