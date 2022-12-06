class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> parentMap = new HashMap<>();
        for (int i = 0; i < pid.size(); i++)
            parentMap.computeIfAbsent(ppid.get(i), o -> new ArrayList<>()).add(pid.get(i));

        List<Integer> ans = new ArrayList<>();
        dfs(kill, parentMap, ans);

        return ans;
    }

    private void dfs(int start, Map<Integer, List<Integer>> map, List<Integer> ans){
        ans.add(start);
        for (int next : map.getOrDefault(start, Collections.emptyList()))
            dfs(next, map, ans);
    }
}
