/**
* Tony Thompson
* Mar 11, 2018
* HashTable.java
* 
*/
package hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import structures.ICollection;

/**
 * Hash Table data collection able to add and remove elements
 * with an iterator and other functions to check the collection
 * 
 * @author Tony Thompson
 *
 * @param <T>
 */
public class HashTable<T> implements ICollection<T> {

	// field
	private int size; // current size of main hash table
	private int tableMax; // max size of main hash table
	public ArrayList<Node> tableArray; // main array for table
	private final int MAXTABLESIZE = 3;
	private int modCount;

	// private inner class for Nodes
	private class Node {
		T data;
		Node next;

		public Node(T element) {
			this.data = element;
			this.next = null;
		}// end constructor
	}// end class Node


	/**
	 * constructor of HashTable
	 * 
	 * @param size
	 * @param tableMax
	 */
	public HashTable() {
		super();
		this.size = 0;
		this.tableMax = MAXTABLESIZE;
		this.modCount = 0;
		this.tableArray = new ArrayList<>();
		for (int i = 0; i < tableMax; i++) {
			tableArray.add(null);
		}
	}// end constructor


	/**
	 *
	 * Adds an element to the collection. No specific ordering is required.
	 * 
	 * @param element
	 *            the new element to put in the collection
	 */
	@Override
	public void add(T element) {
		modCount++;
		int index = findChain(element);
		Node head = tableArray.get(index);
		if (head == null) {
			head = new Node(element);
			tableArray.set(index, head);
			size++;
			return;
		}

		Node current = head;
		while (current != null) {
			if (current.data.equals(element)) {
				current.data = element;
				break;
			}
			if (current.next == null) {
				current.next = new Node(element);
				size++;
				break;
			} else {
				current = current.next;
			}
		} // end while
	}// end add


	/**
	 * Finds and removes an element from the collection.
	 * 
	 * @throws java.util.NoSuchElementException
	 *             thrown when the element is not found in the collection
	 * @param element
	 *            the element to remove
	 */
	@Override
	public void remove(T element) {
		modCount++;
		int index = findChain(element);
		Node head = tableArray.get(index);
		Node current = head;
		Node prev = null;

		if (contains(element)) {
			while (current != null) {
				if (current.data.equals(element)) {
					if (prev != null) {
						prev.next = current.next; // check later
					} else {
						tableArray.set(index, current.next);
					}
					current = current.next;
					size--;
					return;
				} else {
					prev = current;
					current = current.next;
				}
			} // end while
		} else {
			throw new NoSuchElementException();
		}//end if else
	}// end remove


	/**
	 * Reports whether the collection contains an element.
	 *
	 * @param element
	 *            the element to search for.
	 * @return true if the element is found, otherwise false
	 */
	@Override
	public boolean contains(T element) {
		if (get(element) != null)
			return true;
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
	}// end size


	/**
	 * Reports whether the collection is empty or not.
	 * 
	 * @return true if the collection is empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}// end isEmpty


	/**
	 * Removes all elements from the collection.
	 */
	@Override
	public void clear() {
		modCount = 0;
		for (int i = 0; i < tableMax; i++) {
			tableArray.set(i, null);
		}
		size = 0;
	}// end clear


	/**
	 * Returns an element in the collection that matches the input parameter
	 * according the equals() method of the parameter.
	 * 
	 * @param element
	 *            an element to search for
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
	}// end get


	/**
	 * runs hashCode() on object and returns appropriate index position of the chain
	 * object would belong to
	 * 
	 * @param T
	 *            element to find hash chain of
	 * @return int index of chain
	 */
	private int findChain(T element) {
		return ((element.hashCode()) % tableMax);
	}// end findChain


	/**
	 * Returns an iterator over the collection.
	 * 
	 * @return an object using the Iterator<T> interface
	 */
	@Override
	public Iterator<T> iterator() {
		if (tableArray.isEmpty()) {
			return Collections.emptyIterator();
		} else {
			return new HashTableIterator();
		}
	}// end Iterator

	// iterator class override
	private class HashTableIterator implements Iterator<T> {

		protected int expectedModCount = modCount; // TODO
		ArrayList<Node> table = tableArray;
		int index = 0;
		Node current = null;
		@SuppressWarnings("unused")
		Node lastReturned = null;


		@Override
		public boolean hasNext() {
			if (expectedModCount != modCount) {
				throw new ConcurrentModificationException();
			}

			Node tempNode = current;
			int i = index;
			ArrayList<Node> tempTable = table;
			while (tempNode == null && i < tableMax) {
				tempNode =  tempTable.get(i);
				i++;
			}
			current = tempNode;
			index = i;
			return tempNode != null;
		}// end hasNext


		@Override
		public T next() {
			if (expectedModCount != modCount) {
				throw new ConcurrentModificationException();
			}

			Node tempCurrent = current;
			int i = index;
			ArrayList<Node> tempTable = table;

			while (tempCurrent == null && i < tableMax) {
				tempCurrent = tempTable.get(i);
				i++;
			}
			current = tempCurrent;
			index = i;
			if (tempCurrent != null) {
				Node tempNode = lastReturned = current;
				current = tempNode.next;
				return tempNode.data;
			}
			throw new NoSuchElementException();
		}// end next
	}// end class HashTableIterator

}// end class HashTable
