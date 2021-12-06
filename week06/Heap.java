
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
			heapFull(); //�迭�� �ϳ� �÷��ش�.
		int i;
		for (i = nNode;;) {
			if (i == 0) //ó�� �����ϴ� ���
				break; 
			if (item < heap[(i - 1) / 2]) //������ ����� Ű ���� �θ� ��� Ű ������ ���� ���
				break;
			heap[i] = heap[(i - 1) / 2]; //�� �ݴ��� ���� �ִ� ������ ������ �������� �����Ƿ� �ڸ��� �ٲ�����Ѵ�. 
			i = (i - 1) / 2; //i�� �θ���� �����Ǹ� �ٽ� �ݺ����� ���� ���� ���Ѵ�.
		}
		heap[i] = item; //i��° �迭�� ���� �־��ش�.
		nNode++; //���� ÷���� ��尡 �����Ƿ� �迭�� ���������ش�.
	}

	public int delete() {
		if (nNode == 0) {
			System.out.println("������ ��尡�����ϴ�.");
			return -1;
		}
		int item = heap[0]; //������ �ֻ��� ����
		int temp = heap[nNode - 1];//�̵���ų ����(�� ������ ��忡 �ִ� ���ҷ� ������ ���� �����Ǳ� ������ �ӽ÷� �����صд�)
		nNode--; //���� ũ�⸦ �ϳ� ���ҽ�Ų��.
		int i = 0; //�θ� ���
		int j = 1; //�ڽ� ���
		while (j <= nNode) {
			if (j < nNode) {
				if (heap[j] < heap[j + 1]) //������ �� �ڽ� ��� �߿��� ū ���� ���� ���Ͽ� 
					j = j + 1; //j�� ū ���Ҹ� ����Ų��. 
			}
			if (temp > heap[j]) //�ڽ� ��� ���Һ��� ũ�� �ݺ��� ����. �� �ڸ��� ������ ��忡 �ִ� ���Ҹ� �����ϸ� �Ǳ� �����̴�.
				break;
			heap[i] = heap[j]; //�ڽ��� ���� �ø���.
			i = j; //�θ�� �ڽ��� ����Ų��.
			j = (j * 2) + 1; //�ڽ��� �� �ڽ��� ����Ų��.
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
