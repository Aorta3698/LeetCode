class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer, HashSet<Integer>> richMap = new HashMap<>();
        for (int[] r : richer){
            richMap.putIfAbsent(r[1], new HashSet<>());
            richMap.get(r[1]).add(r[0]);
        }

        int[] ans = new int[quiet.length];
        for (int i = 0; i < ans.length; i++)
            ans[i] = dfs(i, quiet, richMap, new HashMap<>());

        return ans;
    }

    private int dfs(int person, int[] quiet, HashMap<Integer, HashSet<Integer>> map,
            HashMap<Integer, Integer> cache){
        if (map.get(person) == null) return person;
        if (cache.containsKey(person)) return cache.get(person);

        int min = quiet[person];
        int ans = person;
        for (int p : map.get(person)){
            int qNei = dfs(p, quiet, map, cache);
            if (quiet[qNei] < min){
                min = quiet[qNei];
                ans = qNei;
            }
        }

        cache.put(person, ans);
        return ans;
    }
}
