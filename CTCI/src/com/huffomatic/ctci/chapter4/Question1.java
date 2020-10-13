package com.huffomatic.ctci.chapter4;

import java.util.LinkedList;

import org.junit.Assert;

import com.huffomatic.ctci.common.graph.Node;
import com.huffomatic.ctci.common.graph.State;

/**
 * Route between nodes: Determine if there is a path between nodes s and e in a directed graph.
 * 
 * Time:  O(n) where n is the number of nodes.
 * Space: O(n) where n is the number of nodes.
 * 
 * @author huffomatic
 *
 */
public class Question1 {
	public static void main(String[] args) throws Exception {
		// a -> [b]
		// b -> [c, d]
		// c -> [d, e]
		// d -> [e, f]
		// e -> [b]
		// f -> [g]
		// g -> [h]
		// h -> [f]
		
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node h = new Node("h");
		
		a.adjacent = new Node[] {b};
		b.adjacent = new Node[] {c, d};
		c.adjacent = new Node[] {d, e};
		d.adjacent = new Node[] {e, f};
		e.adjacent = new Node[] {b};
		f.adjacent = new Node[] {g};
		g.adjacent = new Node[] {h};
		h.adjacent = new Node[] {f};
		
		Assert.assertTrue(containsPath(a, e));
		
		clearStates(new Node[]{a, b, c, d, e, f, g, h});
		
		Assert.assertTrue(containsPath(b, e));
		
		clearStates(new Node[]{a, b, c, d, e, f, g, h});
		
		Assert.assertFalse(containsPath(e, a));
		
		clearStates(new Node[]{a, b, c, d, e, f, g, h});
		
		Assert.assertTrue(containsPath(e, b));
		
		clearStates(new Node[]{a, b, c, d, e, f, g, h});
		
		Assert.assertTrue(containsPath(f, h));
		
		clearStates(new Node[]{a, b, c, d, e, f, g, h});
		
		Assert.assertTrue(containsPath(g, f));
		
		clearStates(new Node[]{a, b, c, d, e, f, g, h});
	}
	
	private static boolean containsPath(Node s, Node e) {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(s);
		
		while (!queue.isEmpty()) {
			Node current = queue.removeFirst();
			current.state = State.Visited;
			if (current == e) {
				return true;
			}
			for (Node adjacent : current.adjacent) {
				if (adjacent.state != State.Visited) {
					queue.addLast(adjacent);
				}
			}
		}
		
		return false;
	}
	
	private static void clearStates(Node[] nodes) {
		for (Node node : nodes) {
			clearState(node);
		}
	}
	
	private static void clearState(Node node) {
		node.state = State.Unvisited;
	}
}
