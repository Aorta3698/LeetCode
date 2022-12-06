class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] r : roads){
            map.computeIfAbsent(r[0], o -> new HashSet<>()).add(r[1]);
            map.computeIfAbsent(r[1], o -> new HashSet<>()).add(r[0]);
        }

        int max = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++){
                int numOfRoads = map.getOrDefault(i, new HashSet<>()).size()
                    + map.getOrDefault(j, new HashSet<>()).size();
                if (map.containsKey(i) && map.get(i).contains(j)) numOfRoads--;
                max = Math.max(numOfRoads, max);
            }

        return max;
    }
}
