class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int N = (int)2e4+1, ans = 0;
        int[] used = new int[N];
        List<Integer>[] val  = new ArrayList[N];
        for (int i = 0; i < N; i++) val[i] = new ArrayList<>();
        for (int i = 0; i < values.length; i++){
            val[values[i]].add(labels[i]);
        }
        for (int i = N - 1; i >= 0 && numWanted > 0; i--){
            for (int label : val[i]){
                if (used[label] == useLimit) continue;
                used[label]++;
                ans += i;
                if (--numWanted == 0) break;
            }
        }
        return ans;
    }
}
