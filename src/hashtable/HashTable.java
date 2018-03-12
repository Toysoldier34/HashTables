/**
* Tony Thompson
* Mar 11, 2018
* HashTable.java
* 
*/
package hashtable;

import java.util.ArrayList;
import java.util.Iterator;

import structures.ICollection;

public class HashTable<T> implements ICollection<T> {
	
	//field
	private int size;  //current size of main hash table
	private int tableMax;  //max size of main hash table
	private ArrayList<Node> tableArray;  //main array for table
	
	
	//private inner class
	private class Node {
		T data;
		Node next;
		
		public Node(T element) {
			this.data = element;
			this.next = null;
		}//end constructor
	}//end class Node

	/**
	 * constructor of HashTable
	 * @param size
	 * @param tableMax
	 */
	public HashTable() {
		super();
		this.size = 0;
		this.tableMax = 100;
		this.tableArray = new ArrayList<>();
	}//end constructor

	/**
	 *
	 * Adds an element to the collection. No specific ordering
	 * is
	 * required.
	 *  
	 * @param element the new element to put in the collection
	 */
	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Finds and removes an element from the collection.
	 * 
	 * @throws java.util.NoSuchElementException thrown when the
	 * element is not found in the collection
	 * @param element the element to remove
	 */
	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Reports whether the collection contains an element.
	 *
	 * @param element the element to search for.
	 * @return true if the element is found, otherwise false
	 */
	@Override
	public boolean contains(T element) {
		if (get(element) != null) return true;
		return false;
	}

	/**
	 * Returns the number of elements in the collection.
	 * 
	 * @return the number of elements
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Reports whether the collection is empty or not.
	 * 
	 * @return true if the collection is empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Removes all elements from the collection.
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Returns an element in the collection that matches the
	 * input parameter according the equals() method of the
	 * parameter.
	 * 
	 * @param element an element to search for
	 * @return a matching element
	 */
	@Override
	public T get(T element) {
		int index = findChain(element);		
		Node head = tableArray.get(index);
		Node current = head;
		
		while (current != null) {
			if (current.data.equals(element)) {
				return current.data;
			} else {
				current = current.next;
			}
		}		
		return null;
	}
	
	/**
	 * runs hashCode on object and returns appropriate
	 * index position of the chain object would belong to
	 * @param T element  to find hash chain of
	 * @return int index of chain
	 */
	private int findChain(T element) {
		return ((element.hashCode()) % tableMax);
	}

	/**
	 * Returns an iterator over the collection.
	 * 
	 * @return an object using the Iterator<T> interface
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
