
public class HeapSort {
	public HeapSort() {

	}

	public int[] heapSort(int[] arr) {
		int n = arr.length - 1; //전체 길이 - 1 (0번째 배열은 사용하지 않음)
		int i;
		for (i = n / 2; i >= 1; i--) {
			heapify(arr, i, n); //배열들을 모두 최대힙으로 정렬
		}
		for (i = n - 1; i >= 1; i--) { //n-1부터 1까지 반복을 하게 되면 마지막 부분에는 영향을 끼치지 않기 떄문에 항상 n-1에는 남은 원소들 중 가장 큰 값들이 저장된다.
			int temp = arr[1]; //첫번재 원소를 temp에 저장
			arr[1] = arr[i + 1]; //첫번째 원소와 
			arr[i + 1] = temp; //마지막 원소를 교환
			// -> 이렇게 되면 마지막 원소에는 제일 큰 값이 놓이게 된다.
			heapify(arr, 1, i);  //다시 최대힙 메소드 실행
		}
		return arr;
	}
	//최대힙 메소드(부모노드는 자식노드보다 무조건 큰 값을 가져야 한다.)
	private void heapify(int[] arr, int h, int m) {
		int ah = arr[h]; //ah에 h번째 원소 저장(h는 n/2 부터 1까지 1씩 감소되는 값이다.)
		int j;
		for (j = 2 * h; j <= m; j *= 2) { 
			if (j < m) { //j가 노드의 개수보다 작을 때
				if (arr[j] < arr[j + 1]) //두 자식 중 더 큰 값을
					j++; //j가 가리킴
			}
			if (ah >= arr[j]) //ah의 값이 j가 가리키는 값보다 크면
				break; //반복문 종료
			else
				arr[j / 2] = arr[j]; //부모의 값과 자식의 값을
		}
		arr[j / 2] = ah; //교환한다.
	}
}
