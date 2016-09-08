import java.util.ArrayList;

public class FishDriver {
  public static void main( String[] args ) {

    String[] names = { "Wanda", "Dory", "Bruce", "Qwerty", "Blinky", "Lenny",
                 "Flounder", "Mr. Limpet", "Mrs. Puff", "Moby Dick", "Freddi"};

    ArrayList<Fish> school = new ArrayList<Fish>();

    for ( String n: names) {
      Fish f = new Fish(n);
      school.add(f);
    }

    for ( Fish f : school) {
      System.out.println(f);
    }

    System.out.println();
    System.out.println(Fish.numCreated() + " Fish objects were created.");
  }
}
