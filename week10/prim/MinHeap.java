//최소Heap
public class MinHeap {
	private int nNode;
	private int maxSize;
	private Edge[] heap;

	public MinHeap() {
		this.nNode = 1;
		this.maxSize = 6;
		this.heap = new Edge[maxSize];
	}

	public void heapFull() {
		maxSize++;
		Edge[] temp = new Edge[maxSize];
		for (int i = 1; i < maxSize - 1; i++) {
			temp[i] = heap[i];
		}
		heap = temp;
	}

	public void insert(Edge item) {
		int i;
		//힙이 full일 때 사이즈 증가
		if (nNode == maxSize)
			heapFull();

		for (i = nNode;;) {
			if (i == 1) // 처음 삽입하는 경우
				break;
			if (item.compareTo(heap[i / 2]) >= 0) //가중치 값이 0보다 크면 종료
				break; 
			heap[i] = heap[i / 2]; //자리 변경
			i = i / 2; // //부모로 설정
		}
		heap[i] = item;
		nNode++;
	}

	public Edge delete() {
		if (nNode == 0)
			return null;
		Edge item = heap[1]; // 삭제할 최상위 원소
		Edge temp = heap[nNode - 1]; // 이동시킬 원소(맨 마지막 노드에 있는 원소로 마지막 노드는 삭제되기 때문에 임시로 저장해둔다)
		nNode--; // 히프 크기를 하나 감소시킨다.
		int i = 1; // 부모 노드
		int j = 2; // 자식 노드
		while (j <= nNode) {
			if (j < nNode) {
				if (heap[j + 1].compareTo(heap[j]) < 0)
					j++; // 삭제할 두 자식 노드 중에서 작은 원소 값과 비교하여 j는 작은 원소를 가리킨다.
			}
			if (temp.compareTo(heap[j]) <= 0) // 자식 노드 원소보다 작으면 반복문 종료. 그 자리에 마지막 노드에 있던 원소를 삽입하면 되기 때문이다.
				break;
			heap[i] = heap[j]; // 자식을 위로 올린다.
			i = j; // 부모는 자식을 가리킨다.
			j = j * 2; // 자식은 그 밑 자식을 가리킨다.
		}
		heap[i] = temp;
		return item;
	}

	public int numberElements() { //원소의 수
		return nNode;
	}
}
