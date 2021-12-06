
public class Sort {
	// 합병 정렬 : 배열을 이등분하여 각각을 정렬한 후 합병
	public int[] mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		internalMergeSort(arr, temp, 0, arr.length - 1);

		return arr;
	}

	private void internalMergeSort(int[] arr, int[] temp, int m, int n) {
		if (m < n) { // 정렬할 원소가 2개 이상인 경우
			int middle = (m + n) / 2; // m(시작)과 n(끝)의 중간
			internalMergeSort(arr, temp, m, middle); // 반으로 나눈 왼쪽 부분
			internalMergeSort(arr, temp, middle + 1, n); // 반으로 나눈 오른쪽 부분
			merge(arr, temp, m, middle, middle + 1, n); // 정렬한 것들을 임시배열에 저장
		}
	}

	private void merge(int[] arr, int[] temp, int m, int p, int q, int n) {
		int t = m; // 임시 배열의 포인터
		int numElements = n - m + 1; // 원소의 개수
		while (m <= p && q <= n) { // p는 왼쪽 부분의 포인터 q는 오른쪽 부분의 포인터
			if (arr[m] < arr[q]) // 왼쪽부분과 오른쪽부분을 비교하여 왼쪽부분이 더 작으면
				temp[t++] = arr[m++]; // 임시 배열에 삽입 후 포인터 이동, 왼쪽 포인터 다음 원소로 이동
			else // 오른쪽 부분이 더 작으면
				temp[t++] = arr[q++]; // 임시 배열에 삽입 후 포인터 이동, 오른쪽 포인터 다음 원소로 이동
		}
		while (m <= p) // 왼쪽 부분 배열에 원소가 남아있는 경우
			temp[t++] = arr[m++]; // 모두 삽입
		while (q <= n) // 오른쪽 부분 배열에 원소가 남아있는 경우
			temp[t++] = arr[q++]; // 모두 삽입
		for (int i = 0; i < numElements; i++, n--) // 배열 복사
			arr[n] = temp[n];
	}
	//퀵 정렬 : pivot을 기준으로 두 개의 배열을 나눈 후 각 배열에 대해 다시 퀵 정렬을 순환 적용
	public int[] quickSort(int[] arr) {
		internalQuickSort(arr, 0, arr.length - 1);
		return arr;
	}

	private void internalQuickSort(int[] arr, int m, int n) {
		if (m >= n)
			return;
		int p = partition(arr, m, n);
		internalQuickSort(arr, m, p - 1); //왼쪽부분
		internalQuickSort(arr, p + 1, n); //오른쪽부분
	}

	private int partition(int[] arr, int m, int n) {
		int temp;
		int middle = (m + n) / 2; // middle은 arr[]의 중앙 인덱스 값
		int pivot = arr[middle]; // arr[]의 중앙 원소값을 pivot으로 설정
		arr[middle] = arr[m]; // pivot값과 
		arr[m] = pivot; // 첫번째 원소를 교환
		int p = m; // p는 포인터

		for (int k = m + 1; k <= n; k++) { // 첫번째원소는 제외하고 그 다음부터 끝가지 모든 원소를 검사
			if (arr[k] < pivot) { // arr[k]가 pivot보다 작으면
				p = p + 1; // p를 1증가시켜 a[k]를 p 인덱스 범위 안으로 포함하게함
				//모든 원소가 pivot보다 작게 되도록 교환하는 작업
				temp = arr[p];
				arr[p] = arr[k];
				arr[k] = temp;
			}
		}
		//반복이 끝나면 p의 값과 m의 값을 교환하여 피봇 값을 중심으로 2개의 부분배열 생성
		temp = arr[m]; 
		arr[m] = arr[p];
		arr[p] = temp;
		return p; //피봇값의 인덱스 return
	}
}
