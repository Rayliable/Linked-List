package codes;

public class Node {
	
	private int data;
	private Node prev;
	private Node next;

	
	//constructor w/ variable
	public Node(int data){
		this.data = data;
		prev=null;
		next=null;
	}
	
	//constructor w/o variable
	public Node(){
		data = 0;
		prev=null;
		next=null;
	}

	//Getters and Setters
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
