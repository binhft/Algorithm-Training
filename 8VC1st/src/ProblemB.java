import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemB {
	public static void main(String[] args) {
		int polandNum, enemyNum;
		Scanner sc = new Scanner(System.in);
		polandNum = sc.nextInt();
		enemyNum = sc.nextInt();
		sc.nextLine();
		Set<String> polandWord = new HashSet<String>();
		int commonCount = 0;
		String currentWord = "";

		for (int i = 0; i < polandNum; i++) {
			currentWord = sc.nextLine();
			polandWord.add(currentWord);
		}

		for (int i = 0; i < enemyNum; i++) {
			if (polandWord.contains(sc.nextLine())) {
				commonCount++;
			}
		}

		// System.out.println(polandNum + " " + enemyNum);
		// System.out.println(commonCount);
		if (commonCount % 2 == 1) {
			polandNum = polandNum + 1;
		}

		if (polandNum > enemyNum) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}
}
