class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0, ans = 0;
        for (int i = 0; i < k; i++) sum += calories[i];
        if (sum < lower) ans--;
        if (sum > upper) ans++;
        for (int i = 0; i < calories.length - k; i++){
            sum += calories[i + k] - calories[i];
            if (sum < lower) ans--;
            if (sum > upper) ans++;
        }

        return ans;
    }
}
