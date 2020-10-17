package com.huffomatic.ctci.chapter4;

import java.util.ArrayList;

import org.junit.Assert;

import com.huffomatic.ctci.common.graph.Project;

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
public class Question7_TopologicalSortApproach {
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
		Assert.assertTrue(buildOrder1[0] == d);
		Assert.assertTrue(buildOrder1[1] == f);
		Assert.assertTrue(buildOrder1[2] == g);
		Assert.assertTrue(buildOrder1[3] == b);
		Assert.assertTrue(buildOrder1[4] == c);
		Assert.assertTrue(buildOrder1[5] == a);
		Assert.assertTrue(buildOrder1[6] == e);
		
		a.children.clear();
		a.dependencies = 0;
		b.children.clear();
		b.dependencies = 0;
		c.children.clear();
		c.dependencies = 0;
		d.children.clear();
		d.dependencies = 0;
		e.children.clear();
		e.dependencies = 0;
		f.children.clear();
		f.dependencies = 0;
		g.children.clear();
		g.dependencies = 0;
		
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
		Assert.assertTrue(buildOrder2[0] == e);
		Assert.assertTrue(buildOrder2[1] == f);
		Assert.assertTrue(buildOrder2[2] == a);
		Assert.assertTrue(buildOrder2[3] == b);
		Assert.assertTrue(buildOrder2[4] == d);
		Assert.assertTrue(buildOrder2[5] == c);
		
		a.children.clear();
		a.dependencies = 0;
		b.children.clear();
		b.dependencies = 0;
		c.children.clear();
		c.dependencies = 0;
		d.children.clear();
		d.dependencies = 0;
		e.children.clear();
		e.dependencies = 0;
		f.children.clear();
		f.dependencies = 0;
		g.children.clear();
		g.dependencies = 0;
		
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
		// Initializes the build order array.
		Project[] buildOrder = new Project[projects.size()];
		
		// Adds the projects with zero dependencies to the build order array.
		int offset = addZeroDependencyProjects(buildOrder, projects, 0);
		
		// Initializes the index to 0.
		int index = 0;
		
		// Iterates through the build order projects and finds more projects with cleared dependencies, if possible.
		while (index < buildOrder.length) {
			// Gets the current project.
			Project project = buildOrder[index];
			
			// If project is null, then this means there are projects with dependencies so return null.
			if (project == null) {
				return null;
			}
			
			// Iterate through the project's children and decrement their dependencies by one.
			for (Project child : project.children) {
				child.decrementDependencies();
			}
			
			// Adds the projects with zero dependencies to the build order array.
			offset = addZeroDependencyProjects(buildOrder, projects, offset);
			
			// Increments the index.
			index++;
		}
		
		return buildOrder;
	}
	
	private static int addZeroDependencyProjects(Project[] buildOrder, ArrayList<Project> projects, int offset) {
		// Initializes the zero project lists.
		ArrayList<Project> zeroProjects = new ArrayList<Project>();
		
		// Iterates through the projects and adds any zero dependency projects to the build order array and
		// adds the project to the zero projects list for removal.
		for (Project project : projects) {
			if (project.dependencies == 0) {
				buildOrder[offset] = project;
				offset++;
				zeroProjects.add(project);
			}
		}
		
		// Removes the zero projects from the project list.
		for (Project zeroProject : zeroProjects) {
			projects.remove(zeroProject);
		}
		
		return offset;
	}
}
