package util;

import java.util.Iterator;

import tp1.MySimpleLinkedList;

public class UtilList {

	public static <T> MySimpleLinkedList<T> union (MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
		MySimpleLinkedList<T> tmp = new MySimpleLinkedList<T>();
		
		if (!list1.isEmpty() && !list2.isEmpty()) {
			Iterator_Iterable<T> it1 = list1.getIterator();
			Iterator_Iterable<T> it2 = list2.getIterator();
			while (it1.hasNext()) {
				T v1 = it1.next();
				while (it2.hasNext()) {
					T v2 = it2.next();
					if (v1.equals(v2) && !tmp.contains(v1)) {
						//tmp.insertFront(v1);
						tmp.insertInOrden(v1);
					}
				}
				it2 = list2.getIterator();
			}
		}		
		return tmp;		
	}
	
	public static <T> MySimpleLinkedList<T> unionOrderList (MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
		MySimpleLinkedList<T> tmp = new MySimpleLinkedList<T>();
		if (!list1.isEmpty() && !list2.isEmpty()) {
			Iterator_Iterable<T> it1 = list1.getIterator();
			Iterator_Iterable<T> it2 = list2.getIterator();
			while (it1.hasNext() && it2.hasNext()) {	
				if (it1.getValue().longValue() < it1.getValue().longValue()) {
					it1.next();
				}else {
					if (it1.getValue().longValue() > it1.getValue().longValue()) {
						it2.next();
					}else {
						tmp.insertLast((T)it1.getValue());
						it1.next();
						it2.next();
					}
				}
			}
		}
		return tmp;
	}
	
	public static <T> MySimpleLinkedList<T> notInterseption (MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
		MySimpleLinkedList<T> tmp = new MySimpleLinkedList<T>();
		if (!list1.isEmpty() && !list2.isEmpty()) {			;
			for (Iterator_Iterable<T> it1 = list1.getIterator(); it1.hasNext();) {
				T value = (T) it1.next();
				if (!list2.contains(value)) {
					tmp.insertInOrden(value);
				}				
			}
		}
		return tmp;
	}
}
