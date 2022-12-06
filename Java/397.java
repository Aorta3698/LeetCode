class Solution {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE)
            return 32;

        int ans = 0;
        while(n > 1){
            if (n % 2 == 0){
                ans++;
                n >>= 1;
            }else{
                if (n % 4 == 3 && n != 3){
                    ++n;
                }else{
                    --n;
                }
                ans++;
            }
        }
        return ans;
        // 1100001100
        // 1100010100
    }
}
