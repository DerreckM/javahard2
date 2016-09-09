public class NumberGuyDriver {
  public static void main( String[] args) {
    NumberGuy n = new NumberGuy(5);

    System.out.println(n);
    n.doubleYourself();
    System.out.println(n);

    int q = 4;
    System.out.println(q);
    n.changeThis(q);
    System.out.println(q);
  }
}
