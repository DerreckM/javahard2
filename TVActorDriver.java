public class TVActorDriver {
  public static void main( String[] args) {
    TVActor a = new TVActor();
    a.name = "Thomas Middleditch";
    a.role = "Richard Hendricks";

    //instance of the class, with its own copies o the instance variables
    TVActor b = new TVActor();
    b.name = "Martin Starr";
    b.role = "Bertram Gilfoyle";

    TVActor c = new TVActor();
    c.name = "Kumail Nanjiani";
    c.role = "Dinesh Chugtai";

    System.out.println( a.name + " played " + a.role );
    System.out.println( b.name + " played " + b.role );
    System.out.println( c.name + " played " + c.role );
  }
}
