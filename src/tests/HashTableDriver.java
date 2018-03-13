/**
* Tony Thompson
* Mar 12, 2018
* HashTableDriver.java
* 
*/
package tests;

import hashtable.HashTable;

public class HashTableDriver {

	public static void main(String[] args) {

		HashTable ht = new HashTable();
		
		String t1 = "Test1";
		String t2 = "Test2";
		String t3 = "Test3";
		String t4 = "Test4";
		String t5 = "Test5";
		
		
		System.out.println("size:" + ht.size());
		
		ht.add(t1);
		System.out.println(ht.findChain(t1));
		System.out.println("add:" + "Test1 " + t1.hashCode());
		System.out.println("size:" + ht.size());
		
		ht.add(t2);
		System.out.println("add:" + "Test2 " + t2.hashCode());

		System.out.println("size:" + ht.size());
		
		ht.add(t1);
		System.out.println("add:" + "Test1 " + t1.hashCode());

		System.out.println("size:" + ht.size());

		System.out.println();
	}

}