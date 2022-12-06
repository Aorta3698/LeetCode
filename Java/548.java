https://leetcode.com/problems/split-array-with-equal-sum/discuss/2348701/Java-or-Middle-Cut-and-Precompute-w-HashMap
class Solution {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        Map<Integer, Set<Integer>> b = new HashMap<>();
        Map<Integer, Set<Integer>> a = new HashMap<>();
        for (int i = 0; i < n; i++){
            pre[i] = i == 0? nums[i] : pre[i-1] + nums[i];
        }
        for (int i = 5; i < n-1; i++){
            b.computeIfAbsent(pre[n-1]-pre[i], o -> new HashSet<>()).add(i);
        }
        for (int i = 3; i < n-3; i++){
            a.computeIfAbsent(pre[i-3], o -> new HashSet<>()).add(i-2);
            for (int key : a.keySet()){
                if (b.containsKey(key)){
                    for (int l : a.get(key)){
                        if (pre[i-1]-pre[l] == key){
                            for (int r : b.get(key)){
                                if (pre[r-1]-pre[i] == key){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            b.get(pre[n-1]-pre[i+2]).remove(i+2);
        }
        return false;
    }
}
