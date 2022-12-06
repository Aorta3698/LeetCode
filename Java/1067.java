class Solution {
    public int digitsCount(int d, int low, int high) {
        if (d == 0) return (int)(zero(high) - zero(low - 1));
        return count(high, d) - count(low - 1, d);
    }

    private int count(int n, int d){
        int[] data = new int[10];
        for (int i = 1, pre = 0; i < data.length; i++){
            pre += data[i - 1];
            data[i] = 9 * pre + (int)Math.pow(10, i - 1);
        }
        for (int i = 1; i < data.length; i++){
            data[i] += data[i - 1];
        }

        int ans = 0, len = 0, copy = n;
        while(n > 0){
            int m = n % 10, adj = (int)Math.pow(10, len);
            ans += m * data[len] + (m > d? adj : (m == d? copy - n * adj + 1 : 0));
            len++;
            n /= 10;
        }

        return ans;
    }

    private long zero(long n){
        long ans = 0, low = 1;
        for (int i = 1; i < 10; i++)
            ans -= count((int)n, i);

        while(low*10 <= n) low *= 10;
        while(n > 0){
            long t = n - low + 1;
            ans += t * ((long)Math.log10(low) + 1);
            n = low - 1;
            low /= 10;
        }


        return ans;
    }
}
