class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        int[] cache = new int[100001];
        for (int n : nums){
            if (cache[n] != 0){
                ans += Math.max(0, cache[n]);
                continue;
            }
            int sum = 1 + n, count = 2;
            for (int i = 2; i * i <= n && count < 5; i++){
                if (n % i == 0){
                    sum += i;
                    count++;
                    if (i * i != n){
                        sum += n / i;
                        count++;
                    }
                }
            }
            cache[n] = count == 4? sum : -1;
            ans += Math.max(cache[n], 0);
        }
        return ans;
    }
}
