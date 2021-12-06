
public class main {

	public static void main(String[] args) {
		HeapSort s = new HeapSort();
		int[] a4 = { 0, 20, 40, 50, 70, 30, 100, 80, 10, 90, 60 };

		int[] heap = s.heapSort(a4);
		System.out.println(("Heap Sort : "));

		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}

}
