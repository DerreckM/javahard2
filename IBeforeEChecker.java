import java.util.Scanner;
import java.util.ArrayList;
import java.io.InputStream;

public class IBeforeEChecker {
  // the instance variables or fields that'll be accessible in every class method
  private InputStream source;
  private int matchCount;
  private boolean computed;
  private ArrayList<String> wordList;

  public IBeforeEChecker( InputStream source ) {
    matchCount = 0;
    computed = false;
    wordList = new ArrayList<String>();
    this.source = source;
  }
  // fitsRule is a helper method that we can call while writing our other methods
  private boolean fitsRule( String word ) {
    if ( word.contains("ie") && ! word.contains("cie") ) {
      return true;
    }
    else if ( word.contains("cei") ) {
      return true;
    }
    return false;
  }

  private void doCalculations() {
    Scanner input = new Scanner(source);
    while ( input.hasNext() ) {
      String word = input.next();
      int ieLoc = word.indexOf("ie");
      int eiLoc = word.indexOf("ei");
      if ( ! wordList.contains(word) && (ieLoc >= 0 || eiLoc >= 0) ) {
        wordList.add(word);
      }
    }
    input.close();

    for ( String word : wordList ) {
      if ( fitsRule(word) )
        matchCount++;
    }
    computed = true;
  }

  public int getMatches() {
    if ( ! computed )
      doCalculations();
    return matchCount;
  }

  public int getExceptions() {
    if ( ! computed )
      doCalculations();
    return getWordCount() - matchCount;
  }

  public int getWordCount() {
    if ( ! computed )
      doCalculations();
    return wordList.size();
  }

  public ArrayList<String> getWordList() {
    if ( ! computed )
      doCalculations();
    return wordList;
  }
}
