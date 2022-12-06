class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++){
            map.computeIfAbsent(manager[i], o -> new ArrayList<>()).add(i);
        }
        return dfs(headID, informTime, map, 0);
    }
    private int dfs(int cur, int[] time, Map<Integer, List<Integer>> map, int sum){
        if (!map.containsKey(cur)) return sum;
        int max = 0;
        for (int next : map.get(cur)){
            max = Math.max(dfs(next, time, map, sum + time[cur]), max);
        }
        return max;
    }
}
