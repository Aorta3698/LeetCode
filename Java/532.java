class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int ans = 0;

        for (int n : nums){
            if (map.putIfAbsent(n, new HashSet<>()) == null && k == 0){
                continue;
            }
            ans += ok(map, n, n - k);
            ans += ok(map, n, n + k);
        }

        return ans;
    }

    private int ok(Map<Integer, Set<Integer>> map, int n, int m){
        Set<Integer> set = map.get(n);
        int ans = 0;

        if (map.containsKey(m) && !set.contains(n + m)){
            set.add(n + m);
            map.get(m).add(n + m);
            ans = 1;
        }

        return ans;
    }
}
