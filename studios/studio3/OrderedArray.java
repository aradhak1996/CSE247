package studio3;

public class OrderedArray<T extends Comparable<T>> implements PriorityQueue<T> {

	public T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public OrderedArray(int maxSize) {
		array = (T[]) new Comparable[maxSize];
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		for(int i = 0; i<size; i++)
		{
			if(array[i].equals(null))
			{
				return false;
			}
		}
		
		
		return true;
		
	}

	@Override
	public void insert(T thing) {
		array[size].equals(thing);
		size++;
	}
	
	@Override
	public T extractMin() {
		T min = array[0];
		for(int i=1; i<size; i++) {
			if(array[i].compareTo(min) < 0){
				min = array[i];
			}
		}
		return min;
	}

}
