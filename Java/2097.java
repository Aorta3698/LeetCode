https://leetcode.com/problems/valid-arrangement-of-pairs/discuss/1723140/java-hierholzers-algo-recursive-85
class Solution {
    public int[][] validArrangement(int[][] pairs) {
        int n = pairs.length, start = pairs[0][0];
        int[][] ans = new int[n][2];
        Map<Integer, Integer> in = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : pairs){
            in. merge(p[1], 1, Integer::sum);
            out.merge(p[0], 1, Integer::sum);
            map.computeIfAbsent(p[0], o -> new ArrayList<>()).add(p[1]);
        }

        for (int[] p : pairs){
            int o = out.getOrDefault(p[0], 0);
            int i = in .getOrDefault(p[0], 0);
            if (o - i == 1){
                start = p[0];
                break;
            }
        }

        findPath(pairs, map, start, ans, n);

        return ans;
    }

    private int findPath(int[][] pairs, Map<Integer, List<Integer>> map, int cur, int[][] ans, int n){
        List<Integer> list = map.getOrDefault(cur, Collections.emptyList());

        while (!list.isEmpty()){
            int next = list.remove(list.size() - 1);
            n = findPath(pairs, map, next, ans, n);
            ans[--n] = new int[]{cur, next};
        }

        return n;
    }
}
