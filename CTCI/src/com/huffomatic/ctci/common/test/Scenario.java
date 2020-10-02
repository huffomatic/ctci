package com.huffomatic.ctci.common.test;

import com.huffomatic.ctci.common.list.Node;

public class Scenario {
	public static Node scenario1_list1() {
		Node n1 = new Node(7);
		Node n2 = new Node(1);
		Node n3 = new Node(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		return n1;
	}
	
	public static Node scenario1_list2() {
		Node n4 = new Node(5);
		Node n5 = new Node(9);
		Node n6 = new Node(2);
		
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		return n4;
	}
	
	public static Node scenario2_list1() {
		Node n1 = new Node(7);
		Node n2 = new Node(1);
		Node n3 = new Node(6);
		Node n4 = new Node(9);
		Node n5 = new Node(9);
		Node n6 = new Node(9);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		return n1;
	}
	
	public static Node scenario2_list2() {
		Node n1 = new Node(5);
		Node n2 = new Node(9);
		Node n3 = new Node(9);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		return n1;
	}
	
	public static Node scenario3_list1() {
		Node n1 = new Node(6);
		Node n2 = new Node(1);
		Node n3 = new Node(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		return n1;
	}
	
	public static Node scenario3_list2() {
		Node n4 = new Node(2);
		Node n5 = new Node(9);
		Node n6 = new Node(5);
		
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		return n4;
	}
	
	public static Node scenario4_list1() {
		Node n1 = new Node(9);
		Node n2 = new Node(9);
		Node n3 = new Node(9);
		Node n4 = new Node(6);
		Node n5 = new Node(1);
		Node n6 = new Node(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		return n1;
	}
	
	public static Node scenario4_list2() {
		Node n1 = new Node(9);
		Node n2 = new Node(9);
		Node n3 = new Node(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		
		return n1;
	}
	
	public static Node scenario5_list1() {
		Node n1 = new Node(3);
		Node n2 = new Node(5);
		Node n3 = new Node(8);
		Node n4 = new Node(5);
		Node n5 = new Node(10);
		Node n6 = new Node(2);
		Node n7 = new Node(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;
		
		return n1;
	}
	
	public static Node scenario6_list1() {
		Node n1 = new Node(3);
		
		n1.next = null;
		
		return n1;
	}
	
	public static Node scenario7_list1() {
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(1);
		Node n5 = new Node(0);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		return n1;
	}
	
	public static Node scenario7_list2() {
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(2);
		Node n5 = new Node(1);
		Node n6 = new Node(0);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		
		return n1;
	}
	
	public static Node scenario7_list3() {
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(1);
		Node n5 = new Node(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		return n1;
	}
	
	public static Node scenario7_list4() {
		Node n1 = new Node(1);
		Node n2 = new Node(1);
		
		n1.next = n2;
		n2.next = null;
		
		return n1;
	}
	
	public static Node scenario7_list5() {
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		
		n1.next = n2;
		n2.next = null;
		
		return n1;
	}
}
