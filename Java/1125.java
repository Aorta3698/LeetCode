https://leetcode.com/problems/smallest-sufficient-team/discuss/2261010/Java-or-DP-or-from-2000ms-to-28ms
class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int N = 1 << req_skills.length, INF = (int)1e9;
        int[] parent = new int[N];
        int[] who = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String s : req_skills){
            map.put(s, map.size());
        }
        int[] skills = new int[people.size()];
        for (int i = 0; i < people.size(); i++){
            for (String s : people.get(i)){
                if (map.containsKey(s)){
                    skills[i]|=1<<map.get(s);
                }
            }
        }
        for (int i = 0; i < N; i++){
            for (int k = 0; k < people.size() && dp[i]!=INF; k++){
                int cur = i|skills[k];
                if (dp[cur]>dp[i]+1){
                    dp[cur]=dp[i]+1;
                    parent[cur]=i;
                    who[cur]=k;
                }
            }
        }
        int[] ans = new int[dp[N-1]];
        for (int i = 0,cur=N-1; i < ans.length; i++){
            ans[i]=who[cur];
            cur=parent[cur];
        }
        return ans;
    }
}
