class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        for (int i = 0; i < brackets.length && income > 0; i++){
            int take = Math.min(i == 0? brackets[i][0] : brackets[i][0]-brackets[i-1][0], income);
            income -= take;
            ans += 1d * take * brackets[i][1]/100;
        }
        return ans;
    }
}
