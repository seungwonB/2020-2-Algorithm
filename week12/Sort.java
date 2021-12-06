
public class Sort {
	private void swap(int[] a, int j, int k) {// 교환하는 메소드
		int temp = a[j];
		a[j] = a[k];
		a[k] = temp;
	}

	private int[] copy(int[] arr) { // 복사하는 메소드
		int[] copy = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			copy[i] = arr[i];
		}
		return copy;
	}

	// 버블 정렬 : 두 인접한 원소를 비교하여 검사
	public int[] bubbleSort(int[] arr) {
		int[] a = copy(arr);
		int i, j;
		
		for (i = a.length - 1; i > 0; i--) {
			for (j = 0; j < i; j++) {
				/*
				 * 인접한 두 원소를 비교하여 오름차순으로 정리한다. ex)a[0],a[1]비교 a[1],a[2]비교 
				 * 그렇게 되면 마지막 원소는 가장 큰 값으로 정해지고 a[1]까지 반복하여 정하면 a[0]은 자동으로 가장 작은 값이 오게 된다.
				 */
				if (a[j] > a[j + 1]) 
					swap(a, j, j + 1);
			}
		}
		return a;
	}

	// 선택 정렬 : 잘못된 위치에 들어있는 원소를 올바른 위치에 넣는 방식
	public int[] selectionSort(int[] arr) {
		int[] a = copy(arr);
		int i, j, min;

		// 가장 작은 원소를 찾아 첫 번째 위치의 원소와 교환
		// 두번쨰로 작은 원소도 마찬가지
		// 즉, a[i], .... , a[원소의 수-1] 원소 중 가장 작은 원소를 선택하여 a[i] 원소와 계속 교환
		for (i = 0; i < a.length; i++) {
			for (j = i + 1, min = i; j < a.length; j++) {
				if (a[j] < a[min])
					min = j;
			}
			swap(a, min, i);
		}
		return a;
	}

	// 삽입 정렬 : 정렬되어 있지 않은 부분 왼쪽 끝에서 삽입할 원소를 찾아 정렬되어 있는 곳의 적절한 위치에 삽입
	public int[] insertionSort(int[] arr) {
		int[] a = copy(arr);
		int j, k;
		for (int i = 1; i < a.length; i++) {
			k = a[i]; //k에 i번째 원소를 저장
			j = i; //i를 j로 지정

			while (j > 0 && a[j - 1] > k) { //j-1번째 원소가 j번째 원소보다(또한 j가 0보다 클 동안) 크면 계속 반복
				a[j] = a[j - 1]; //j에 그 이전 원소가 더 크기 때문에 그 이전 원소를 저장하고
				j = j - 1; //j는 1감소. 앞의 원소를 계속 검사를 해야되기 때문
			}
			a[j] = k; //j번째 원소에는 k를 저장
		}
		return a;
	}
}
