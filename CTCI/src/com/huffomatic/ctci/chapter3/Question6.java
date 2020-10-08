package com.huffomatic.ctci.chapter3;

import java.util.LinkedList;

import org.junit.Assert;

import com.huffomatic.ctci.common.queue.EmptyQueueException;

/**
 * Animal Shelter: Holds dogs and cats and uses FIFO operations.
 * Implement enqueue, dequeueAny, dequeueDog, dequeueCat.
 * 
 * Time:  O() 
 * Space: O() 
 * 
 * @author huffomatic
 *
 */
public class Question6 {
	private static int currentTime = 1;
	private static LinkedList<Dog> dogs = new LinkedList<Dog>();
	private static LinkedList<Cat> cats = new LinkedList<Cat>();
	
	public static void main(String[] args) throws Exception {
		enqueue((new Question6()).new Dog("Appa", currentTime));
		enqueue((new Question6()).new Cat("Belle", currentTime));
		enqueue((new Question6()).new Cat("Charles", currentTime));
		enqueue((new Question6()).new Dog("Danny", currentTime));
		enqueue((new Question6()).new Dog("Echo", currentTime));
		enqueue((new Question6()).new Cat("Franz", currentTime));
		Assert.assertTrue("Appa".equals(dequeueAny().name));
		Assert.assertTrue("Danny".equals(dequeueDog().name));
		Assert.assertTrue("Belle".equals(dequeueCat().name));
		Assert.assertTrue("Charles".equals(dequeueAny().name));
		Assert.assertTrue("Echo".equals(dequeueAny().name));
		Assert.assertTrue("Franz".equals(dequeueAny().name));
	}
	
	private static void enqueue(Animal animal) {
		if (animal instanceof Dog) {
			dogs.add((Dog) animal);
			currentTime++;
		}
		else if (animal instanceof Cat) {
			cats.add((Cat) animal);
			currentTime++;
		}
	}
	
	private static Animal dequeueAny() throws EmptyQueueException {
		if (dogs.isEmpty()) {
			return (Animal) dequeueCat();
		}
		else if (cats.isEmpty()) {
			return (Animal) dequeueDog();
		}
		else {
			Dog dog = dogs.peek();
			Cat cat = cats.peek();
			if (dog.time < cat.time) {
				dog = dogs.removeFirst();
				return dog;
			}
			else {
				cat = cats.removeFirst();
				return cat;
			}
		}
	}
	
	private static Dog dequeueDog() throws EmptyQueueException {
		Dog dog = dogs.removeFirst();
		return dog;
	}
	
	private static Cat dequeueCat() throws EmptyQueueException {
		Cat cat = cats.removeFirst();
		return cat;
	}
	
	public abstract class Animal {
		protected String name;
		protected int time;
		public Animal(String name, int time) {
			this.name = name;
			this.time = time;
		}
	}
	
	public class Dog extends Animal {
		public Dog(String name, int time) {
			super(name, time);
		}
	}
	
	public class Cat extends Animal {
		public Cat(String name, int time) {
			super(name, time);
		}
	}
}
