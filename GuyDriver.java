import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class GuyDriver {
	public static void main( String[] args ) {

		ArrayList<Guy> list = getListFromFile("datafiles/buddytests.txt");
		System.out.println(list+"\n");

		Collections.sort(list);
		for ( Guy g : list )
			System.out.println(g);
	}

	public static ArrayList<Guy> getListFromFile( String filename ) {
		ArrayList<Guy> list = new ArrayList<>();
		Scanner in = null;

		try {
			in = new Scanner(new java.io.File(filename));
		}
		catch ( java.io.FileNotFoundException e ) {
			System.err.println("Couldn't open 'buddytests.txt': " + e);
			System.exit(1);
		}

		while ( in.hasNext() ) {
			Guy g = new Guy(in.next(), in.nextInt());
			if ( ! list.contains(g) )
				list.add(g);
			in.next(); // read these from the file but just throw them away
			in.nextInt();
			in.nextInt();
		}
		in.close();
		return list;
	}

}
