
public class Edge {
	private int start, end, weight;

	public Edge(int start, int end, int weight) {
		this.start = start; //시작점
		this.end = end; //끝점
		this.weight = weight; //가중치
	}

	public int compareTo(Edge value) {
		return this.weight - value.weight; //가중치가 적은 것 리턴
	}
	//getter, setter 함수
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
