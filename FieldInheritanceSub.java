public class FieldInheritanceSub extends FieldInheritance {
    //extends means that it inherits copies of all fields and methods, but not constructors
    public FieldInheritanceSub() {
      super();
    }

    public FieldInheritanceSub( String first, String last ) {
      super(first, last);
    }

    public void test() {
      //first = "GOOD";
      last = "COFFEE";
    }
}
