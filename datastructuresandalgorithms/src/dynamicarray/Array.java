package dynamicarray;

import java.util.Iterator;

public class Array<T> implements Iterable<T> {
	
	private T [] arr;
	private int len = 0; // length user thinks array is
	private int capacity = 0; // Actual array size
	
	public Array() { this(16); }
	
	public Array(int capacity) {
		if (capacity < 0) throw new IllegalArgumentException("Illegal capacity" + capacity);
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}

	
	
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
