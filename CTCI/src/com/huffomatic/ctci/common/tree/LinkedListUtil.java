package com.huffomatic.ctci.common.tree;

import java.util.LinkedList;

import com.huffomatic.ctci.common.tree.Node;

public class LinkedListUtil {
	public static boolean compareListOfLists(LinkedList<LinkedList<Node>> list1, LinkedList<LinkedList<Node>> list2) {
		if (list1.size() != list2.size()) {
			return false;
		}
		
		for (int index = 0; index < list1.size(); index++) {
			if (!compareLists(list1.get(index), list2.get(index))) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean compareLists(LinkedList<Node> list1, LinkedList<Node> list2) {
		if (list1.size() != list2.size()) {
			return false;
		}
		
		for (int index = 0; index < list1.size(); index++) {
			if (!list1.get(index).name.equals(list2.get(index).name)) {
				return false;
			}
		}
		
		return true;
	}
}
