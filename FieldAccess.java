public class FieldAccess {
  //instance variables or fields, one public, one private, one unspecified or 'package-private'
  public String first;
  private String last;
  String nick;
  //constructor one, the default constructor or zero argument constructor
  public FieldAccess() {
    first = last = nick = "";
  }
  //constructor two, second option for FieldAccess that you must pass in three Strings
  public FieldAccess( String f, String l, String n) {
    first = f;
    last = l;
    nick = n;
  }
  //setter or mutator
  public void setFirst( String s) {
    first = s;
  }

  public void setLast( String s) {
    last = s;
  }

  public void setNick( String s) {
    nick = s;
  }
  //getter or accessor
  public String getFirst()    {return first; }
  public String getLast()     {return last; }
  public String getNick()     {return nick; }

  public String getFullName() {
    return first + " \"" + nick + "\" " + last;
  }
}
