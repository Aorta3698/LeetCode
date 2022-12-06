class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int n : nums){
            if (map.containsKey(k - n)){
                ans++;
                if (map.merge(k - n, -1, Integer::sum) == 0){
                    map.remove(k - n);
                }
            }else{
                map.merge(n, 1, Integer::sum);
            }
        }

        return ans;
    }
}
