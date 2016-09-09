public class FieldInheritance {

    private String first;
    protected String last;

    public FieldInheritance() {
      first = last = "";
    }

    public FieldInheritance( String first, String last) {
      this.first = first;
      this.last = last;
    }

    public void setFirst( String s) {
      first = s;
    }

    public void setLast( String s ) {
      last = s;
    }

    public String getFirst() { return first; }
    public String getLast() { return last; }

    public String toString() {
      return first + " " + last;
    }
}
