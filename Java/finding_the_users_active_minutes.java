class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        HashMap<Integer, HashSet<Integer>> users = new HashMap<>();
        for (int[] log : logs)
            users.computeIfAbsent(log[0], o -> new HashSet<>()).add(log[1]);

        for (HashSet user : users.values())
            ans[user.size() - 1]++;

        return ans;
    }
}
