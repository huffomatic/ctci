package com.huffomatic.ctci.common.tree;

import java.util.Random;

public class BinarySearchTree {
	private int data;
	public BinarySearchTree left;
	public BinarySearchTree right;
	private int size = 0;
	
	public BinarySearchTree(int d) {
		data = d;
		size = 1;
	}
	
	public BinarySearchTree getIthNode(int random) {
		// Gets the left size.
		int leftSize = (left != null) ? left.getSize() : 0;
		
		// Finds the node within the binary tree with this exact size.
		if (random == leftSize) {
			return this;
		}
		else if (random < leftSize) {
			return left.getIthNode(random);
		}
		else {
			return right.getIthNode(random - left.getSize() - 1);
		}
	}
	
	public BinarySearchTree getRandomNode() {
		// Calculates the random number between 1 and size.
		Random random = new Random();
		int index = random.nextInt(size);
		
		// Gets the left size.
		int leftSize = (left != null) ? left.getSize() : 0;
		
		// Finds the node within the binary tree with this exact size.
		if (index == leftSize) {
			return this;
		}
		else if (index < leftSize) {
			return left.getRandomNode();
		}
		else {
			return right.getRandomNode();
		}
	}
	
	public void insert(int d) {
		// Insert into the appropriate location in the binary search tree.
		if (d <= data) {
			if (left == null) {
				left = new BinarySearchTree(d);
			}
			else {
				left.insert(d);
			}
		}
		else {
			if (right == null) {
				right = new BinarySearchTree(d);
			}
			else {
				right.insert(d);
			}
		}
		size++;
	}
	
	public BinarySearchTree find(int d) {
		if (d == data) {
			return this;
		}
		else if (d < data) {
			return (left != null) ? left.find(d) : null;
		}
		else {
			return (right != null) ? right.find(d) : null;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public int getData() {
		return data;
	}
}
