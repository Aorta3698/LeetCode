https://leetcode.com/problems/mirror-reflection/discuss/2376378/Java-or-GCD-and-LCM
class Solution {
    public int mirrorReflection(int p, int q) {
        int lcm = p*q/gcd(p, q);
        int d = lcm/q;
        if (d % 2 == 0){
            return 2;
        }else{
            return lcm/p%2;
        }
    }

    private int gcd(int a, int b){
        return a == 0? b : gcd(b%a, a);
    }
}
