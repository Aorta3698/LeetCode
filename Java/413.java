https://leetcode.com/problems/arithmetic-slices/discuss/1814365/Java-or-O(1)-Space-or-Sliding-Window-or-5-Lines-0ms
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int ans = 0;
        for (int i = 1, j = 0; i < A.length; i++){
            while(j < i && A[i] - A[j] != (A[i] - A[i - 1]) * (i - j)){
                j++;
            }
            ans += (i - j - 1);
        }
        return ans;
    }
}
