class Solution {
    public int numSquarefulPerms(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.merge(n, 1, Integer::sum);
        }
        return solve(nums.length-1, -1, map);
    }

    private int solve(int idx, int prev, Map<Integer, Integer> map){
        if (idx==-1){
            return 1;
        }
        int ans = 0;
        for (int key : map.keySet()){
            if (map.get(key)>0 && ok(prev, key)){
                map.merge(key, -1, Integer::sum);
                ans += solve(idx-1, key, map);
                map.merge(key, 1, Integer::sum);
            }
        }
        return ans;
    }

    private boolean ok(int a, int b){
        if(a==-1){
            return true;
        }
        int c = (int)Math.sqrt(a+b);
        return a+b==c*c;
    }
}
