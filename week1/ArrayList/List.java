package ArrayList;

public class List {
	private Object ArrayList[] = new Object[100];
	private int size = 0;

	public void addLast(Object data) {
		ArrayList[size] = data;
		size++;
	}

	public void add(int index, Object data) {
		if (index > size) {
			System.out.println("List보다 큰 인덱스를 입력하여 추가할 수 없습니다.");
			return;
		}
		for (int i = size - 1; i >= index; i--) {
			ArrayList[i + 1] = ArrayList[i];
		}
		ArrayList[index] = data;
		size++;
	}

	public void delete(int index) {
		if (index > size - 1 || index < 0) {
			System.out.println("잘못된 인덱스가 입력되었습니다.");
			return;
		}

		for (int i = index + 1; i < size; i++) {
			ArrayList[i + 1] = ArrayList[i];
		}
		ArrayList[size - 1] = null;
		size--;
	}

	public void showList() {
		int i;
		for (i = 0; i < 20; i++) {
			System.out.print("=");
		}
		System.out.println();
		for (i = 0; i < size; i++) {
			System.out.println("Array List [" + i + "] : " + ArrayList[i]);
		}
		for (i = 0; i < 20; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
}
