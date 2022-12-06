class Solution {
    public int maxValue(int[][] events, int k) {
        Integer[] idx = IntStream.range(0, events.length).boxed().toArray(Integer[]::new);
        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(idx, Comparator.comparingInt(o -> events[o][0]));
        int[] dp = new int[events.length];
        for (int i = 0; i < k; i++){
            int[] ndp = new int[events.length];
            for (int j = 0, c = 0, max = 0; j < events.length; j++){
                while(events[c][1]<events[idx[j]][0]){
                    max = Math.max(dp[c++], max);
                }
                ndp[idx[j]] = Math.max(events[idx[j]][2]+max, dp[idx[j]]);
            }
            dp=ndp;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
