class Solution {
    int m;
    int n;
    int M = (int)1e9+7;
    public int ways(String[] pizza, int k) {
        m = pizza.length;
        n = pizza[0].length();
        int[][] pre = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int val = pizza[i].charAt(j)=='A'?1:0;
                pre[i][j]=val+(i>0?pre[i-1][j]:0)+(j>0?pre[i][j-1]:0)-(i*j>0?pre[i-1][j-1]:0);
            }
        }
        return solve(m, n, k-1, pre, new Integer[m+1][n+1][k]);
    }

    private int solve(int x, int y, int k, int[][] pre, Integer[][][] memo){
        if (k==0){
            return 1;
        }
        if (memo[x][y][k]!=null){
            return memo[x][y][k];
        }

        int ans = 0,a=m-x,b=n-y;
        for (int i=1;i<x;i++){
            int top    = query(a,b,a+i-1,n-1,pre);
            int bottom = query(a+i,b,m-1,n-1,pre);
            if (bottom<k){
                break;
            }
            if (top==0){
                continue;
            }
            ans+=solve(x-i,y,k-1,pre,memo);
            ans%=M;
        }
        for (int j=1;j<y;++j){
            int left = query(a,b,m-1,b+j-1,pre);
            int right= query(a,b+j,m-1,n-1,pre);
            if (right<k){
                break;
            }
            if (left==0){
                continue;
            }
            ans+=solve(x,y-j,k-1,pre,memo);
            ans%=M;
        }

        return memo[x][y][k]=ans;
    }

    private int query(int i, int j, int ii, int jj, int[][] pre){
        return pre[ii][jj]-(i>0?pre[i-1][jj]:0)-(j>0?pre[ii][j-1]:0)+(i*j>0?pre[i-1][j-1]:0);
    }
}
