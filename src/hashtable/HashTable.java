/**
* Tony Thompson
* Mar 11, 2018
* HashTable.java
* 
*/
package hashtable;

import java.util.Iterator;

import structures.ICollection;

public class HashTable<T> implements ICollection<T> {
	
	//field
	private int size;  //current size of main hash table
	private int tableMax;  //max size of main hash table
	
	

	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(T element) {
		if (get(element) != null) return true;
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(T element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//runs hashCode on object and returns appropriate
	//index position of the chain object would belong to
	private int findChain(T element) {
		return ((element.hashCode()) % tableMax);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
