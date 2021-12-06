import java.util.*;

public class Graph {
	private Node[] header;
	private int size;

	public Graph(int size) {
		this.header = new Node[size];
		this.size = size;

		for (int i = 0; i < size; i++) {
			this.header[i] = null;
		}
	}

	// 깊이 우선 탐색 : 정점 i를 방문하여 i에 인접한 정점 중 아직 방문하지 않은 정점들을 스택에 저장, 스택에서 정점 삭제 후 다시 반복,
	// 공백이 되면 연산종료
	public void DFS(int i) {
		boolean[] visit = new boolean[header.length]; // 정점의 수만큼 배열 생성
		int j; // pop으로 꺼내질 변수 j

		for (j = 0; j < header.length; j++) {
			visit[j] = false; // 모든 정점을 방문하지 않은 것으로 마크
		}

		Stack<Integer> stack = new Stack<Integer>(); // 방문할 정점을 저장하는 스택
		stack.push(i); // 시작 정점 i를 스택에 저장

		while (!stack.isEmpty()) { // 스택이 공백이 될 떄까지 반복
			j = stack.pop(); // 스택에 마지막에 저장된 값을 pop하여 j에 저장
			Node node = header[j]; // j로 이동

			if (visit[j] == false) { // 정점 j를 방문하지 않았다면
				System.out.print(j + " "); // 지금 j를 방문하고
				visit[j] = true; // 방문한 것으로 마크
				while (node != null) { // 정점 j에 인접한 정점 중에서
					if (visit[node.getVertex()] == false) // 아직 방문하지 않은 정점들을 모두
						stack.push(node.getVertex()); // 스택에 저장
					node = node.getLink(); // 다음 노드로 이동
				}
			}
		}
	}

	// 너비 우선 탐색 : 정점 i를 방문 후 인접한 정점 중 아직 방문하지 않은 정점을 큐에 저장, 정점을 삭제 후 다시 반복, 큐가 공백이
	// 되면 연산 종료
	public void BFS(int i) {
		boolean[] visit = new boolean[header.length];
		int idx;

		for (int j = 0; j < header.length; j++) {
			visit[j] = false; // 모든 정점을 방문하지 않은 것으로 마크
		}

		Queue<Integer> queue = new LinkedList<Integer>(); // 큐는 방문할 정점을 저장하는 큐
		queue.add(i); // 시작 정점 i를 큐에 저장
		while (!queue.isEmpty()) { // 큐가 공백이 될 때까지 반복
			idx = queue.remove(); // 큐에서 삭제
			Node node = header[idx]; // idx로 이동

			if (visit[idx] == false) { // 정점 idx를 방문하지 않았다면
				System.out.print(idx + " "); // idx를 방문하고
				visit[idx] = true; // 방문한 것으로 마크
			}
			while (node != null) { // 정점 idx에 인접한 정점 중에서
				if (visit[node.getVertex()] == false) // 아직 방문하지 않은 정정들을 모두
					queue.add(node.getVertex()); // 큐에 저장
				node = node.getLink(); // 다음 노드로 이동
			}
		}
	}

	public void add(int i, int k) {
		Node newNode = new Node(k); // 삽입될 k를 가진 노드
		Node newNode2 = new Node(i);// 삽입될 i를 가진 노드

		if (header[i] == null) // 노드가 없으면
			header[i] = newNode; // 바로 노드삽입
		else {
			Node p = header[i]; // i를 가리키는 포인터
			while (p.getLink() != null) { // 삽입할 곳을 찾기 위해 null이 아닐 때까지 다음 값으로 넘어감
				p = p.getLink();
			}
			p.setLink(newNode); // 마지막 링크에 노드삽입
		}
		if (header[k] == null) // k도 i와 마찬가지
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
		if (header[i] == null || header[k] == null) { // 둘 다 null이면 삭제할 값이 없다는 뜻
			System.out.println("This is fault delete");
			return;
		}

		if (header[i].getVertex() == k) { // i의 vertex값과 삭제할 값이 같으면
			header[i] = header[i].getLink(); // i를 그 다음 노드에 연결시켜준다.
		} else {
			Node q = header[i]; // 현재노드를 가리킴
			Node p = q.getLink(); // 그 다음노드를 가리킴
			while (p.getVertex() == k) { // 값을 찾을 때 까지 이동
				q = p;
				p = p.getLink();
			}
			q.setLink(p.getLink()); // 값을 찾았으면 현재노드(삭제할 값을 가진 노드의 전 뇨드)의 link를 그 다음(p의 다음)에 연결시켜준다.
			p.setLink(null);
		}
		if (header[k].getVertex() == i) { // 위와 동일
			header[k] = header[k].getLink();
		} else {
			Node q = header[k];
			Node p = q.getLink();
			while (p.getVertex() == i) {
				q = p;
				p = p.getLink();
			}
			q.setLink(p.getLink());
			p.setLink(null);
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
