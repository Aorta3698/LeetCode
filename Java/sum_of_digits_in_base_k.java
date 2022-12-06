class Solution {
    public int sumBase(int n, int k) {
        int count = 0;
        int sum = 0;
        while(n >= Math.pow(k, count+1))count++;
        while(n > 0){
            int base = (int)Math.pow(k, count--);
            int d = n / base;
            sum += d;
            n -= d * base;
        }

        return sum;
    }
}
