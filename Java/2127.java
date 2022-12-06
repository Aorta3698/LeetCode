https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/discuss/2193064/2-options-as-the-Hints-say-or-java
class Solution {
    public int maximumInvitations(int[] fav) {
        int n = fav.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] mutual = new boolean[n];
        for (int i = 0; i < n; i++){
            mutual[i] = fav[fav[i]] == i;
            map.computeIfAbsent(fav[i], o -> new ArrayList<>()).add(i);
        }

        int[] seen = new int[n];
        int optionA = 0;
        for (int i = 0; i < n; i++){
            if (mutual[i]){
                optionA += chainLen(i, mutual, seen, map);
            }
        }

        int optionB = 0;
        for (int i = 0; i < n; i++){
            optionB = Math.max(optionB, cycleLen(i, i+2, seen, map));
        }

        return Math.max(optionA, optionB);
    }

    private int chainLen(int idx, boolean[] mutual, int[] seen, Map<Integer, List<Integer>> map){
        seen[idx]=1;
        int ans = 0;
        for (int next : map.getOrDefault(idx, List.of())){
            if (!mutual[next]){
                ans = Math.max(chainLen(next, mutual, seen, map), ans);
            }
        }
        return ans+1;
    }

    private int cycleLen(int idx, int visited, int[] seen, Map<Integer, List<Integer>> map){
        if (seen[idx]==visited)
            return 0;
        if (seen[idx] > 0)
            return -1000000;
        int ans = -1000000;
        seen[idx]=visited;
        for (int next : map.getOrDefault(idx, List.of())){
            ans = Math.max(ans, cycleLen(next, visited, seen, map));
        }
        return ans+1;
    }
}
