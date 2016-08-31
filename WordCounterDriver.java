public class WordCounterDriver {
  public static void main( String[] args) {
    String book = "http://www.gutenberg.org/cache/epub/159/pg159.txt";

    WordCounter wc = new WordCounter(book);

    System.out.println( wc.getCount("the") );
    System.out.println( wc.getCount("I") );
    System.out.println( wc.getCount("a") );
  }
}
