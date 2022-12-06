class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int m = targetSeconds / 60;
        int s = targetSeconds % 60;
        int one = find(startAt, moveCost, pushCost, m, s);
        int two = find(startAt, moveCost, pushCost, m - 1, s + 60);
        if (s >= 40 || m == 0) return one;
        if (m >  99) return two;
        return Math.min(one, two);
    }

    private int find(int i, int c, int p, int m, int s){
        int ans = 0;
        int[] data = new int[]{0, i};
        ans += each(c, p, m / 10, data);
        ans += each(c, p, m % 10, data);
        ans += each(c, p, s / 10, data);
        ans += each(c, p, s % 10, data);
        return ans;
    }

    private int each(int c, int p, int key, int[] data){
        data[0] += key;
        if (data[0] == 0) return 0;
        int ans = (data[1] == key? p : p + c);
        data[1] = key;
        return ans;
    }
}
