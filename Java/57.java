class Solution {
    public int[][] insert(int[][] A, int[] B) {
        List<int[]> ans = new ArrayList<>();
        int[][] t = new int[A.length + 1][2];
        for (int i = 0, j = 0; i < t.length; i++){
            if (j == 0 && (i == t.length - 1 || B[0] <= A[i][0])){
                t[i] = B;
                j = 1;
            }else{
                t[i] = A[i - j];
            }
        }

        for (int i = 0; i < t.length; i++){
            int st = t[i][0];
            int ed = t[i][1];
            while(i < t.length - 1 && ed >= t[i + 1][0]){
                ed = Math.max(t[++i][1], ed);
            }

            ans.add(new int[]{st, ed});
        }
        return ans.toArray(new int[0][]);
    }
}
