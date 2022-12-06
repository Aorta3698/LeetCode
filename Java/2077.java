class Solution {
    public int numberOfPaths(int n, int[][] corridors) {
        int ans = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] c : corridors){
            map.computeIfAbsent(c[0], o -> new HashSet<>()).add(c[1]);
            map.computeIfAbsent(c[1], o -> new HashSet<>()).add(c[0]);
        }

        for (int i = 1; i <= n; i++){
            Set<Integer> cur = map.get(i);
            if (cur == null) continue;
            for (int j = i + 1; j <= n; j++){
                if (!cur.contains(j)) continue;
                for (int v : map.get(j)){
                    if (cur.contains(v)){
                        ans++;
                    }
                }
            }
        }
        return ans / 3;
    }
}
