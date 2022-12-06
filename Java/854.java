class Solution {
    public int kSimilarity(String s1, String s2) {
        return solve(0, s1.toCharArray(), s2.toCharArray());
    }

    private int solve(int i, char[] A, char[] B){
        if (i==A.length){
            return 0;
        }
        if (A[i]==B[i]){
            return solve(i+1, A, B);
        }
        int ans = 1038;
        List<Integer> cand = new ArrayList<>();
        for (int j = 0; j < B.length; j++){
            if (B[j]==A[i]&&B[j]!=A[j]){
                cand.add(j);
                if (A[j]==B[i]){
                    swap(B, i, j);
                    ans = solve(i+1, A, B)+1;
                    swap(B, i, j);
                    return ans;
                }
            }
        }
        for (int j : cand){
            swap(B, i, j);
            ans = Math.min(ans, solve(i+1, A, B));
            swap(B, i, j);
        }
        return ans+1;
    }

    private void swap(char[] A, int i, int j){
        char tmp = A[i];
        A[i]=A[j];
        A[j]=tmp;
    }
}
