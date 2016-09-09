public class BasicInheritance {
  public static void main( String[] args) {
    Rect rect1 = new Rect(4,5);
    System.out.println(rect1);
    System.out.println("\tArea: " + rect1.getArea());
    System.out.println("\tPerimeter: " + rect1.getPerimeter());

    Square sq1 = new Square(3);
    System.out.println("\n"+sq1);
    System.out.println("\tArea: " + sq1.getArea());
    System.out.println("\tPerimeter: " + sq1.getPerimeter());

    Rect r = new Rect();
    Rect s = new Square(2);
    System.out.println("\n" + r + ", and " + s);

    r = s;
    System.out.println("\nHere is my rectangle: " + r);
  }
}
