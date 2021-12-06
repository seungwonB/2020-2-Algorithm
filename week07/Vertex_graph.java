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
		Node newNode = new Node(k); //삽입될 k를 가진 노드
		Node newNode2 = new Node(i);//삽입될 i를 가진 노드

		if (header[i] == null) //노드가 없으면
			header[i] = newNode; //바로 노드삽입
		else {
			Node p = header[i]; // i를 가리키는 포인터
			while (p.getLink() != null) { // 삽입할 곳을 찾기 위해 null이 아닐 때까지 다음 값으로 넘어감
				p = p.getLink();
			}
			p.setLink(newNode); // 마지막 링크에 노드삽입 
		}
		if (header[k] == null)  // k도 i와 마찬가지
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
		if (header[i] == null || header[k] == null) { //둘 다 null이면 삭제할 값이 없다는 뜻
			System.out.println("This is fault delete");
			return;
		}

		if (header[i].getVertex() == k) { //i의 vertex값과 삭제할 값이 같으면
			header[i] = header[i].getLink(); //i를 그 다음 노드에 연결시켜준다.
		} else {
			Node q = header[i]; //현재노드를 가리킴
			Node p = q.getLink(); //그 다음노드를 가리킴
			while (p.getVertex() == k) { //값을 찾을 때 까지 이동
				q = p; 
				p = p.getLink();
			}
			q.setLink(p.getLink()); //값을 찾았으면 현재노드(삭제할 값을 가진 노드의 전 뇨드)의 link를 그 다음(p의 다음)에 연결시켜준다.
		}
		if (header[k].getVertex() == i) { //위와 동일
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
