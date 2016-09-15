public class InterfacePleaser implements ArbitraryInterface {
  public double getNumber()  {
    return 4;
  }

  public void doSomething( int n) {
    n = Math.abs(n);
    for ( int i=1; i <=n; i++) {
      System.out.println(i);
    }
  }

  public int doSomethingElse(int x) {
    return x*x;
  }
}
