public class Dog {
    //a field with an int had a default value of 0, double defaults to 0.0,
    //and any object defaults to null, which includes strings
    private String name, breed;
    private int age;
    private double weight;

    public Dog() {}

    public Dog( String n, String b, int a, double w) {
      name = n;
      breed = b;
      age = a;
      weight = w;
    }

    public String getName()   { return name; }
    public String getBreed()  { return breed; }
    public int getAge()       { return age; }
    public double getWeight() { return weight; }

    public String getEverything() {
      return name + " is a " + breed + ", " + age + " years old, " + weight + " kg.";
    }
}
