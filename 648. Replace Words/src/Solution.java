import java.util.ArrayList;
import java.util.List;

public class Solution {
	public String replaceWords(List<String> dict, String sentence) {
		if (sentence == null || sentence.length() == 0) {
			return sentence;
		}

		String[] split = sentence.split("\\s+");
		for (int i = 0; i < split.length; i++) {
			for (int j = 0; j < dict.size(); j++) {
				if (split[i].startsWith(dict.get(j))) {
					split[i] = dict.get(j);
				}
			}
		}
		return String.join(" ", split);
		
	}
	
	public static void main(String[] args) {
		List<String> dict = new ArrayList<String>();
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
		dict.add("ca");
		System.out.println(new Solution().replaceWords(dict, "the cattle was rattled by the battery"));
	}
}