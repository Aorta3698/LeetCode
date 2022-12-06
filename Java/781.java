https://leetcode.com/problems/rabbits-in-forest/discuss/1859431/Java-or-1-for-loop-or-3-cases
class Solution {
    public int numRabbits(int[] answers) {
        int ans = 0;
        int[] count = new int[1001];
        for (int n : answers){
            if (++count[n] == 1) ans += n;
            else if (count[n] <= n + 1) ans--;
            else{
                ans += n;
                count[n] = 1;
            }
        }

        return ans + answers.length;
    }
}
