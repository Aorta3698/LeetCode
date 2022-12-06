class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] ans = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] m = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i <= 12; i++) m[i] += m[i - 1];
        int d = (year - 1971) * 365 + m[month - 1] + day - 3;
        d += (year - 1968) / 4;
        if (year % 4 == 0 && month < 3) d--;
        else if (year == 2100) d--;

        return ans[((d % 7) + 7) % 7];
    }
}
