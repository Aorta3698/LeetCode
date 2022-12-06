class Solution {
    public int mostFrequent(int[] nums, int key) {
        int[] count = new int[1001];
        int prev = key - 1, ans = 0;

        for (int n : nums){
            if (prev == key && ++count[n] > count[ans]){
                ans = n;
            }
            prev = n;
        }

        return ans;
    }
}
