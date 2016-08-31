public class PrimitivesInMemory {
  public static void main(String[] args) {

    int age = 41;
    double btc = 0.11307678;
    boolean veracity = true;

    short month = 11;
    byte day = 31;
    long debt = 18153890112907L;
    float mass = 78.971F;

    System.out.println( btc );
    System.out.println( debt );
    System.out.println();
    //the string Gosling isn't stored in variable name, but rather the heap
    //and the memory address is stored in the variable instead.  This is called
    //a 'reference'
    String name = "Gosling";
  }
}
