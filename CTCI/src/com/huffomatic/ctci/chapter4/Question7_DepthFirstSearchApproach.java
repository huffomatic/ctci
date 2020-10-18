package com.huffomatic.ctci.chapter4;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Assert;

import com.huffomatic.ctci.common.graph.Project;
import com.huffomatic.ctci.common.graph.State;

/**
 * Build Order: Find a build order that will allow projects to be built after their dependencies have been built.
 * 
 * Input: projects: a, b, c, d, e, f; dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 * Output: f, e, a, b, d, c
 * 
 * Time:  O(P + D) where P is the number of projects and D is the number of dependency pairs.
 * Space: O(P + D) where P is the number of projects and D is the number of dependency pairs.
 * 
 * @author huffomatic
 *
 */
public class Question7_DepthFirstSearchApproach {
	public static void main(String[] args) throws Exception {
		Project a = new Project("a");
		Project b = new Project("b");
		Project c = new Project("c");
		Project d = new Project("d");
		Project e = new Project("e");
		Project f = new Project("f");
		Project g = new Project("g");
		
		a.addChild(e);
		b.addChild(a);
		b.addChild(e);
		c.addChild(a);
		d.addChild(g);
		f.addChild(a);
		f.addChild(b);
		f.addChild(c);
		
		ArrayList<Project> graph1 = new ArrayList<Project>();
		graph1.add(a);
		graph1.add(b);
		graph1.add(c);
		graph1.add(d);
		graph1.add(e);
		graph1.add(f);
		graph1.add(g);
		
		Project[] buildOrder1 = getBuildOrder(graph1);
		
		Assert.assertTrue(buildOrder1.length == 7);
		Assert.assertTrue(buildOrder1[0] == f);
		Assert.assertTrue(buildOrder1[1] == d);
		Assert.assertTrue(buildOrder1[2] == g);
		Assert.assertTrue(buildOrder1[3] == c);
		Assert.assertTrue(buildOrder1[4] == b);
		Assert.assertTrue(buildOrder1[5] == a);
		Assert.assertTrue(buildOrder1[6] == e);
		
		a.children.clear();
		a.dependencies = 0;
		a.state = State.Unvisited;
		b.children.clear();
		b.dependencies = 0;
		b.state = State.Unvisited;
		c.children.clear();
		c.dependencies = 0;
		c.state = State.Unvisited;
		d.children.clear();
		d.dependencies = 0;
		d.state = State.Unvisited;
		e.children.clear();
		e.dependencies = 0;
		e.state = State.Unvisited;
		f.children.clear();
		f.dependencies = 0;
		f.state = State.Unvisited;
		g.children.clear();
		g.dependencies = 0;
		g.state = State.Unvisited;
		
		a.addChild(d);
		f.addChild(b);
		b.addChild(d);
		f.addChild(a);
		d.addChild(c);
		
		ArrayList<Project> graph2 = new ArrayList<Project>();
		graph2.add(a);
		graph2.add(b);
		graph2.add(c);
		graph2.add(d);
		graph2.add(e);
		graph2.add(f);
		
		Project[] buildOrder2 = getBuildOrder(graph2);
		
		Assert.assertTrue(buildOrder2.length == 6);
		Assert.assertTrue(buildOrder2[0] == f);
		Assert.assertTrue(buildOrder2[1] == e);
		Assert.assertTrue(buildOrder2[2] == b);
		Assert.assertTrue(buildOrder2[3] == a);
		Assert.assertTrue(buildOrder2[4] == d);
		Assert.assertTrue(buildOrder2[5] == c);
		
		a.children.clear();
		a.dependencies = 0;
		a.state = State.Unvisited;
		b.children.clear();
		b.dependencies = 0;
		b.state = State.Unvisited;
		c.children.clear();
		c.dependencies = 0;
		c.state = State.Unvisited;
		d.children.clear();
		d.dependencies = 0;
		d.state = State.Unvisited;
		e.children.clear();
		e.dependencies = 0;
		e.state = State.Unvisited;
		f.children.clear();
		f.dependencies = 0;
		f.state = State.Unvisited;
		g.children.clear();
		g.dependencies = 0;
		g.state = State.Unvisited;
		
		a.addChild(b);
		b.addChild(c);
		c.addChild(d);
		d.addChild(a);
		
		ArrayList<Project> graph3 = new ArrayList<Project>();
		graph3.add(a);
		graph3.add(b);
		graph3.add(c);
		graph3.add(d);
		graph3.add(e);
		
		Project[] buildOrder3 = getBuildOrder(graph3);
		
		Assert.assertTrue(buildOrder3 == null);
	}
	
	private static Project[] getBuildOrder(ArrayList<Project> projects) {
		// Initializes the stack holding the projects in reverse order.
		Stack<Project> stack = new Stack<Project>();
		
		// Iterates through the projects and adds each to the stack if depth-first search didn't find a cycle.
		for (Project project : projects) {
			if (project.state == State.Unvisited) {
				if (!doDFS(project, stack)) {
					return null;
				}
			}
		}
		
		// Initializes the build order array.
		Project[] buildOrder = new Project[projects.size()];
		
		// Iterates the stack and adds the projects to the build order.
		int index = 0;
		while (!stack.isEmpty()) {
			buildOrder[index] = stack.pop();
			index++;
		}
		
		return buildOrder;
	}
	
	private static boolean doDFS(Project project, Stack<Project> stack) {
		// If the project's state is visiting, then we have found a cycle so return false.
		if (project.state == State.Visiting) {
			return false;
		}
		
		// If the project's state is unvisited, then we need to iterate through the children 
		// and do a depth-first search on the children.
		if (project.state == State.Unvisited) {
			project.state = State.Visiting;
			for (Project child : project.children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}
			project.state = State.Visited;
			stack.add(project);
		}
		
		return true;
	}
}
