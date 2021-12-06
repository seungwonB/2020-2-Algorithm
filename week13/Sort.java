
public class Sort {
	// �պ� ���� : �迭�� �̵���Ͽ� ������ ������ �� �պ�
	public int[] mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		internalMergeSort(arr, temp, 0, arr.length - 1);

		return arr;
	}

	private void internalMergeSort(int[] arr, int[] temp, int m, int n) {
		if (m < n) { // ������ ���Ұ� 2�� �̻��� ���
			int middle = (m + n) / 2; // m(����)�� n(��)�� �߰�
			internalMergeSort(arr, temp, m, middle); // ������ ���� ���� �κ�
			internalMergeSort(arr, temp, middle + 1, n); // ������ ���� ������ �κ�
			merge(arr, temp, m, middle, middle + 1, n); // ������ �͵��� �ӽù迭�� ����
		}
	}

	private void merge(int[] arr, int[] temp, int m, int p, int q, int n) {
		int t = m; // �ӽ� �迭�� ������
		int numElements = n - m + 1; // ������ ����
		while (m <= p && q <= n) { // p�� ���� �κ��� ������ q�� ������ �κ��� ������
			if (arr[m] < arr[q]) // ���ʺκа� �����ʺκ��� ���Ͽ� ���ʺκ��� �� ������
				temp[t++] = arr[m++]; // �ӽ� �迭�� ���� �� ������ �̵�, ���� ������ ���� ���ҷ� �̵�
			else // ������ �κ��� �� ������
				temp[t++] = arr[q++]; // �ӽ� �迭�� ���� �� ������ �̵�, ������ ������ ���� ���ҷ� �̵�
		}
		while (m <= p) // ���� �κ� �迭�� ���Ұ� �����ִ� ���
			temp[t++] = arr[m++]; // ��� ����
		while (q <= n) // ������ �κ� �迭�� ���Ұ� �����ִ� ���
			temp[t++] = arr[q++]; // ��� ����
		for (int i = 0; i < numElements; i++, n--) // �迭 ����
			arr[n] = temp[n];
	}
	//�� ���� : pivot�� �������� �� ���� �迭�� ���� �� �� �迭�� ���� �ٽ� �� ������ ��ȯ ����
	public int[] quickSort(int[] arr) {
		internalQuickSort(arr, 0, arr.length - 1);
		return arr;
	}

	private void internalQuickSort(int[] arr, int m, int n) {
		if (m >= n)
			return;
		int p = partition(arr, m, n);
		internalQuickSort(arr, m, p - 1); //���ʺκ�
		internalQuickSort(arr, p + 1, n); //�����ʺκ�
	}

	private int partition(int[] arr, int m, int n) {
		int temp;
		int middle = (m + n) / 2; // middle�� arr[]�� �߾� �ε��� ��
		int pivot = arr[middle]; // arr[]�� �߾� ���Ұ��� pivot���� ����
		arr[middle] = arr[m]; // pivot���� 
		arr[m] = pivot; // ù��° ���Ҹ� ��ȯ
		int p = m; // p�� ������

		for (int k = m + 1; k <= n; k++) { // ù��°���Ҵ� �����ϰ� �� �������� ������ ��� ���Ҹ� �˻�
			if (arr[k] < pivot) { // arr[k]�� pivot���� ������
				p = p + 1; // p�� 1�������� a[k]�� p �ε��� ���� ������ �����ϰ���
				//��� ���Ұ� pivot���� �۰� �ǵ��� ��ȯ�ϴ� �۾�
				temp = arr[p];
				arr[p] = arr[k];
				arr[k] = temp;
			}
		}
		//�ݺ��� ������ p�� ���� m�� ���� ��ȯ�Ͽ� �Ǻ� ���� �߽����� 2���� �κй迭 ����
		temp = arr[m]; 
		arr[m] = arr[p];
		arr[p] = temp;
		return p; //�Ǻ����� �ε��� return
	}
}
