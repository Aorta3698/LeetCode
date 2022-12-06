class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0) return n == 1? 1 : -1;
        int[] indeg = new int[n+1];
        int[] outdeg = new int[n+1];
        for (int[] t : trust){
            indeg[t[1]]++;
            outdeg[t[0]]++;
        }

        for (int i = 0; i < indeg.length; i++){
            if (indeg[i] == n - 1){
                return outdeg[i] == 0? i : -1;
            }
        }

        return -1;
    }
}
