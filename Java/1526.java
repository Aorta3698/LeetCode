class Solution {
    public int minNumberOperations(int[] A) {
        int ans = 0;
        for (int i = 1; i <A.length;i++){
            ans += Math.max(0, A[i]-A[i-1]);
        }
        return ans+A[0];
    }
}
