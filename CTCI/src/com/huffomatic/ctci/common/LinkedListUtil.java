package com.huffomatic.ctci.common;

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
}
