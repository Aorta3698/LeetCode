class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        for (int i = 0; i <= n / 7; i++){
            int start = i + 1;
            for (int j = 0; j < Math.min(7, n-7*i); j++)
                sum+=(start+j);
        }

        return sum;
    }
}
