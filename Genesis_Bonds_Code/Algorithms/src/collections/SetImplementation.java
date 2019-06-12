package collections;

import java.util.Arrays;
import java.util.List;


public class SetImplementation<T> {
	
	/*
	 * Implement a set-like data structure that supports Insert, 
	 * Remove, and GetRandomElement efficiently. Example: If you 
	 * insert the elements 1, 3, 6, 8 and remove 6, the structure 
	 * should contain [1, 3, 8]. Now, GetRandom should return one 
	 * of 1, 3 or 8 with equal probability.  
	 */
	
	private int index = 0;
	private Object[] entities;
	
	public SetImplementation() {
		this.entities = new Object[16];
	}
	
	public SetImplementation(T[] objs) {
		this.entities = new Object[objs.length];
		for(int i = 0; i < objs.length; i++) {
			int temp = i;
			boolean exists = Arrays.asList(entities).stream().anyMatch(x ->  x!=null && x.equals(objs[temp]));
			if(!exists) {
				entities[index++] = objs[i];
			}
		}
	}
	
	public void insert(T obj) {
		if(index == entities.length) {
			Object[] temp = new Object[entities.length + 16];
			for(int i = 0; i < entities.length; i++) {
				temp[i] = entities[i];
			}
			
			entities = temp;
			temp = null;
		}
		if(index==0) {
			entities[index++] = obj;
		}
		boolean exists = Arrays.asList(entities).stream().anyMatch(x -> x!=null && x.equals(obj));
		if(!exists) {
			entities[index++] = obj;
		}
	}
	
	public void remove(T obj) { 
		for(int i = 0; i < entities.length; i++) {
			if(entities[i].equals(obj)) {
				Object[] temp = new Object[entities.length-1];
				for(int j = 0; j <= i-1; j++) {
					temp[j] = entities[j];
				}
				for(int j = i; j < entities.length-1; j++) {
					temp[j] = entities[j+1];
				}
				entities = temp;
			}
		}
		
	}
	
	public Object getRandomElement() {
		int i = (int) (Math.random()*entities.length);
		
		return entities[i];
	}
	
	public void print() {
		for(int i = 0; i < entities.length; i++) {
			System.out.println(entities[i]);
		}
	}

}
