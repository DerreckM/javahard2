public class Buddy implements Comparable {
	private int age;
	private String name;

	public Buddy(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object obj) {
		Buddy other = (Buddy)obj;
		return ( this.age == other.age && this.name.equals(other.name) );
	}

	public int compareTo(Object obj) {
		Buddy other = (Buddy)obj;
		if ( this.name.equals(other.name) )
			return (this.age - other.age);
		else
			return this.name.compareTo(other.name);
	}

	public String toString() { return name + "-" + age; }
}
