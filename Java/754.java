https://leetcode.com/problems/reach-a-number/discuss/1886268/Java-or-O(1)
class Solution {
    public int reachNumber(int target) {
        // 1 + 2 + ... + k = (k + 1) * k / 2 >= target
        // target = 1 + 2 + .. + n + y = (n + 1) * n / 2 + y
        // 2 * target = n * (n + 1) + 2y <= n * (n + 3) < (n + 2) ^ 2.
        // n <= sqrt(2*target) <= n + 1
        target = Math.abs(target);
        int k = (int)Math.sqrt(2*target);

        int sum = k * (k + 1);
        if (sum == 2*target){ // CASE ONE
            return k;
        }else if (sum < 2 * target){
            ++k;
        }

        int d = (k + 1) * k / 2 - target;
        if (d % 2 == 0){ // CASE TWO
            return k;
        }

        d += ++k; // CASE THREE AND FOUR
        return d % 2 == 0? k : k + 1;
    }
}
