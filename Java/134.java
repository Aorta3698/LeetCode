class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0, cnt = 0, n = gas.length;
        for (int i = 0, j = 0; i < n * 2; j = ++i % n){
            curSum += gas[j] - cost[j];
            if (curSum < 0){
                curSum = 0;
                cnt = -1;
            }
            if (++cnt == n) return (j + 1) % n;
        }

        return -1;
    }
}
