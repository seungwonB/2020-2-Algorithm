
public class Sort {
	private void swap(int[] a, int j, int k) {// ��ȯ�ϴ� �޼ҵ�
		int temp = a[j];
		a[j] = a[k];
		a[k] = temp;
	}

	private int[] copy(int[] arr) { // �����ϴ� �޼ҵ�
		int[] copy = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
		return copy;
	}

	// ���� ���� : �� ������ ���Ҹ� ���Ͽ� �˻�
	public int[] bubbleSort(int[] arr) {
		int[] a = copy(arr);
		int i, j;
		
		for (i = a.length - 1; i > 0; i--) {
			for (j = 0; j < i; j++) {
				/*
				 * ������ �� ���Ҹ� ���Ͽ� ������������ �����Ѵ�. ex)a[0],a[1]�� a[1],a[2]�� 
				 * �׷��� �Ǹ� ������ ���Ҵ� ���� ū ������ �������� a[1]���� �ݺ��Ͽ� ���ϸ� a[0]�� �ڵ����� ���� ���� ���� ���� �ȴ�.
				 */
				if (a[j] > a[j + 1]) 
					swap(a, j, j + 1);
			}
		}
		return a;
	}

	// ���� ���� : �߸��� ��ġ�� ����ִ� ���Ҹ� �ùٸ� ��ġ�� �ִ� ���
	public int[] selectionSort(int[] arr) {
		int[] a = copy(arr);
		int i, j, min;

		// ���� ���� ���Ҹ� ã�� ù ��° ��ġ�� ���ҿ� ��ȯ
		// �ι����� ���� ���ҵ� ��������
		// ��, a[i], .... , a[������ ��-1] ���� �� ���� ���� ���Ҹ� �����Ͽ� a[i] ���ҿ� ��� ��ȯ
		for (i = 0; i < a.length; i++) {
			for (j = i + 1, min = i; j < a.length; j++) {
				if (a[j] < a[min])
					min = j;
			}
			swap(a, min, i);
		}
		return a;
	}

	// ���� ���� : ���ĵǾ� ���� ���� �κ� ���� ������ ������ ���Ҹ� ã�� ���ĵǾ� �ִ� ���� ������ ��ġ�� ����
	public int[] insertionSort(int[] arr) {
		int[] a = copy(arr);
		int j, k;
		for (int i = 1; i < a.length; i++) {
			k = a[i]; //k�� i��° ���Ҹ� ����
			j = i; //i�� j�� ����

			while (j > 0 && a[j - 1] > k) { //j-1��° ���Ұ� j��° ���Һ���(���� j�� 0���� Ŭ ����) ũ�� ��� �ݺ�
				a[j] = a[j - 1]; //j�� �� ���� ���Ұ� �� ũ�� ������ �� ���� ���Ҹ� �����ϰ�
				j = j - 1; //j�� 1����. ���� ���Ҹ� ��� �˻縦 �ؾߵǱ� ����
			}
			a[j] = k; //j��° ���ҿ��� k�� ����
		}
		return a;
	}
}
