public class PointSwapperDouble {
  private double a, b;

  public PointSwapperDouble( double a, double b) {
    this.a = a;
    this.b = b;
  }

  public void swap() {
    double temp = a;
    a = b;
    b = temp;
  }

  public double getFirst() { return a; }
  public double getLast()  { return b; }

  public String toString() {
    return "(" + a + ", " + b + ")";
  }
}
