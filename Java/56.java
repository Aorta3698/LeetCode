class Solution {
    public int[][] merge(int[][] o) {
        Arrays.sort(o, Comparator.comparingInt(t -> t[0]));
        List<int[]> ans = new ArrayList<>();
        int i = 0, n = o.length;
        while(i < o.length){
            int start = o[i][0], end = o[i][1];
            while (i < n - 1 && end >= o[i + 1][0]) end = Math.max(o[++i][1], end);
            ans.add(new int[]{start, end});
            i++;
        }

        return ans.toArray(new int[0][]);
    }
}
