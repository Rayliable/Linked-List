package codes;

public class LinkedList {

	private int length;
	private Node first;
	private Node last;
	
	//constructor
	public LinkedList(){
		length = 0;
		first=null;
		last=null;
	}
	
	//Getters & Setters
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}


	//Insert node at end
	public void push(int data){
		Node temp = new Node(data);
		if(first==null)
			first=temp;
		else{
			temp.setPrev(last);
			last.setNext(temp);
		}
		last = temp;
		length++;
	}
	
	//Remove node at end
		public void pop(){
			if(length<1)
				System.out.println("The linked list is empty.");
			else{
				last = last.getPrev();
				if(last==null)
					first=null;
				else
					last.setNext(null);
				length--;
			}
		}
	
	//Display going forwards
	public void display(){
		Node current = first;
		while(current!=null){
			System.out.print(current.getData() +" ");
			current=current.getNext();
		}
	}
	
	//Display going backwards
	public void displayBack(){
		Node current = last;
		while(current!=null){
			System.out.print(current.getData() +" ");
			current=current.getPrev();
		}
	}
	
	//Find number
	public Node find(int target){
		Node current = first;
		while(current!=null){
			if(current.getData()==target)
				return current;
			current=current.getNext();
		}
		return null;
	}
	
	//Swap 2 nodes
	public void swap(int num1, int num2){
		
		//Chow's code:
		Node node1 = find(num1);
		Node node2 = find(num2);
		
		//This part is Ray's
		if(node1==null || node2==null){
			System.out.println("One of those numbers is not in the list!");
			return;
		}//end of Ray's code
		
		boolean inOrder = false;//node1 is left of node2
		Node temp = node1;
		while(temp != null)
		{
			if(temp == node2)
			{
				inOrder = true;
				break;
			}
			temp = temp.getNext();
		}
		if(inOrder == false)
		{
			temp = node1;
			node1 = node2;
			node2 = temp;
		}
		/*//Adjacent & middle-middle
		if(node1.getNext() == node2 && node1 != first && node2 != last)
		{
			//forward direction
			node1.getPrev().setNext( node2 );
			node1.setNext( node2.getNext() );
			node2.setNext( node1 );
			//backwards direction
			node1.getNext().setPrev(node1);
			node2.setPrev( node1.getPrev() );
			node1.setPrev( node2 );
		}*/
		
		//End of Chow's code
		
		if(node1==node2)
			return;
		
		else if(node1.getNext()==node2){
			//Nodes are adjacent
			//System.out.println("Option 1: adjacent");
			
			if(node1.getPrev()!=null)
				node1.getPrev().setNext(node2);
			if(node2.getNext()!=null)
				node2.getNext().setPrev(node1);
			
			node2.setPrev(node1.getPrev());
			node1.setNext(node2.getNext());
			
			node2.setNext(node1);
			node1.setPrev(node2);
			
			if(node1==first)
				first = node2;
			if(node2==last)
				last = node1;
		}
		
		else if(node1==first&&node2==last){
			//Nodes are F and L
			//System.out.println("Option 2: first and last");
			
			node1.setPrev(node2.getPrev());
			node1.getPrev().setNext(node1);
			node2.setNext(node1.getNext());
			node2.getNext().setPrev(node2);
			
			node2.setPrev(null);
			node1.setNext(null);
			
			first = node2;
			last = node1;
		}
		
		else if(node1.getNext()!=node2){
			//Nodes are not adjacent
			//System.out.println("Option 3: not adjacent");
						
			Node n1Next = node1.getNext();
			Node n1Prev = node1.getPrev();
			
			node1.setNext(node2.getNext());
			node1.setPrev(node2.getPrev());
			
			node2.setNext(n1Next);
			node2.setPrev(n1Prev);
			
			if(node1.getNext()!=null)
				node1.getNext().setPrev(node1);
			if(node1.getPrev()!=null)
				node1.getPrev().setNext(node1);
			if(node2.getNext()!=null)
				node2.getNext().setPrev(node2);
			if(node2.getPrev()!=null)
				node2.getPrev().setNext(node2);
			
			if(node1 == first)
				first = node2;
			if(node2 == last)
				last = node1;
		}
		
		
		
	}
	
}
