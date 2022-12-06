class Solution {
    public int minimumSum(int num) {
        int[] cnt = new int[10];
        while (num > 0){
            cnt[num % 10]++;
            num /= 10;
        }
        int t = 0, ans = 0;
        for (int i = 0; i < 10; i++){
            while(--cnt[i] >= 0){
                if (++t <= 2) ans += 10 * i;
                else ans += i;
            }
        }

        return ans;
    }
}
