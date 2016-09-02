public class ThingySorter<E extends Comparable<E>> {

    private E[] arr;

    public ThingySorter( E[] arr ) {
      this.arr = arr;
    }

    private void swap( int i, int j) {
      E temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    public void exchangeSort() {
      for ( int i=0; i<arr.length-1; i++)
          for ( int j=i+1; j<arr.length; j++)
            if ( arr[i].compareTo(arr[j]) > 0)
              swap(i,j);
    }

    public void quickSort() {
      quickSortHelper(0, arr.length-1);
    }

		private void quickSortHelper( int lo, int hi) {
			if ( lo < hi ) {
				int pivotloc = partition(lo, hi);
				quickSortHelper(lo, pivotloc-1);
				quickSortHelper(pivotloc+1, hi);
			}
		}

		private int partition( int lo, int hi ) {
			int pi = (lo+hi)/2;
			E pivot = arr[pi];
			swap(pi,hi);
			int cur = lo;
			for ( int i=lo; i<hi; i++ ) {
				if ( arr[i].compareTo(pivot) < 0 ) {
					swap(i,cur);
					cur++;
				}
			}
			swap(cur,hi);
			return cur;
		}

		public boolean isSorted() {
			for ( int i=0; i<arr.length-1; i++ ) {
				if ( arr[i].compareTo(arr[i+1]) > 0 )
					return false;
			}
			return true;
		}
}
