import java.util.*;
 
public class Graph {
	private Queue<Integer>[] Q; // 정점 i의 직속후속자를 저장하는 큐
	private Queue<Integer> ZeroPredQ; // 선행자가 없는 정점들을 저장하는 큐
	private LinkedList<Integer> sortedList; // 위상 정렬 결과를 보관하는 리스트

	private int[] indegree; // 정점의 진입차수를 저장하는 배열
	private int n; // 정점 수

	public Graph(int vertex) { // 생성자
		n = vertex; // 정점 수
		Q = new Queue[n]; // 정점 수 만큼 큐 배열 생성
		ZeroPredQ = new LinkedList<Integer>();
		sortedList = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			Q[i] = new LinkedList<Integer>(); // 각 Q[i]에 대해 초기화
		}
		indegree = new int[n];
	}

	public void insertEdge(int head, int tail) {
		Q[head].add(tail); // Q에 값 삽입
		indegree[tail]++; // 진입차수 증가
	}

	// 위상 정렬 알고리즘
	public void topologicalSort() {
		int i, v, successor;
		for (i = 0; i < n; i++) {
			if (indegree[i] == 0) // 선행자가 없는 경우
				ZeroPredQ.add(i); // i를 삽입하여 줌
		}

		if (ZeroPredQ.isEmpty()) { // 공백이면 싸이클이 존재한다는 뜻임.
			System.out.println("network has a cycle"); 
			return;
		}

		while (!ZeroPredQ.isEmpty()) {
			v = ZeroPredQ.remove(); // 선행자가 없는 정점 선택하여 제거
			sortedList.add(v); // 진입차수가 0인 정점들을 정렬된 결과 리스트에 삽입
			if (Q[v].isEmpty()) // 정점 v의 후속자가 없으면 
				continue; // 밖의 while 루프로
			else // 후속자가 있으면
				successor = Q[v].remove(); // 그 후속자를 successor로 설정
			while (true) { // 진입차수와 정점을 모두 제거하는 반복문
				indegree[successor]--; // 후속자의 진입차수 1감소 
				if (indegree[successor] == 0) // 제거하다보면 차수가 0이 됨 -> 즉 선행자가 없음
					ZeroPredQ.add(successor); // 선행자가 없으면 삽입
				if (!Q[v].isEmpty()) // 정점이 남아있다면
					successor = Q[v].remove(); // 다시 제거
				else
					break; // 모두 삭제되었으면 반복문 종료
			}
		}

		System.out.println("Topological Order is : ");
		while (!sortedList.isEmpty())
			System.out.print(sortedList.remove() + " ");
		System.out.println();
		System.out.println("End.");
	}
}
