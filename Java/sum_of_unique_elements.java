class Solution {
    public int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        int ans = 0;
        for (int n : nums)
            count[n]++;
        for (int i = 1; i < 101; i++)
            if (count[i] == 1)
                ans += i;

        return ans;
    }
}
