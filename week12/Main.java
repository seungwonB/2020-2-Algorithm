
public class Main {

	public static void main(String[] args) {
		Graph ADV = new Graph(6);
		
		ADV.insertEdge(0, 1);
		ADV.insertEdge(0, 2);
		
		ADV.insertEdge(1, 3);
		ADV.insertEdge(1, 4);
		
		ADV.insertEdge(2, 3);
		ADV.insertEdge(2, 4);
		
		ADV.insertEdge(3, 5);
		
		ADV.insertEdge(4, 5);
		
		ADV.topologicalSort();
	}

}
