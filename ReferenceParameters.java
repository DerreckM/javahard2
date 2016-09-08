import java.util.Arrays;

public class ReferenceParameters {
	public static void main( String[] args ) {
		int[] a = new int[7];
		Arrays.fill(a, 2);
		System.out.println( Arrays.toString(a) );

		int[] b = { 1, 2, 3, 4, 5 };
		a = b;
		System.out.println( Arrays.toString(a) );

		int[] c = new int[a.length*2];
		for ( int i=0; i<a.length; i++ ) {
			c[i] = a[i];
		}
		a = c;
		System.out.println( Arrays.toString(a) );

		System.out.println("\na is at reference " + a);
		System.out.println( Arrays.toString(a) );
		squareValues(a);
		System.out.println( Arrays.toString(a) );

		System.out.println("\na is at reference " + a);
		chopArray(a);
		System.out.println( Arrays.toString(a) );
		System.out.println("a is at reference " + a);

		System.out.println("\na is at reference " + a);
		a = chopArray2(a);
		System.out.println( Arrays.toString(a) );
		System.out.println("a is at reference " + a);
	}

	public static void squareValues( int[] arr ) {
		System.out.println("Squaring array at reference " + arr);
		for ( int i=0; i<arr.length; i++ ) {
			arr[i] = arr[i]*arr[i];
		}
	}

	public static void chopArray( int[] arr ) {
		int[] c = new int[arr.length/2];
		for ( int i=0; i<c.length; i++ ) {
			c[i] = arr[i];
		}
		arr = c;
		System.out.println("The array is now at reference " + arr);
	}

	public static int[] chopArray2( int[] arr ) {
		int[] c = new int[arr.length/2];
		for ( int i=0; i<c.length; i++ ) {
			c[i] = arr[i];
		}
		System.out.println("Returning the reference " + c);
		return c;
	}
}
