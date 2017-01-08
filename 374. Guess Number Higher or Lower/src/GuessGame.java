public class GuessGame {
	int res = 1702766719;

	public int guess(int num) {
		if (num > this.res) {
			return -1;
		} else if (num == this.res) {
			return 0;
		}
		return 1;
	}
}
