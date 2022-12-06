class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length, m = intervals.length;
        int[] st =  IntStream.range(0, m).boxed().sorted(Comparator.comparingInt(o -> intervals[o][0])).mapToInt(o->o).toArray();
        int[] end = IntStream.range(0, m).boxed().sorted(Comparator.comparingInt(o -> intervals[o][1])).mapToInt(o->o).toArray();
        int[] idx = IntStream.range(0, n).boxed().sorted(Comparator.comparingInt(o -> queries[o])).mapToInt(o->o).toArray();
        int[] ans = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0, j = 0, k = 0; i < n; i++){
            while(j < m && intervals[st[j]][0] <= queries[idx[i]]){
                map.merge(intervals[st[j]][1]-intervals[st[j]][0]+1, 1, Integer::sum);
                ++j;
            }
            while(k < m && intervals[end[k]][1] < queries[idx[i]]){
                if (map.merge(intervals[end[k]][1]-intervals[end[k]][0]+1, -1, Integer::sum) == 0){
                    map.remove(intervals[end[k]][1]-intervals[end[k]][0]+1);
                }
                ++k;
            }
            ans[idx[i]]=map.isEmpty()? -1 : map.firstKey();
        }
        return ans;
    }
}
