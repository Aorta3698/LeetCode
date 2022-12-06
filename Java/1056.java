https://leetcode.com/problems/confusing-number/discuss/2390061/Java-Short-Solution
class Solution {
    public boolean confusingNumber(int n) {
        int[] map = IntStream.range(0, 10).toArray();
        String b = "23457";
        map[6]=9;
        map[9]=6;
        long cur = 0, N = n;
        while(n > 0 && !b.contains(""+map[n%10])){
            cur *= 10;
            cur += map[n%10];
            n/=10;
        }
        return cur != N && n == 0;
    }
}
