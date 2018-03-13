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
		
		
		ht.add(t5);
		System.out.println("contains t5 " + ht.contains(t5));
		ht.remove(t5);
		System.out.println("contains t5 " + ht.contains(t5));
		ht.add(t5);
		System.out.println("contains t5 " + ht.contains(t5));
		
		
		ht.add(t1);
		//System.out.println(ht.findChain(t1));
		System.out.println("add:" + "Test1 " + t1.hashCode());
		System.out.println("size:" + ht.size());
		System.out.println();

		
		ht.add(t2);
		System.out.println("add:" + "Test2 " + t2.hashCode());
		System.out.println("size:" + ht.size());
		System.out.println();
		
		ht.add(t1);
		System.out.println("add:" + "Test1 " + t1.hashCode());
		System.out.println("size:" + ht.size());
		System.out.println();


		ht.add(t3);
		System.out.println("add:" + "Test3 " + t3.hashCode());
		System.out.println("size:" + ht.size());
		System.out.println();


		ht.add(t4);
		System.out.println("add:" + "Test4 " + t4.hashCode());
		System.out.println("size:" + ht.size());
		System.out.println("***************");
		
		System.out.println("contains t1 " + ht.contains(t1));
		System.out.println("contains t5 " + ht.contains(t5));

		
		System.out.println("get t1 " + ht.get(t1));

		ht.remove(t1);
		System.out.println("remove:" + "Test1 " + t1.hashCode());
		System.out.println("size:" + ht.size());
		System.out.println();
		
		//ht.remove(t1);
		System.out.println("contains t1 " + ht.contains(t1));
		System.out.println("get t1 " + ht.get(t1));
		System.out.println();

		
		
		ht.add(t1);
		System.out.println("add:" + "Test1 " + t1.hashCode());
		System.out.println("contains t1 " + ht.contains(t1));

		System.out.println("size:" + ht.size());
		System.out.println();
		
		
		ht.add(t1);
		ht.add(t2);
		ht.add(t3);
		ht.add(t4);
		ht.add(t5);
		
//		System.out.println("get t1 " + ht.get(t1) + ht.findChain(t1));
//		System.out.println("get t2 " + ht.get(t2) + ht.findChain(t2));
//		System.out.println("get t3 " + ht.get(t3) + ht.findChain(t3));
//		System.out.println("get t4 " + ht.get(t4) + ht.findChain(t4));
//		System.out.println("get t5 " + ht.get(t5) + ht.findChain(t5));

		
		
		for (Object element : ht) {
			System.out.println("iter: " + element);
		}
		
		
		ht.clear();
		System.out.println("size:" + ht.size());
		
		
		
	}
	
	
}











