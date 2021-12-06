
public class main {

	public static void main(String[] args) {
		WGraph graph = new WGraph(6);

		graph.insertEdge(0, 1, 6);
		graph.insertEdge(0, 2, 5);
		graph.insertEdge(0, 3, 5);

		graph.insertEdge(1, 4, -1);

		graph.insertEdge(2, 1, -2);
		graph.insertEdge(2, 4, 1);

		graph.insertEdge(3, 2, -3);
		graph.insertEdge(3, 5, -1);

		graph.insertEdge(4, 5, 3);

		graph.print();

		graph.BellmanFord(0);

		System.out.println("===================\n\n");
		graph = new WGraph(4);
		graph.insertEdge(0, 1, 2);
		graph.insertEdge(0, 2, 9);
		graph.insertEdge(1, 2, 4);
		graph.insertEdge(1, 3, 3);
		graph.insertEdge(2, 0, -1);
		graph.insertEdge(2, 3, 4);
		graph.insertEdge(3, 1, 1);
		graph.insertEdge(3, 2, 7);

		graph.print();
		graph.allShortestPath();

	}

}
