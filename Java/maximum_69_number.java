class Solution {
    public int maximum69Number (int num) {
        int len = (int)Math.log10(num);
        int copy = num;
        while(copy > 0){
            int n = (int)Math.pow(10, len--);
            int d = copy / n;
            if (d == 6) return num + 3 * n;
            copy %= n;
        }

        return num;
    }
}
