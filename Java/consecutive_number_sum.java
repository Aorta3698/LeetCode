https://leetcode.com/problems/consecutive-numbers-sum/discuss/1614074/Java-or-Prime-Deposition-0ms-or-Detailed-Explanations

class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 1;
        for (int prime = 2; n >= prime * prime; prime++){
            if (n % prime != 0) continue;
            if (prime % 2 == 0){n /= prime--; continue;}

            int count = 1;
            while(n % prime == 0){
                count++;
                n /= prime;
            }
            ans *= count;
        }

        return n % 2 == 1 && n != 1? 2*ans : ans;
    }
}
