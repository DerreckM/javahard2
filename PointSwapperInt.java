public class PointSwapperInt {
  private int a, b;

  public PointSwapperInt( int a, int b) {
    this.a = a;
    this.b = b;
  }

  public void swap() {
    int temp = a;
    a = b;
    b = temp;
  }

  public int getFirst() { return a; }
  public int getLast() { return b; }

  public String toString() {
    return "(" + a + ", " + b + ")";
  }
}
