class Solution {
    public int reverse(int x) {
        int ans = 0;
        int s = x < 0? -1 : 1;
        x = Math.abs(x);
        while(x > 0){
            if ((Integer.MIN_VALUE+x%10)/10 > ans)
                return 0;
            ans = 10 * ans - x % 10;
            x /= 10;
        }
        return s == 1 && ans == Integer.MIN_VALUE? 0 : ans * -s;
    }
}
