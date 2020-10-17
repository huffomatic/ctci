package com.huffomatic.ctci.common.graph;

import java.util.ArrayList;

public class Project {
	public String name;
	public ArrayList<Project> children = new ArrayList<Project>();
	public int dependencies = 0;
	
	public Project(String name) {
		this.name = name;
	}
	
	public void addChild(Project child) {
		children.add(child);
		child.incrementDependencies();
	}
	
	public void incrementDependencies() {
		dependencies++;
	}
	
	public void decrementDependencies() {
		dependencies--;
	}
}
