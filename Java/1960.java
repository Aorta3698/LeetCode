class Solution {
    long p = 100001, M = (long)1e9+7;
    int n;
    public long maxProduct(String s) {
        n = s.length();
        long a = 0, b = 0, base = 1;
        long[] e = new long[n];
        for (int i = 0; i < n; i++){
            e[i]=base;
            base *= p;
            base %= M;
        }
        long[] x = build(s, e);
        long[] y = build(new StringBuilder(s).reverse().toString(), e);
        int[] center = new int[n];
        for (int i = 0; i < n; i++){
            int lo = 0, hi = Math.min(i,n-i-1), diff = i-(n-1-i);
            while(lo < hi){
                int mid = (lo+hi+1)>>1;
                long one = x[i+mid] - (i==mid?0:x[i-mid-1]) + M;
                long two = y[n-1-i+mid] - (n-1-i==mid?0:y[n-1-i-mid-1]) + M;
                if (diff > 0){
                    two *= e[diff];
                }else{
                    one *= e[-diff];
                }
                two %= M;
                one %= M;
                if (one == two){
                    lo=mid;
                }else{
                    hi=mid-1;
                }
            }
            center[i]=lo;
        }
        int[] pre = map(center,  1);
        int[] suf = map(center, -1);
        long ans = 0;
        for (int i = 0; i < n-1; i++){
            ans = Math.max(1L*pre[i]*suf[i+1], ans);
        }
        return ans;
    }

    private long[] build(String s, long[] exp){
        long[] y = new long[n];
        long b = 0;
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            b += exp[i]*ch;
            b %= M;
            y[i]=b;
        }
        return y;
    }

    private int[] map(int[] center, int D){
        Queue<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = D==-1?n-1:0; i < n && i >= 0; i+=D){
            while(!queue.isEmpty() && Math.abs(i-queue.peek())>center[queue.peek()]){
                queue.poll();
            }
            queue.offer(i);
            ans[i]=Math.max((i-D<0||i-D==n?0:ans[i-D]), Math.abs(i-queue.peek())*2+1);
        }
        return ans;
    }
}
