import java.io.FileInputStream;

public class IBeforeEDriver {
  public static void main( String[] args ) throws Exception {
    FileInputStream file = new FileInputStream("datafiles/en-sample.txt");
    IBeforeEChecker check = new IBeforeEChecker(file);
    System.out.println( check.getWordCount() + " ie/ei words found." );
    System.out.println( "\t" + check.getMatches() + " match the rule, ");
    System.out.println( check.getExceptions() + " do not: ");
    System.out.println( 100.0*check.getMatches()/check.getWordCount() + "%");
  }
}
