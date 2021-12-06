//�ּ�Heap
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
		//���� full�� �� ������ ����
		if (nNode == maxSize)
			heapFull();

		for (i = nNode;;) {
			if (i == 1) // ó�� �����ϴ� ���
				break;
			if (item.compareTo(heap[i / 2]) >= 0) //����ġ ���� 0���� ũ�� ����
				break; 
			heap[i] = heap[i / 2]; //�ڸ� ����
			i = i / 2; // //�θ�� ����
		}
		heap[i] = item;
		nNode++;
	}

	public Edge delete() {
		if (nNode == 0)
			return null;
		Edge item = heap[1]; // ������ �ֻ��� ����
		Edge temp = heap[nNode - 1]; // �̵���ų ����(�� ������ ��忡 �ִ� ���ҷ� ������ ���� �����Ǳ� ������ �ӽ÷� �����صд�)
		nNode--; // ���� ũ�⸦ �ϳ� ���ҽ�Ų��.
		int i = 1; // �θ� ���
		int j = 2; // �ڽ� ���
		while (j <= nNode) {
			if (j < nNode) {
				if (heap[j + 1].compareTo(heap[j]) < 0)
					j++; // ������ �� �ڽ� ��� �߿��� ���� ���� ���� ���Ͽ� j�� ���� ���Ҹ� ����Ų��.
			}
			if (temp.compareTo(heap[j]) <= 0) // �ڽ� ��� ���Һ��� ������ �ݺ��� ����. �� �ڸ��� ������ ��忡 �ִ� ���Ҹ� �����ϸ� �Ǳ� �����̴�.
				break;
			heap[i] = heap[j]; // �ڽ��� ���� �ø���.
			i = j; // �θ�� �ڽ��� ����Ų��.
			j = j * 2; // �ڽ��� �� �� �ڽ��� ����Ų��.
		}
		heap[i] = temp;
		return item;
	}

	public int numberElements() { //������ ��
		return nNode;
	}
}
