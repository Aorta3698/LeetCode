class Solution {
    public int countPrimes(int n) {
        boolean[] table = new boolean[n];
        for (int i = 2; i * i < n; i++){
            for (int j = i + i; j < n && !table[i]; j += i){
                table[j] = true;
            }
        }
        int ans = 0;
        for (int i = 2; i < n; i++){
            if (!table[i]){
                ans++;
            }
        }
        return ans;
    }
}
