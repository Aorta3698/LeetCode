class Solution {
    public int findKthNumber(int n, int k) {
        int ans = 1;
        while(k > 1){
            long a=ans, b=ans+1, cnt = 0;
            while(a <= n){
                cnt += n > b? b-a : 1+n-a;
                a *= 10;
                b *= 10;
            }
            if (cnt < k){
                ans++;
                k -= cnt;
            }else{
                k--;
                ans*=10;
            }
        }
        return ans;
    }
}
