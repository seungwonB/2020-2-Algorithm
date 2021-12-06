package LinkedList;

public class ListNode {
	private Object data;
	private ListNode link;

	public ListNode() {
		this.data = null;
		this.link = null;
	}

	public ListNode(Object data) {
		this.data = data;
		this.link = null;
	}

	public ListNode(Object data, ListNode link) {
		this.data = data;
		this.link = link;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ListNode getLink() {
		return this.link;
	}

	public void setLink(ListNode link) {
		this.link = link;
	}
	
	
}
