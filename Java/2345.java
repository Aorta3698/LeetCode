class Solution {
    public int visibleMountains(int[][] peaks) {
        Integer[] st = IntStream.range(0, peaks.length).boxed().toArray(Integer[]::new);
        Integer[] end= IntStream.range(0, peaks.length).boxed().toArray(Integer[]::new);
        Arrays.sort(st, Comparator.<Integer>comparingInt(o -> peaks[o][0]-peaks[o][1]).thenComparingInt(o -> -peaks[o][1]));
        Arrays.sort(end, Comparator.<Integer>comparingInt(o -> peaks[o][0]+peaks[o][1]).thenComparingInt(o -> peaks[o][1]));
        boolean[] dup = new boolean[peaks.length];
        for (int i = 1 ; i < st.length; i++){
            if (Arrays.equals(peaks[st[i]], peaks[st[i-1]])){
                dup[st[i]]=dup[st[i-1]]=true;
            }
        }
        int ans = 0;
        for (int i = 0, j = 0; i < end.length; i++){
            while(peaks[st[j]]==null){
                ++j;
            }
            if (0+end[i]==st[j] && !dup[end[i]]){
                ans++;
            }
            peaks[end[i]]=null;
        }
        return ans;
    }
}
