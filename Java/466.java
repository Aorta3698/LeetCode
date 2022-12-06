class Solution {
    public int getMaxRepetitions(String A, int a, String B, int b) {
        int m = A.length(), n = B.length();
        int[][] x = new int[m][n];
        int[][] y = new int[m][n];
        for (int i = 1, j = 1; true; i++){
            int ii = i%m, jj = j%n, xx = x[ii][jj], yy = y[ii][jj];
            x[ii][jj]=i;
            y[ii][jj]=j;
            if (xx > 0){
                int k = (a*m-i)/(i-xx);
                i += k*(i-xx);
                j += k*(j-yy);
            }
            if (i == a*m){
                return j/(n*b);
            }
            if (A.charAt(ii)==B.charAt(jj)){
                j++;
            }
        }
    }
}
