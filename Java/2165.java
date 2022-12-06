class Solution {
    public long smallestNumber(long num) {
        int[] count = new int[10];
        int sign = num < 0? -1 : 1, min = 10;
        num = Math.abs(num);
        while(num > 0){
            int d = (int)(num % 10L);
            if (d > 0) min = Math.min(d, min);
            count[d]++;
            num /= 10L;
        }

        long ans = 0;
        if (sign > 0 && count[0] > 0 && min < 10){
            ans += min;
            count[min]--;
        }

        for (int i = sign > 0? 0 : 9; i >= 0 && i <= 9; i += sign){
            while(--count[i] >= 0){
                ans *= 10;
                ans += i;
            }
        }

        return ans * sign;
    }
}
