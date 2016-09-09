public class NumberGuy {
  private int number;

  public NumberGuy() { number = 0; }
  public NumberGuy( int number ) { this.number = number; }
  public int getNumber() { return number; }
  public String toString() { return "" + number; }

  public void doubleYourself() {
    number = number*2;
  }

  public void changeThis( int q ) {
    q = q*2;
  }
}
