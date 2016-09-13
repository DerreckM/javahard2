public class PointSwapperDriver {
  public static void main( String[] args) {
    PointSwapperInt pi = new PointSwapperInt(3, 5);

    System.out.println( "before: " + pi);
    pi.swap();
    System.out.println( "after: " + pi);
    pi.swap();
    System.out.println( "after after: " + pi);

    PointSwapperDouble pd = new PointSwapperDouble(1.1, 4.4);

    System.out.println( "\nbefore: " + pd);
    pd.swap();
    System.out.println( "after: " + pd);
    pd.swap();
    System.out.println( "after after: " + pd);

    PointSwapper<Integer> pg1 = new PointSwapper<>(2, 6);
    PointSwapper<Double> pg2 = new PointSwapper<>(1.3, 5.7);

    System.out.println( "\nbefore: " + pg1);
    pg1.swap();
    System.out.println( "after: " + pg1);
    pg1.swap();
    System.out.println( "after after: " + pg1);

    System.out.println( "\nbefore: " + pg2);
    pg2.swap();
    System.out.println( "after: " + pg2);
    pg2.swap();
    System.out.println( "after after: " + pg2);
  }
}
