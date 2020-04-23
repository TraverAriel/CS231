package dataStructures;
import java.util.LinkedList;

/*** A simulation of a HashTable made to demonstrate understanding
 * @author Ariel Traver
 * @version 1.0 
 * ***/
class HashTable {
    /* NOTES
    * Load factor: elements in table / length of table
    *      N = elements, M = length
    *      M should equal N * 1.5
    *Dynamic Resizing
    *     If you don't know N, create new bigger table when necessary
    *     Copy old elements into bigger table
    * Hash Function
    *     Modulo by a large prime: creates a unique remainder
    *     Multiply by int, add int, modulo by several primes: even more unique
    *     Hash functions should limit COLLISIONS (two unique items given the same index)
    *
    * Extraction (Mid square)
    *     Avoid overlarge tables by selecting a few special digits from your resulting number
    *     For example: square a number, then extract the middle three digits
    *
    * Collision Resolution: Chaining
    *     When two elements have same hash index...
    *     Each element of the hash table is a linked list. For example: ("A") or ("A", ("B", ("C)))... etc
    *     Look through the linked list at each index for the element
    *     Slightly less efficient due to need to look through list
    *     Efficiency cost related to the average length of the linked lists, so still very efficient
     */


    private LinkedList<String>[] arr;

    /***Constructor***/
    public HashTable() {
        arr = new LinkedList[1000004];
        for (int i = 0; i < 1000004; i++) {
            arr[i] = new LinkedList<String>();
        }
    }
    
    /***Produces a most-likely unique value for any string
     * @param str: a String***/
    public int hashFunc(String str) {
        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            value += (i + 1) * (int)str.charAt(i);
        }
        value = 3 * value - 1;
        value %= 1000003;
        return value;
    }

    /***Inserts a string into the linked list at the right location in the hash table.***/
    public void insertStr(String str) {
        int index = this.hashFunc(str);
        arr[index].addLast(str);
    }
    
    /***Returns the first item of the linked list at any given index, or null if there are none***/
    public String getFirstStr(int index) {
    		return arr[index].peek();
    }
    
    /***Deletes a String ***/
    public void destroy(String str) {
    		int index = this.hashFunc(str);
    		arr[index].remove(str);
    }
    
    /***Checks if a string is in the hash table***/
    public boolean doesContain(String str) {
    		int index = this.hashFunc(str);
    		return arr[index].contains(str);
    }

    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.insertStr("cat");
        System.out.println(table.hashFunc("cat"));
        System.out.println(table.getFirstStr(1922));
        System.out.println(table.doesContain("cat"));
        table.destroy("cat");
        System.out.println(table.doesContain("cat"));
       
    }

}