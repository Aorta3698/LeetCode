class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        int ans = 0;
        for (int i = lowLimit; i <= highLimit; i++)
            ans = Math.max(ans, ++count[getSum(i)]);

        return ans;
    }

    private static int getSum(int n){
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
