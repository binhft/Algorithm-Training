import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class ProblemA {	
	private int process(String input) {
		Set<String> set = new HashSet<String>();
		
		for (int i = 0; i < input.length(); i++) {
			String temp = input.substring(i) + input.substring(0, i);
			set.add(temp);
		}
		
		return set.size();
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.print(new ProblemA().process(input));
	}
}
