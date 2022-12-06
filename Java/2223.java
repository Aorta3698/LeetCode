class Solution {
    public long sumScores(String s) {
        int n = s.length();
        int[] z = new int[n];
        for (int i = 1, r = 0, l = 0; i < n; i++){
            if (i <= r){
                z[i] = Math.min(z[i-l], r-i+1);
            }
            while(i+z[i]<n && s.charAt(i+z[i]) == s.charAt(z[i])){
                ++z[i];
            }
            if (i+z[i]-1 > r){
                l = i;
                r = i+z[i]-1;
            }
        }
        return Arrays.stream(z).asLongStream().sum() + n;
    }
}
