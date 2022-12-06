class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long ans = 0;
        for (int n : tasks){
            map.put(n, Math.max(ans, map.getOrDefault(n, -1L*space)+space)+1);
            ans = map.get(n);
        }
        return ans;
    }
}
