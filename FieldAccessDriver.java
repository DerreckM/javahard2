public class FieldAccessDriver {
  public static void main( String[] args) {
    FieldAccess j = new FieldAccess("Robert", "Parker", "Butch");
    System.out.println(j.getFullName());
    // lines 6-8 change the fields properly by using setter (mutator) methods
    j.setLast("Elliott");
    j.setFirst("Samuel");
    j.setNick("Sam");
    System.out.println(j.getFullName());
    //lines 11-13 are incorrect.  The field first works, since it is public, but last won't compile, and nick also works since it defaults to package-driver and we're in the package
    j.first = "Avery";
    // j.last = "Markham";
    System.out.println(j.nick);
  }
}
