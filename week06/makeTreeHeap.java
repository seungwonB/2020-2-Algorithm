public void makeTreeHeap() {
		int p, temp;  // p는 포인터변수, temp는 바꿀 값을 저장하는 변수
		//역 레벨 순서로 검사 -> 히프는 최상위 노드가 가장 크기 때문에 큰 값을 위로 올려야함.
		for (int i = (nNode / 2) - 1; i >= 0; i--) {  //마지막 값의 부모부터 시작
			p = i; //포인터 변수는 부모를 가리킴
			//j를 부모노드의 왼쪽 자식으로 설정
			for (int j = (2 * p) + 1; j <= nNode; j = 2 * j + 1) { 
				if (j < nNode)  
					if (heap[j] < heap[j + 1]) //자식들 중 더 큰 값으로 j를 이동
						j = j + 1;
				if (heap[p] >= heap[j]) //부모가 자식보다 크거나 같으면 종료
					break;
				//temp에 부모 값을 저장 한후 부모와 자식을 swap
				temp = heap[p]; 
				heap[p] = heap[j];
				heap[j] = temp;
				p = j; //자식의 자식으로 넘어가기 위해 p를 j로 이동
			}
		}
}