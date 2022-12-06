class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int[] idx = IntStream.range(0, n).boxed().sorted(Comparator.comparingInt(o -> -queries[o][1])).mapToInt(o->o).toArray();
        Arrays.sort(rooms, Comparator.comparingInt(o -> -o[1]));
        TreeSet<Integer> id = new TreeSet<>();
        for (int i = 0, j = 0; i < n; i++){
            int k = idx[i], love = queries[k][0], sz = queries[k][1];
            while(j < rooms.length && rooms[j][1] >= sz){
                id.add(rooms[j++][0]);
            }
            Integer R = id.ceiling(love);
            Integer L = id.floor(love);
            if (R == null && L == null){
                ans[k] = -1;
            }else{
                ans[k] = R == null || L != null && love-L <= R-love? L : R;
            }
        }
        return ans;
    }
}
