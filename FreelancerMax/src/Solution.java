import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class Solution {
	Date parseDate(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm ddMMyyyy");

		Date formatDate = new Date();
		try {
			formatDate = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatDate;
	}

	boolean isSameDay(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
				&& (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR));

		boolean isnextDay = false;
		if (cal2.get(Calendar.HOUR_OF_DAY) == 0 && cal2.get(Calendar.MINUTE) == 0) {
			if (cal1.getTimeInMillis() - cal2.getTimeInMillis() >= 12 * 3600 * 1000) {
				isnextDay = false;
			} else if (cal2.get(Calendar.DAY_OF_YEAR) == 1
					&& (cal2.get(Calendar.YEAR) == cal1.get(Calendar.YEAR) + 1)) {
				// new year
				isnextDay = true;
			} else if (cal1.get(Calendar.DAY_OF_YEAR) + 1 == cal2.get(Calendar.DAY_OF_YEAR)) {
				// next day in year
				isnextDay = true;
			}
		}
		boolean res = sameDay || isnextDay;

		return res;
	}

	@SuppressWarnings("deprecation")
	boolean isThroughNoon(Date startTime, Date endTime) {
		boolean res = (startTime.getHours() < 13 && endTime.getHours() > 12) || (startTime.getHours() == 12)
				|| (endTime.getHours() == 12 && endTime.getMinutes() > 0);
		if (endTime.getHours() == 0 && startTime.getHours() < 13) {
			return true;
		}
		return res;
	}

	class Job implements Comparable<Job> {
		Date startTime;
		Date endTime;

		int costPerHour;

		public Job(String startTime, String endTime, String money) {
			this.startTime = parseDate(startTime);
			this.endTime = parseDate(endTime);
			this.costPerHour = Integer.parseInt(money);
		}

		@SuppressWarnings("deprecation")
		boolean isValid() {
			boolean isOk = !isThroughNoon(this.startTime, this.endTime) && isSameDay(this.startTime, this.endTime)
					&& this.startTime.getHours() >= 8 && (this.endTime.getHours() >= 8
							|| (this.endTime.getHours() == 0 && this.endTime.getMinutes() == 0));
			return isOk;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Start: " + startTime.toString() + " End: " + endTime.toString();
		}

		@Override
		public int compareTo(Job o) {
			return this.endTime.compareTo(o.endTime);
		}

		int getCost() {
			long workMins = (this.endTime.getTime() - this.startTime.getTime()) / (60 * 1000);
//			System.out.println("Cost" + (int) workMins * costPerHour / 60);
//			System.out.println(workMins);
			return (int) (workMins * costPerHour / 60);
		}
	}

	int latestNonConflict(ArrayList<Job> jobs, int i) {
		for (int j = i - 1; j >= 0; j--) {
			if (jobs.get(j).endTime.getTime() <= jobs.get(i).startTime.getTime()) {
				return j;
			}
		}
		return -1;
	}

	int binarySearch(ArrayList<Job> jobs, int index) {
		// Initialize 'lo' and 'hi' for Binary Search
		int lo = 0, hi = index - 1;

		// Perform binary Search iteratively
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (jobs.get(mid).endTime.getTime() <= jobs.get(index).startTime.getTime()) {
				if (jobs.get(mid + 1).endTime.getTime() <= jobs.get(index).startTime.getTime())
					lo = mid + 1;
				else
					return mid;
			} else
				hi = mid - 1;
		}

		return -1;
	}

	int findMax(ArrayList<Job> jobs, int n) {
//		if (n == 1) {
//			return jobs.get(0).getCost();
//		}
//		int includeProfit = jobs.get(n - 1).getCost();
//		int i = latestNonConflict(jobs, n);
//		if (i != -1) {
////			System.out.println("Previous " + jobs.get(i+1));
//			includeProfit += findMax(jobs, i + 1);
//		}
//
//		int exclueProfit = findMax(jobs, n - 1);
////		System.out.println(jobs.get(n-1) + " " + includeProfit + " " + exclueProfit);
//		return Math.max(includeProfit, exclueProfit);
		int[] dp = new int[n];
		dp[0] = jobs.get(0).getCost();
		for (int i = 1; i < n; i++) {
			int includeProfit = jobs.get(i).getCost();
			int check = binarySearch(jobs, i);
			if (check != -1) {
//			System.out.println("Previous " + jobs.get(i+1));
				includeProfit += dp[check];
			}
			dp[i] = Math.max(includeProfit, dp[i - 1]);
		}
		return dp[n - 1];
	}

	int maximumEarning(String[][] taskList) {
		if (taskList == null || taskList.length == 0) {
			return 0;
		}
		ArrayList<Job> jobs = new ArrayList<Job>();
		for (int i = 0; i < taskList.length; i++) {
			Job job = new Job(taskList[i][0], taskList[i][1], taskList[i][2]);
			if (job.isValid()) {
				jobs.add(job);
			}
		}
		if (jobs.size() == 0) {
			return 0;
		}
		Collections.sort(jobs);
//		System.out.println(jobs);
//		System.out.println(jobs.size());
		return findMax(jobs, jobs.size());
	}

	public static void main(String[] args) {
		System.out.println(
				new Solution().maximumEarning(new String[][] { { "2300 24092018", "0000 25092018", "1000" } }));
//		System.out.println(new Solution().maximumEarning(
//				new String[][] { { "0800 24092018", "0900 24092018", "15" }, { "0800 24092018", "0900 24092018", "25" },
//						{ "0845 24092018", "1000 24092018", "50" }, { "0900 24092018", "1000 24092018", "50" },
//						{ "1200 24092018", "1230 24092018", "150" }, { "2300 24092018", "0015 25092018", "1000" } }));
//		System.out.println(new Solution().maximumEarning(new String[][] { { "0800 24092018", "0900 24092018", "15" },
//				{ "0800 24092018", "0900 24092018", "25" }, }));
//		System.out.println(new Solution().maximumEarning(
//				new String[][] { { "0800 24092018", "0900 24092018", "15" }, { "0800 24092018", "0900 24092018", "25" },
//						{ "0845 24092018", "1000 24092018", "50" }, { "0900 24092018", "1000 24092018", "50" },
//						{ "1200 24092018", "1230 24092018", "150" }, { "2300 24092018", "0015 25092018", "1000" },
//						{ "2300 24092018", "0015 25092018", "1000" }, { "2300 24092018", "2300 25092018", "1000" },
//						{ "0100 24092018", "0900 24092018", "1000" }, { "1200 24092018", "1300 24092018", "1000" },
//						{ "1100 24092018", "1200 24092018", "30" }, { "0800 24092018", "0900 24092018", "15" },
//						{ "0800 24092018", "0900 24092018", "25" }, { "0845 24092018", "1000 24092018", "50" },
//						{ "0900 24092018", "1000 24092018", "50" }, { "1200 24092018", "1230 24092018", "150" },
//						{ "2300 24092018", "0015 25092018", "1000" }, { "2300 24092018", "0015 25092018", "1000" },
//						{ "2300 24092018", "2300 25092018", "1000" }, { "0100 24092018", "0900 24092018", "1000" },
//						{ "1200 24092018", "1300 24092018", "1000" }, { "1100 24092018", "1200 24092018", "30" } }));
//		System.out.println(new Solution().maximumEarning(
//				new String[][] { { "0800 24092018", "0900 24092018", "15" }, { "0800 24092018", "0900 24092018", "25" },
//						{ "0845 24092018", "1000 24092018", "50" }, { "0900 24092018", "1000 24092018", "50" },
//						{ "1200 24092018", "1230 24092018", "150" }, { "2300 24092018", "0015 25092018", "1000" },
//						{ "2300 24092018", "0015 25092018", "1000" }, { "2300 24092018", "2300 25092018", "1000" },
//						{ "1100 24092018", "1200 24092018", "30" }, { "1115 24092018", "1145 24092018", "1000" },
//						{ "1115 24092018", "1200 26092018", "100" }, { "1115 24092018", "1200 27092018", "100" } }));
	}

}
