https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/discuss/1655469/Java-Simple-Solution-With-Comments
class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while(a > 0 || b > 0 || c > 0){
            if ((c & 1) == 1 && ((a | b) & 1) == 0) ans++;
            if ((c & 1) == 0) ans += (a & 1) + (b & 1);
            a >>= 1; b >>= 1; c >>= 1;
        }

        return ans;
    }
}
