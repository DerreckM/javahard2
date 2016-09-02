public class JavaHardArrayList<E> {
	private E[] arr;
	private int used;

	@SuppressWarnings("unchecked")
	public JavaHardArrayList() {
		used = 0;
		// arr = new E[10]; // doesn't compile "error: generic array creation"
		arr = (E[])new Object[10];
	}

	public int size() {
		return used;
	}

	public boolean add(E obj) {
		if ( used == arr.length )
			grow();
		arr[used] = obj;
		used++;
		return true;
	}

	public void add(int index, E obj) {
		if ( used == arr.length )
			grow();
		// move the other values over to make space
		for ( int i=used; i>index; i-- )
			arr[i] = arr[i-1];
		arr[index] = obj;
		used++;
	}

	public E get(int index) {
		if ( index < used ) {
			return arr[index];
		}
		return null;
	}

	public E set(int index, E obj) {
		if ( index < used ) {
			E old = arr[index]; // make a copy since set() returns old value
			arr[index] = obj;
			return old;
		}
		return null;
	}

	public E remove(int index) {
		if ( index < used ) {
			E temp = arr[index];
			// slide everything back one slot
			for ( int i=index; i<used; i++ )
				arr[i] = arr[i+1];
			used--;
			return temp;
		}
		return null;
	}

	public boolean contains(E obj) {
		for ( int i=0; i<used; i++ )
			if ( arr[i].equals(obj) )
				return true;
		return false;
	}

	public String toString() {
		String out = "";
		if ( used > 0 )
			out += arr[0];
		for ( int i=1; i<used; i++ )
			out += ", " + arr[i];
		return "[" + out + "]";
	}

	private void grow() {
		int newCapacity = 1 + 2*arr.length;
		@SuppressWarnings("unchecked")
		// E[] arr2 = new E[newCapacity]; // "error: generic array creation" :(
		E[] arr2 = (E[])new Object[newCapacity];
		for ( int i=0; i<arr.length; i++ )
			arr2[i] = arr[i];
		// move the reference so that arr now refers to the new larger array
		arr = arr2;
	}

}
