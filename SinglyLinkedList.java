public class SinglyLinkedList {
	int length;
	Pair head;
	Pair tail;
	
	public SinglyLinkedList() {
		length = 1;
		head = new Pair(null);
		tail = head;
	}
	public SinglyLinkedList(Comparable val) {
		length = 1;
		head = new Pair(val);
		tail = head;
	}
	public void addToEnd(Pair newPair) {
		if (tail.first == null) {
			tail = newPair;
			head = newPair;
		}
		else tail.next = newPair;
		tail = tail.next;
		length ++;
	}
	public void addToEnd(Comparable val) {
		Pair newPair = new Pair(val);
		if (tail.first == null) tail = newPair;
		else {
			tail.next = newPair;
			tail = tail.next;
		}
		length++;
	}
	public Pair getHead() {
		return head;
	}
	public Pair getTail() {
		return tail;
	}
	public void addToStart(Pair newPair) {
		newPair.next = head;
		head = newPair;
		length++;
	}
	public void addToStart(Comparable val) {
		Pair newPair = new Pair(val);
		newPair.next = head;
		head = newPair;
		length++;
	}
	public void changeHeadValue(Comparable val) {
		head.first = val;
	}
	public void changeTailValue(Comparable val) {
		tail.first = val;
	}
	public String toString() {
		return head.allToString();
	}
	public int getLength() {
		return length;
	}
	public static void main(String[] args) {
		SinglyLinkedList testList = new SinglyLinkedList(2);
		testList.addToStart(3);
		testList.addToStart(4);
		testList.addToEnd(1);
		testList.addToEnd(0);
		System.out.println(testList.toString());
		System.out.println(testList.getLength());
	}

}
