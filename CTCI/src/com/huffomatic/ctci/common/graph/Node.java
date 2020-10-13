package com.huffomatic.ctci.common.graph;

public class Node {
	public String name;
	public Node[] adjacent;
	public State state = State.Unvisited;
	
	public Node(String name) {
		this.name = name;
	}
}
