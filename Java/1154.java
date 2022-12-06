class Solution {
    public int dayOfYear(String date) {
        int[] prefix = new int[]{0, 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 2; i <= 13; i++) prefix[i] += prefix[i - 1];
        int y = Integer.parseInt(date.split("-")[0]);
        int m = Integer.parseInt(date.split("-")[1]);
        int d = Integer.parseInt(date.split("-")[2]);

        int ans = prefix[m] + d;
        if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0) && m >= 3) ans++;

        return ans;
    }
}
