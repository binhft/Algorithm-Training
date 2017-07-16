import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
	public int[] exclusiveTime(int n, List<String> logs) {
		if (logs == null || logs.size() == 0) {
			return new int[] {};
		}
		int[] res = new int[n];
		int preTime = 0, running = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (String log : logs) {
			String[] part = log.split(":");
			int pid = Integer.parseInt(part[0]);
			int time = Integer.parseInt(part[2]);
			boolean isStart = (part[1].equals("start"));

			if (!isStart) {
				time++;
			}
			res[running] += (time - preTime);
			if (isStart) {
				stack.add(running);
				running = pid;
			} else {
				running = stack.pop();
			}
			preTime = time;
		}
		return res;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("0:start:0");
		list.add("0:start:2");
		list.add("0:end:5");
		list.add("0:start:6");
		list.add("0:end:6");
		list.add("0:end:7");
		// list.add("0:start:0");
		// list.add("1:start:2");
		// list.add("1:end:5");
		// list.add("0:end:6");

		int[] res = new Solution().exclusiveTime(1, list);
		System.out.println(Arrays.toString(res));
	}
}
