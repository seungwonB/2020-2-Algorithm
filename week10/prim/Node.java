
public class Node {
	private int vertex; //값 필드
	private Node link; //링크 필드

	public Node(int vertex) { //마지막 노드
		this.vertex = vertex;
		this.link = null;
	}

	public Node(int vertex, Node link) { //값과 링크 필드를 가진 노드
		this.vertex = vertex;
		this.link = link;
	}
	//getter, setter 함수
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
