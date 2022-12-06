class Solution {
    public int countDigitOne(int n) {
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
            int d = n % 10, adj = (int)Math.pow(10, len);
            if (d > 0) ans += d * data[len] + (d > 1? adj : copy - n * adj + 1);
            len++;
            n /= 10;
        }

        return ans;
    }
}
