public class StringIterator {
	int length = 0;
	int currPos = 0;
	int localPost = 0;
	int idx = 0;

	char[] arr = null;

	public StringIterator(String compressedString) {
		if (compressedString != null) {
			arr = compressedString.toCharArray();
			length = arr.length;
			currPos = 0;
		}
	}

	public char next() {
		if (!hasNext()) {
			return ' ';
		}

		char res = arr[currPos];

		int idx = 1;
		int count = 0;

		while (currPos + idx < length && Character.isDigit(arr[currPos + idx])) {
			count = 10 * count + arr[currPos + idx] - '0';
			idx++;
		}

		if (localPost < count) {
			localPost += 1;
			if (localPost == count) {
				currPos += idx;
				localPost = 0;
			}
			return res;
		} else {
			currPos += idx;
			localPost = 0;
			return this.next();
		}
	}

	public boolean hasNext() {
		// System.out.println("curr = " + currPos);
		if (arr == null || currPos >= length) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		StringIterator iterator = new StringIterator("Q2s4n8V18");

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// iterator.next(); // return 'L'
		// iterator.next(); // return 'e'
		// iterator.next(); // return 'e'
		// iterator.next(); // return 't'
		// iterator.next(); // return 'C'
		// iterator.next(); // return 'o'
		// iterator.next(); // return 'd'
		// iterator.hasNext(); // return true
		// iterator.next(); // return 'e'
		// System.out.println(iterator.hasNext()); // return false
		// iterator.next(); // return ' '
	}
}
