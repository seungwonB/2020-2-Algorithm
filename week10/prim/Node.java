
public class Node {
	private int vertex; //�� �ʵ�
	private Node link; //��ũ �ʵ�

	public Node(int vertex) { //������ ���
		this.vertex = vertex;
		this.link = null;
	}

	public Node(int vertex, Node link) { //���� ��ũ �ʵ带 ���� ���
		this.vertex = vertex;
		this.link = link;
	}
	//getter, setter �Լ�
	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

}
