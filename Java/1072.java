class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int[] m : matrix){
            StringBuilder one = new StringBuilder();
            StringBuilder two = new StringBuilder();
            for (int n : m){
                one.append(n);
                two.append(1 - n);
            }
            ans = Math.max(map.merge(one.toString(), 1, Integer::sum), ans);
            ans = Math.max(map.merge(two.toString(), 1, Integer::sum), ans);
        }

        return ans;
    }
}
// [0,0,0]
// [0,0,1]
// [1,1,0]
