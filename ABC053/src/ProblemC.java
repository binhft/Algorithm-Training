import java.util.Scanner;

public class ProblemC {
	public static void main(String[] args) {
		long target = 0;
		Scanner sc = new Scanner(System.in);
		target = sc.nextLong();

		long res = (long) Math.floor(target / 11) * 2;
		long l2 = target % 11;
		if (l2 > 6) {
			res += 2;
		} else if (l2 >= 1){
			res += 1;
		}
		
		System.out.println(res);
	}
}
