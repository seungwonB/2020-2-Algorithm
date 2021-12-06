
public class sortMain {

	public static void main(String[] args) {
		Sort s = new Sort();

		int[] a2 = { 8, 1, 23, 15, 31, 2, 26, 12 };

		int[] merge = s.mergeSort(a2);

		System.out.print("Merge sort : ");
		for (int i = 0; i < merge.length; i++) {
			System.out.print(merge[i] + " ");
		}
		System.out.println();

		int[] a3 = { 3, 1, 5, 4, 9, 7, 8 };
		int[] quick = s.quickSort(a3);

		System.out.print("Quick sort : ");
		for (int i = 0; i < quick.length; i++) {
			System.out.print(quick[i] + " ");
		}
		System.out.println();
	}

}
