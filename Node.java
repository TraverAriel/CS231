package dataStructures;

import java.util.LinkedList;
import java.util.List;

/**A node of a binary search tree.
 * @author Ariel Traver
 * @version 1.0**/
public class Node {
	private int key;
	private Object val;
	private Node leftNode;
	private Node rightNode;
	
	public Node(int key, Object val) {
		this.key = key;
		this.val = val;
	}
	
	/***Inserts an object with a given key into the right location
	 * @param newKey: the key of the item you want to insert
	 * @param thing: the item you want to insert***/
	public void insert(int newKey, Object thing) {
		Node insertedNode = new Node(newKey, thing);
		if (newKey == this.key) this.val = thing;
		else if (newKey < this.key && this.leftNode == null) {
			this.leftNode = insertedNode;
		}
		else if (newKey > this.key && this.rightNode == null) {
			this.rightNode = insertedNode;
		}
		else if (newKey < this.key) {
			leftNode.insert(newKey, thing);
		}
		else if (newKey > this.key) {
			rightNode.insert(newKey, thing);
		}
	}
	
	/***Returns a LinkedList containing all the elements of the tree. Left, then right.***/
	public LinkedList<Object> transverse() {
		LinkedList<Object> ls = new LinkedList<Object>();
		if (this.leftNode != null) {
			ls.addAll(leftNode.transverse());
		}
		ls.add(this.val);
		if (this.rightNode != null) {
			ls.addAll(rightNode.transverse());
		}
		return ls;
	}
	
	public LinkedList<Integer> transverseKey() {
		LinkedList<Integer> ls = new LinkedList<Integer>();
		if (this.leftNode != null) {
			ls.addAll(leftNode.transverseKey());
		}
		ls.add(this.key);
		if (this.rightNode != null) {
			ls.addAll(rightNode.transverseKey());
		}
		return ls;
	}
	
	public Object lookUp(int lookUpKey) {
		if (lookUpKey == this.key) {
			return this.val;
		}
		else if (lookUpKey < this.key) {
			return leftNode.lookUp(lookUpKey);
		}
		else if (lookUpKey > this.key) {
			return rightNode.lookUp(lookUpKey);
		}
		return null;
	}
	
	public int maxKey() {
		return this.transverseKey().getLast();
	}
	public Object maxVal() {
		return this.transverse().getLast();
	}
	
	public void deleteKey(int badKey) {
		if (leftNode != null && leftNode.getKey() == badKey) {
			if (leftNode.getLeftNode() == null && leftNode.getRightNode() == null) {
				this.leftNode = null; }
			else if (leftNode.getLeftNode() != null && leftNode.getRightNode() == null) {
				this.leftNode = leftNode.getLeftNode(); }
			else if (leftNode.getRightNode() != null && leftNode.getLeftNode() == null) {
				this.leftNode = leftNode.getLeftNode();}
			else if (leftNode.getLeftNode() != null && leftNode.getRightNode() != null) {
				LinkedList<Integer> ls = leftNode.getLeftNode().transverseKey();
				int index = ls.pollLast();
				Node replacement = new Node(index, this.lookUp(index));
				for (int k : ls) {
					replacement.insert(k, this.lookUp(k));
				}
				for (int i : leftNode.getRightNode().transverseKey()) {
					replacement.insert(i, this.lookUp(i));
				}
				this.leftNode = replacement;
			}
		}
		else if (rightNode != null && rightNode.getKey() == badKey) {
			if (rightNode.getRightNode() == null && rightNode.getLeftNode() == null) {
				this.rightNode = null; }
			else if (rightNode.getRightNode() != null && rightNode.getLeftNode() == null) {
			this.rightNode = rightNode.getRightNode(); }
			else if (rightNode.getLeftNode() != null && rightNode.getRightNode() == null) {
				this.rightNode = rightNode.getLeftNode();}
			else if (rightNode.getLeftNode() != null && rightNode.getRightNode() != null) {
				LinkedList<Integer> ls = rightNode.getLeftNode().transverseKey();
				int index = ls.pollLast();
				Node replacement = new Node(index, this.lookUp(index));
				for (int k : ls) {
					replacement.insert(k, this.lookUp(k));
				}
				for (int i : rightNode.getRightNode().transverseKey()) {
					replacement.insert(i, this.lookUp(i));
				}
				this.rightNode = replacement;
			}
		}
		else if (badKey > key) {
			this.rightNode.deleteKey(badKey);
		}
		else if (badKey < key) {
			this.leftNode.deleteKey(badKey);
		}
	}
	public Object getVal() {
		return this.val;
	}
	public int getKey() {
		return this.key;
	}
	public Node getLeftNode() {
		return this.leftNode;
	}
	public Node getRightNode() {
		return this.rightNode;
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(11, 'B');
		root.insert(22, 'D');
		root.insert(10, 'A');
		root.insert(23, 'E');
		root.insert(20, 'C');
		System.out.println(root.transverse().toString());
		System.out.println(root.lookUp(10));
		System.out.println(root.maxVal());
		root.deleteKey(20);
		System.out.println(root.transverse());
	}
}
