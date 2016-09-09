public class Rect {
  private double length, width;

  public Rect() {
    length = width = 0;
  }

  public Rect( double length, double width) {
    this.length = length;
    this.width = width;
  }

  public double getLength() { return length; }
  public double getWidth() { return width; }

  public double getArea() {
    return length * width;
  }

  public double getPerimeter() {
    return 2*length + 2*width;
  }

  public String toString() {
    return "Rect, " + length + "x" + width;
  }
}
