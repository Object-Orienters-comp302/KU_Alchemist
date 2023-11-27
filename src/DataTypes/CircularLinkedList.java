package DataTypes;

public class CircularLinkedList<T> {
	
	private Node selected;
	private Node first;
	
	public CircularLinkedList() {
		selected=null;
		first=null;
	}
	
	public void add(T  value) {
		Node node= new Node(value);
		if(first==null){
			first=node;
			selected=node;
			node.next=node;
			node.prev=node;
			return;
		}
		Node oldPrev= first.prev;
		oldPrev.next=node;
		first.prev=node;
		node.next=first;
		node.prev=oldPrev;
	}
	
	public T get() {
		return selected.value;
	}
	public T getNext() {
		selected=selected.next;
		return selected.value;
	}
	public T getPrev() {
		selected=selected.prev;
		return selected.value;
	}
	
	public T delete() {
		T val;
		if(selected==first) {
			if(first==first.next) {return null;}// TODO: make it throw error if only one item exists and tries to be deleted
			val= first.value;
			first=first.next;
			selected.next.prev=selected.prev;
			selected.prev.next=first;
			selected=first;
			return val;
		}
		
		selected.next.prev=selected.prev;
		selected.prev.next=selected.next;
		val=selected.value;
		selected=selected.next;
		return val;
	}
	
	
	class Node {

	    T value;
	    Node next=null;
	    Node prev=null;

	    public Node(T value) {
	        this.value = value;
	    }
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularLinkedList<Integer> lis= new CircularLinkedList<Integer>();
		lis.add(1);
		lis.add(2);
		lis.add(3);
		lis.add(4);
		lis.getNext();
		lis.delete();
		
		
	}

}
