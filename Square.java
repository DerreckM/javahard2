public class Square extends Rect {
  // super() means run the constructor of the superclass
  public Square() {
    super();
  }

  public Square( double side) {
    super(side, side);
  }

  public String toString() {
    return "Square, " + super.getLength() + "x" + super.getLength();
  }
}
