package com.huffomatic.ctci.chapter2;

import org.junit.Assert;

import com.huffomatic.ctci.common.list.Node;
import com.huffomatic.ctci.common.scenario.Scenario;
import com.huffomatic.ctci.common.util.LinkedListUtil;

public class Question4_LeftStable {
	public static void main(String[] argv) {
		Node result1 = partition(Scenario.scenario5_list1(), 5);
		Assert.assertTrue(LinkedListUtil.compareLists(result1, Scenario.result5()));
	}
	
	public static Node partition(Node head, int x) {
		
		
		return null;
	}
}
