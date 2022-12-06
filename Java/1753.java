https://leetcode.com/problems/maximum-score-from-removing-stones/discuss/1655496/Java-or-Logic-O(1)-or-Thinking-Process
class Solution {
    public int maximumScore(int a, int b, int c) {
        if (a > b) return maximumScore(b, a, c);
        if (a > c) return maximumScore(c, b, a);
        if (b > c) return maximumScore(a, c, b);
        return (a + b + Math.min(a + b, c)) / 2;
    }
}
