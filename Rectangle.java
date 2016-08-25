public class Rectangle {
  private int length, width;
  //constructor that has same name as class
  public Rectangle() {
    length = width = 0;
  }
  //second constructor, also had no return type (no void), makes sure setup is done: initializing all the instance variables
  public Rectangle( int l, int w ) {
    length = l;
    width = w;
  }

  public int getArea() {
    return length*width;
  }
}
