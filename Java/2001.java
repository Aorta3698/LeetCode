https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/discuss/1871410/GCD-and-Long-Java
class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long ans = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int[] re : rectangles){
            int d = gcd(re[0], re[1]);
            long x = 1L * re[0] / d, y = 1L * re[1] / d;
            long key = x * 100001L + y;
            map.merge(key, 1, Integer::sum);
            ans += Math.max(0, map.get(key) - 1);
        }

        return ans;
    }

    private int gcd(int a, int b){
        return b == 0? a : gcd(b, a % b);
    }
}
