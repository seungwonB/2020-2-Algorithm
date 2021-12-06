public class Vertex_graph {
	private Node[] header;
	private int size;

	public Vertex_graph(int size) {
		this.header = new Node[size];
		this.size = size;

		for (int i = 0; i < size; i++) {
			this.header[i] = null;
		}
	}

	public void add(int i, int k) {
		Node newNode = new Node(k); //���Ե� k�� ���� ���
		Node newNode2 = new Node(i);//���Ե� i�� ���� ���

		if (header[i] == null) //��尡 ������
			header[i] = newNode; //�ٷ� ������
		else {
			Node p = header[i]; // i�� ����Ű�� ������
			while (p.getLink() != null) { // ������ ���� ã�� ���� null�� �ƴ� ������ ���� ������ �Ѿ
				p = p.getLink();
			}
			p.setLink(newNode); // ������ ��ũ�� ������ 
		}
		if (header[k] == null)  // k�� i�� ��������
			header[k] = newNode2;
		else {
			Node q = header[k];
			while (q.getLink() != null) {
				q = q.getLink();
			}
			q.setLink(newNode2);
		}

	}

	public void delete(int i, int k) {
		if (header[i] == null || header[k] == null) { //�� �� null�̸� ������ ���� ���ٴ� ��
			System.out.println("This is fault delete");
			return;
		}

		if (header[i].getVertex() == k) { //i�� vertex���� ������ ���� ������
			header[i] = header[i].getLink(); //i�� �� ���� ��忡 ��������ش�.
		} else {
			Node q = header[i]; //�����带 ����Ŵ
			Node p = q.getLink(); //�� ������带 ����Ŵ
			while (p.getVertex() == k) { //���� ã�� �� ���� �̵�
				q = p; 
				p = p.getLink();
			}
			q.setLink(p.getLink()); //���� ã������ ������(������ ���� ���� ����� �� ����)�� link�� �� ����(p�� ����)�� ��������ش�.
		}
		if (header[k].getVertex() == i) { //���� ����
			header[k] = header[k].getLink();
		} else {
			Node q = header[k];
			Node p = q.getLink();
			while (p.getVertex() == i) {
				q = p;
				p = p.getLink();
			}
			q.setLink(p.getLink());
		}
	}

	public void show() {
		if (this.size == 0) {
			System.out.println("No Vertex");
		}

		for (int i = 0; i < size; i++) {
			Node temp = header[i];

			System.out.print(i + " : ");

			while (temp != null) {
				System.out.print(temp.getVertex() + " ");
				temp = temp.getLink();
			}
			System.out.println();
		}
	}
}
