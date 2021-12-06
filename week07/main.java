
public class main {

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(1, 2);
		graph.add(1, 3);
		graph.add(2, 3);
		graph.add(3, 4);

		System.out.println("Graph");
		graph.show();
		
		System.out.println("0-1 / 1-3 delete");
		graph.delete(0, 1);
		graph.delete(1, 3);
		graph.show();
	}

}
