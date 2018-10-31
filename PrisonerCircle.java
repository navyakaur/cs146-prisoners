package sjsu.kaur.cs146.project1;

//this class is finding which winner will go free using circular LL
public class PrisonerCircle {
	
	private Node head;
	private Node tail;
	private int size;
	
	//ctor
	public PrisonerCircle() {
		head = new Node();
		tail = new Node();
		size = 0;
	}
	
	//returns size of LL
	public int size() {
		return size;
	}
	
	//finds the winner using circular LL
	//uses recursion
	public Node findWinner(Node y, int k) {
		if (size == 1) {
			return y; //y is winner
		}

		Node checker = y; //shows where to start from
		int num = 0;
		while (num != k-1) {
			checker = checker.next;
			num++;
		}
		
		Node link = checker.next.next;
		checker.next = link;
		size--;
		return findWinner(link, k); //recursion
	}
	
	//returns head
	public Node getFirst() {
		return head;
	}
	
	//checks if list is empty
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	
	//inserts a node into the LL
	public void insert(Node x) {
		if (!isEmpty()) { //first checks if it's empty to ensure if it needs to update head/tail
			tail.next = x;
			x.next = head;
			tail = tail.next;
		}
		else { //if list is empty, update head/tail to new node
			head = x;
			tail = x;
			head.next = tail;
		}
		size++; //increase size of LL
	}
}
