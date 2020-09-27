package com.huffomatic.ctci.common.util;

import com.huffomatic.ctci.common.list.Node;

public class LinkedListUtil {
	public static int getLength(Node node) {
		int length = 0;
		Node p = node;
		while (p != null) {
			length++;
			p = p.next;
		}
		return length;
	}
	
	public static void print(Node node) {
		Node p = node;
		StringBuilder sb = new StringBuilder("");
		while (p != null) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(p.data);
			p = p.next;
		}
		System.out.println("sb = [" + sb.toString() + "]");
	}
	
	public static boolean compareLists(Node node1, Node node2) {
		int length1 = getLength(node1);
		int length2 = getLength(node2);
		
		if (length1 != length2) {
			return false;
		}
		
		Node p1 = node1;
		Node p2 = node2;
		
		while (p1 != null && p2 != null) {
			if (p1.data != p2.data) {
				return false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return true;
	}
}
