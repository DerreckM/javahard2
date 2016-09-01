public class PointSwapper<Type> {
  private Type a, b;
  //Type is a generic; we can also use <T> or <E> for 'element' so long as we are consistent
  public PointSwapper( Type a, Type b) {
    this.a = a;
    this.b = b;
  }

  public void swap() {
    Type temp = a;
    a = b;
    b = temp;
  }

  public Type getFirst() { return a; }
  public Type getLast()  { return b; }

  public String toString() {
    return "(" + a + ", " + b + ")";
  }
}
