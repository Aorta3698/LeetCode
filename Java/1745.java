class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] ok = new boolean[n][n];
        for (int i = n-1 ; i>=0; i--){
            for (int j = i;  j<n; j++){
                if (i==j||s.charAt(i)==s.charAt(j)&&(j-i==1||ok[i+1][j-1])){
                    ok[i][j]=true;
                }
            }
        }
        for (int i = 1; i < n-1; i++){
            for (int j = i; j <n-1; j++){
                if (ok[0][i-1]&&ok[i][j]&&ok[j+1][n-1]){
                    return true;
                }
            }
        }
        return false;
    }
}
