
public class Heap {
	private int nNode;
	private int maxSize;
	private int heap[];

	public Heap() {
		nNode = 0;
		maxSize = 0;
		heap = new int[maxSize];
	}

	public Heap(int[] tree) {
		nNode = tree.length;
		maxSize = tree.length;
		heap = tree;
	}

	public void heapFull() {
		maxSize++;
		int tempHeap[] = new int[maxSize];

		for (int i = 0; i < maxSize - 1; i++) {
			tempHeap[i] = heap[i];
		}
		heap = tempHeap;
	}

	public void insert(int item) {
		if (nNode == maxSize) 
			heapFull(); //배열을 하나 늘려준다.
		int i;
		for (i = nNode;;) {
			if (i == 0) //처음 삽입하는 경우
				break; 
			if (item < heap[(i - 1) / 2]) //삽입할 노드의 키 값이 부모 노드 키 값보다 작은 경우
				break;
			heap[i] = heap[(i - 1) / 2]; //그 반대의 경우는 최대 히프의 조건이 만족되지 않으므로 자리를 바꿔줘야한다. 
			i = (i - 1) / 2; //i가 부모노드로 설정되면 다시 반복문을 통해 값을 비교한다.
		}
		heap[i] = item; //i번째 배열에 값을 넣어준다.
		nNode++; //새로 첨가될 노드가 있으므로 배열을 증가시켜준다.
	}

	public int delete() {
		if (nNode == 0) {
			System.out.println("삭제할 노드가없습니다.");
			return -1;
		}
		int item = heap[0]; //삭제할 최상위 원소
		int temp = heap[nNode - 1];//이동시킬 원소(맨 마지막 노드에 있는 원소로 마지막 노드는 삭제되기 때문에 임시로 저장해둔다)
		nNode--; //히프 크기를 하나 감소시킨다.
		int i = 0; //부모 노드
		int j = 1; //자식 노드
		while (j <= nNode) {
			if (j < nNode) {
				if (heap[j] < heap[j + 1]) //삭제할 두 자식 노드 중에서 큰 원소 값과 비교하여 
					j = j + 1; //j는 큰 원소를 가리킨다. 
			}
			if (temp > heap[j]) //자식 노드 원소보다 크면 반복문 종료. 그 자리에 마지막 노드에 있던 원소를 삽입하면 되기 때문이다.
				break;
			heap[i] = heap[j]; //자식을 위로 올린다.
			i = j; //부모는 자식을 가리킨다.
			j = (j * 2) + 1; //자식은 그 자식을 가리킨다.
		}
		heap[i] = temp; 
		maxSize--;
		return item;
	}

	public void show() {
		for (int i = 0; i < maxSize; i++) {
			System.out.print(heap[i] + " | ");
		}
		System.out.println();
	}
}
