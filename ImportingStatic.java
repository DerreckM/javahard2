import static java.lang.Math.*;
import static java.lang.System.out;

public class ImportingStatic {
  public static void main ( String[] args) {
    double a = random();
    double b = random();

    out.println( PI );
    out.println( abs(-9) );
    out.println( sqrt(2) );
    out.println( min(a, b) + " is smaller." );
    out.println( max(a, b) + " is larger." );
    out.println( pow(a, b) );  // a raised to the power of

    out.println( Math.sin(PI) );
    out.println( Math.cos(PI) );
    out.println( Math.tan(PI) );
  }
}
