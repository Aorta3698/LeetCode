class Solution {
    public int edgeScore(int[] edges) {
        long[] s = new long[edges.length];
        for (int i = 0; i < edges.length; i++){
            s[edges[i]]+=i;
        }
        long max = 0;
        for (lonclass Solution {
    public String smallestNumber(String pattern) {
        
    }
}g n : s){
            max = Math.max(max, n);
        }
        int ans = 0;
        for (int i = 0; i < s.length; i++){
            if (s[i]>s[ans]){
                ans=i;
            }
        }
        return ans;
    }
}
