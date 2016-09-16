import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListAndMap {

	public static void main( String[] args ) throws Exception {
		Map<String, Integer> wordCounts;
		if ( Math.random() < 0.5 )
			wordCounts = new TreeMap<>();
		else
			wordCounts = new HashMap<>();

		Scanner input = new Scanner(new java.io.File("datafiles/en-sample.txt"));
		buildMap(input, wordCounts);
		input.close();

		List<String> winners;
		if ( Math.random() < 0.5 )
			winners = new ArrayList<>();
		else
			winners = new LinkedList<>();

		buildList(wordCounts, winners, 1000);
		java.util.Collections.sort(winners);
		System.out.println(winners);

		Scanner kb = new Scanner(System.in);
		String word;
		do {
			System.out.print("\nEnter a word or ENTER to quit: ");
			word = kb.nextLine().toLowerCase();
			if ( word.length() == 0 )
				break;
			int count = wordCounts.getOrDefault(word, 0);
			System.out.println(word + ": " + count);
		} while ( true );
	}

	public static void buildMap( Scanner source, Map<String, Integer> map ) {
		while ( source.hasNext() ) {
			String s = source.next().toLowerCase();
			if ( ! map.containsKey(s) ) {
				map.put(s, 1);
			}
			else {
				int current = map.get(s);
				map.replace(s, current+1);
			}
		}
	}

	public static void buildList( Map<String, Integer> map,
			List<String> list, int cutoff ) {
		for ( String key : map.keySet() )
			if ( map.get(key) > cutoff )
				list.add(key);
	}
}
