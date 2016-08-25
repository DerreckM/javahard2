public class RectangleDriver {
  public static void main( String[] args) {
    //old way to instantiate the object
    // Rectangle r  = new Rectangle();
    // r.length = 10;
    // r.width = 5;

    // we can accomplish the same on one line since our fields are private and we have constructors
    Rectangle r = new Rectangle(10, 5);
    System.out.println("The area is " + r.getArea());
  }
}
