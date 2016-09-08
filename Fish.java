public class Fish {
  private String name;
  private int id;
  private static int count = 0;

  public Fish( String name ) {
    this.name = name;
    count++;
    id = count;
  }

  public String toString() {
    return name + ", fish #" + id + " of " + count;
  }
  //a static method can only access static variables.
  //static methods and static variables exist even when no objects from the class
  //  have been instantiated yet
  public static int numCreated() {
    return count;
  }
}
