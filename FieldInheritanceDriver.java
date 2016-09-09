public class FieldInheritanceDriver {
  public static void main( String[] args) {
    FieldInheritance f = new FieldInheritance("Bill", "Brasky");
    System.out.println(f);

    FieldInheritanceSub g = new FieldInheritanceSub("Turkish", "Delight");
    System.out.println(g);
    g.test();
    System.out.println(g);
  }
}
