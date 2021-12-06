
public class SortMain {

	public static void main(String[] args) {
		int[] a = {5,2,8,3,1};
		Sort s = new Sort();
		int i;
		System.out.println("정렬 전 배열 원소");
		
		for(i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("========================");
		
		int[] b = s.selectionSort(a);
		
		System.out.println("선택정렬 원소");
		
		for(i=0;i<b.length;i++) {
			System.out.print(b[i]+" ");
		}
		System.out.println();
		System.out.println("========================");
		
		int[] c = s.bubbleSort(a);
		
		System.out.println("버블정렬 원소");
		
		for(i=0;i<c.length;i++) {
			System.out.print(c[i]+" ");
		}
		System.out.println();
		System.out.println("========================");
		
		int[] d = s.insertionSort(a);
		
		System.out.println("삽입정렬 원소");
		
		for(i=0;i<d.length;i++) {
			System.out.print(d[i]+" ");
		}
		System.out.println();
		System.out.println("========================");
	}

}
