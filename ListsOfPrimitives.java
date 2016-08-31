import java.util.ArrayList;

public class ListsOfPrimitives {
  public static void main(String[] args) {
    ArrayList<String> hats = new ArrayList<String>();

    hats.add("fez");
    hats.add("bowler");
    hats.add("beanie");
    hats.add("western");
    hats.add("fedora");

    System.out.println( hats );

    String jumble = "";
    for ( String s : hats ) {
      jumble += s;
    }
    System.out.println("All together now: " + jumble);

    // ArrayList<int> bins = new ArrayList<int>();
    // int is a primitive type, Integer is an object that contains a single int
    // This is called a 'wrapper' class in Java, cuz it's a very thin layer that
    // wraps around a primitive type.
    ArrayList<Integer> bins = new ArrayList<Integer>();

    bins.add(new Integer(1));
    bins.add(new Integer(3));
    bins.add(new Integer(3));
    bins.add(new Integer(1));

    bins.add(1);
    bins.add(4);
    bins.add(6);
    bins.add(4);
    bins.add(1);

    System.out.println( bins );

    int total = 0;
    for ( Integer N : bins ) {
      int n = N.intValue();
      total += n;
    }
    System.out.println("The total is " + total);

    total = 0;
    for ( int n : bins) {
      total += n;
    }
    System.out.println("The total is still " + total);

    ArrayList<Character> letters = new ArrayList<Character>();
    letters.add('z'); // auto-boxes char

    ArrayList<Double> weights = new ArrayList<Double>();
    weights.add(0.14); // auto-boxes double

    ArrayList<Boolean> dealt = new ArrayList<Boolean>();
    while ( dealt.size() < 52 )
      dealt.add(false); // auto-boxes boolean
  }
}
