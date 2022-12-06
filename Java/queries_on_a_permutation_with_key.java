class Solution {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> perm = new LinkedList<>();
        for (int i = 1; i <=m ; i++) perm.add(i);
        int[] ans = new int[queries.length];
        int idx = 0;
        for (Integer query : queries){
            ans[idx++] = perm.indexOf(query);
            perm.remove(query);
            perm.addFirst(query);
        }

        return ans;
    }
}
