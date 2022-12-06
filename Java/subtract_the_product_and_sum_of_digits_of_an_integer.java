class Solution {
    public int subtractProductAndSum(int n) {
        int p = 1;
        int sum = 0;
        while(n != 0){
            int di = n % 10;
            p *= di;
            sum += di;
            n /= 10;
        }

        return p - sum;
    }
}
