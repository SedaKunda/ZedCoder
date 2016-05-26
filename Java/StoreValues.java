import java.util.*;
public class StoreValues {
	public static void main(String args[]) {
	int i = 1;//is currently employed
	int a = 2;//is computer literate
	int b = 4;//has high school diploma
	int c = 8;//has degree
	int d = 16;//has children
	int e = 32;//is married
	int f = 64;//can drive
	int g = 128;//has passport
	int h = 256;//aged over 18
	
	Map<Integer, String> m = new HashMap<Integer, String>();
	m.put(99, "Seda");
	m.put(121, "Mwelwa");
	m.put(257, "Miriam");
	m.put(361, "Douglas");
	m.put(27, "Phyllis");
	m.put(65, "Billy");
	
	for (Map.Entry<Integer, String> entry : m.entrySet())
	{
		int test = entry.getKey();
		String name = entry.getValue();
	
		System.out.println("The profile for this user: " + name);
		
		if ((test & i)!=0) {
			System.out.println("\tIs currently employed");
		}
		if ((test & a)!=0) {
			System.out.println("\tIs computer literate");
		}
		if ((test & b)!=0) {
			System.out.println("\tHas high school diploma");
		}
		if ((test & c)!=0) {
			System.out.println("\tHas a degree");
		}
		if ((test & d)!=0) {
			System.out.println("\tHas children");
		}
		if ((test & e)!=0) {
			System.out.println("\tIs married");
		}
		if ((test & f)!=0) {
			System.out.println("\tHas drivers licence");
		}
		if ((test & g)!=0) {
			System.out.println("\tHas valid passport");
		}
		if ((test & h)!=0) {
			System.out.println("\tIs over 18 years");
		}
		System.out.println();
	}
	}
}
