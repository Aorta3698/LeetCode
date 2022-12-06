class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        for (int[] num : nums){
            for (int n : num){
                count[n]++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < count.length; i++){
            if (count[i] == nums.length)
                ans.add(i);
        }
        return ans;
    }
}
