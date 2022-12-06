https://leetcode.com/problems/largest-color-value-in-a-directed-graph/discuss/2188721/Java-O(26N)-Top-sort
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] map = new ArrayList[n];
        Arrays.setAll(map, o -> new ArrayList<>());
        int[] indg = new int[n];
        for (int[] e : edges){
            map[e[0]].add(e[1]);
            indg[e[1]]++;
        }
        int[][] memo = new int[n][26];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            if (indg[i] == 0){
                memo[i][colors.charAt(i)-'a']++;
                queue.offer(i);
            }
        }

        int ans = 0;
        while(!queue.isEmpty()){
            --n;
            int cur = queue.poll();
            if (map[cur].size()==0){
                ans = Math.max(ans, Arrays.stream(memo[cur]).max().getAsInt());
            }
            for (int next : map[cur]){
                for (int i = 0; i < 26; i++){
                    memo[next][i] = Math.max(memo[next][i], memo[cur][i] + (i == colors.charAt(next)-'a'? 1 : 0));
                }
                if (--indg[next]==0){
                    queue.offer(next);
                }
            }
        }
        return n==0?ans:-1;
    }
}
