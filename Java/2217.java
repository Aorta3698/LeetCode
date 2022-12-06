https://leetcode.com/problems/find-palindrome-with-fixed-length/discuss/2012193/Java-Concise-Solution-Explained!
class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] ans = new long[queries.length];
        long sz = (long)Math.pow(10, (intLength-1)/2);
        for (int i = 0; i < queries.length; i++){
            if (queries[i] > 9 * sz){
                ans[i] = -1;
            }else{
                long front = sz + queries[i]-1;
                StringBuilder back = new StringBuilder(""+front);
                ans[i] = Long.parseLong(front+back.reverse().toString().substring(intLength % 2));
            }
        }
        return ans;
    }
}
