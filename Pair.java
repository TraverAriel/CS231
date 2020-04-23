package unit1;
import java.util.*;

public class Pair{
	Comparable first;
	Pair next;
	
	public Pair(Comparable value) {
		first = value;
		next = null;
	}
	public Pair(Comparable value, Pair p) {
		first = value;
		next = p;
	}
	public void setNext(Pair p) {
		next = p;
	}
	public void setNext(Comparable val){
		next = new Pair(val);
	}
	public void setFirst(Comparable val) {
		first = val;
	}
	public Pair getNext() {
		return next;
	}
	public Comparable getFirst() {
		return first;
	}
	public int compareTo(Pair p) {
		return first.compareTo(p.getFirst());
	}
	public int compareTo(Comparable c) {
		return first.compareTo(c);
	}
	public String toString() {
		if(first == null) return null;
		else return first.toString();
	}
	public String allToString() {
		if (next == null && first != null) return first.toString();
		else if (first == null) return "";
		else return first.toString() + " " + next.allToString();
	}
	public static void main(String[] args) {
		Pair testPair = new Pair(1);
		System.out.println(testPair.toString());
		testPair.setFirst(2);
		System.out.println(testPair.toString());
		testPair.setNext(new Pair(3));
		System.out.println(testPair.allToString());
	}

}
