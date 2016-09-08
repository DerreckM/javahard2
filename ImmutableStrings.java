import java.util.ArrayList;

public class ImmutableStrings {
	public static void main( String[] args ) {
		ArrayList<Double> list = new ArrayList<Double>();
		System.out.println(list);
		list.add(4.0);
		list.add(2.0);
		System.out.println(list);
		list.clear();
		System.out.println(list);

		String word = "impossible";
		System.out.println("\n" + word);
		word.substring(2);
		System.out.println(word);
		word.toUpperCase();
		System.out.println(word);

		String w = "workaround";
		System.out.println("\n" + w);
		w = w.substring(0,4);
		System.out.println(w);
		w = w.toUpperCase();
		System.out.println(w);

		System.out.println("\nBefore passing to method: " + word + ", " + w);
		swap(word, w);
		System.out.println("After returning from method: " + word + ", " + w);
	}

	public static void swap( String a, String b ) {
		System.out.println("\tBefore \"swapping\": " + a + ", " + b);
		String temp = a;
		a = b;
		b = temp;
		System.out.println("\tAfter \"swapping\": " + a + ", " + b);
	}
}
