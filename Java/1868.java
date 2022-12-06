class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = 0, n = encoded1.length, prev = encoded1[0][0] * encoded2[0][0], count = 0;
        while(i < n){
            int t = Math.min(encoded1[i][1], encoded2[j][1]);
            int v = encoded1[i][0] * encoded2[j][0];
            encoded1[i][1] -= t;
            encoded2[j][1] -= t;
            if (prev != v){
                ans.add(List.of(prev, count));
                prev = v;
                count = 0;
            }
            if (encoded1[i][1] == 0){
                ++i;
            }
            if (encoded2[j][1] == 0){
                ++j;
            }
            count += t;
        }
        ans.add(List.of(prev, count));

        return ans;
    }
}
