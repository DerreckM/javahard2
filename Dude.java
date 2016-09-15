public class Dude {
  private int age;
  private String name;

  public Dude(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object obj) {
    Dude other = (Dude)obj;
    return ( this.age == other.age && this.name.equals(other.name) );
  }

  @Override
  public String toString() {
    return name + "|" + age;
  }
}
