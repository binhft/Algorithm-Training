import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char[] charArr = s.toCharArray();
		// boolean[] isAvailable = new boolean[4];
		// 0 : red
		// 1 : blue
		// 2 : green
		// 3: yellow
		// for (int i = 0; i < 4; i++) {
		// isAvailable[i] = true;
		// }
		int rPos = -1;
		int gPos = -1;
		int yPos = -1;
		int bPos = -1;
		boolean[] available = new boolean[4];
		for (int i = 0; i < available.length; i++) {
			available[i] = true;
		}
		int count = 0;
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == 'R' && rPos == -1) {
				count += 1;
				rPos = i % 4;
				available[rPos] = false;
			} else if (charArr[i] == 'G' && gPos == -1) {
				count += 1;
				gPos = i % 4;
				available[gPos] = false;
			} else if (charArr[i] == 'Y' && yPos == -1) {
				count += 1;
				yPos = i % 4;
				available[yPos] = false;
			} else if (charArr[i] == 'B' && bPos == -1) {
				count += 1;
				bPos = i % 4;
				available[bPos] = false;
			}

			if (count == 4) {
				break;
			}
		}
		
		for (int i = 0; i < available.length; i++) {
			if (available[i]) {
				if (rPos == -1) {
					rPos = i;
					available[i] = false;
				} else if (gPos == -1) {
					gPos = i;
				} else if (bPos == -1) {
					bPos = i;
				} else if (yPos == -1) {
					yPos = i;
				}
			}
		}

		int rRes = 0;
		int gres = 0;
		int yRes = 0;
		int bRes = 0;

		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == '!') {
				int remain = i % 4;
				if (remain == rPos) {
					rRes += 1;
				} else if (remain == gPos) {
					gres += 1;
				} else if (remain == yPos) {
					yRes += 1;
				} else {
					bRes += 1;
				}
			}
		}

		System.out.println(rRes + " " + bRes + " " + yRes + " " + gres);
	}
}
