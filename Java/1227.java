//DECENT PROOF:
https://leetcode.com/problems/airplane-seat-assignment-probability/discuss/411905/It's-not-obvious-to-me-at-all.-Foolproof-explanation-here!!!-And-proof-for-why-it's-12
class Solution {
    public double nthPersonGetsNthSeat(int n) {
        return n > 1? 0.5 : 1;
    }
}

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if (n == 1) return 1;
        double sum = 0;
        for (int i = 1; i < n; i++)
            sum += nthPersonGetsNthSeat(i);
        return sum / n;
    }
}
