class Solution {
    public int xorOperation(int n, int start) {
        int idx = 0;
        int ans = start;
        while(++idx<n)
            ans^=(start+2*idx);
        return ans;
    }
}
