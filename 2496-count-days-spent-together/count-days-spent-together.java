class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {
        int[] yarr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[] days = yarr.clone();
        Arrays.parallelPrefix(days, Integer::sum);

        int a1 = getDay(arriveAlice, days);
        int a2 = getDay(leaveAlice, days);
        int b1 = getDay(arriveBob, days);
        int b2 = getDay(leaveBob, days);

        int start = Math.max(a1, b1);
        int end = Math.min(a2, b2);

        return Math.max(0, end - start + 1);
    }

    private int getDay(String date, int[] days) {
        String[] parts = date.split("-");
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);

        return (month == 1 ? 0 : days[month - 2]) + day;
    }
}