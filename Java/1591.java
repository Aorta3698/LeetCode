class Solution {
    public boolean isPrintable(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int remain = n*m;
        Print[] prints = new Print[61];
        Arrays.setAll(prints, o -> new Print(o));
        while(true){
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (A[i][j]>=0){
                        int v = A[i][j];
                        prints[v].top=Math.min(prints[v].top, i);
                        prints[v].bottom = Math.max(prints[v].bottom, i);
                        prints[v].left = Math.min(prints[v].left, j);
                        prints[v].right=Math.max(prints[v].right, j);
                    }
                }
            }
            Set<Integer> removeSet = new HashSet<>();
            for (int i = 0; i <= 60; i++){
                if (prints[i]!=null&&prints[i].okToRemove(A)){
                    removeSet.add(i);
                    prints[i] = null;
                }
            }
            if (removeSet.isEmpty())
                return false;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (removeSet.contains(A[i][j])){
                        A[i][j] = -1;
                        if (--remain == 0)
                            return true;
                    }
                }
            }
        }
    }

    private class Print {
        int top=1000;
        int right=-1;
        int left=1000;
        int bottom=-1;
        int val;
        Print(int val){
            this.val = val;
        }

        boolean okToRemove(int[][] A){
            if (bottom==-1)
                return false;
            for (int i = top; i <= bottom; i++){
                for (int j = left; j <= right; j++){
                    if (A[i][j]!=val && A[i][j]!=-1)
                        return false;
                }
            }
            return true;
        }
    }
}
