https://leetcode.com/problems/sum-of-total-strength-of-wizards/discuss/2239016/Java-or-Need-some-math-(Prefix-sum-of-Prefix-Sum-%2B-Stack)
class Solution {
    public int totalStrength(int[] A) {
        int n = A.length, M = (int)1e9+7;
        Deque<Integer> rs = new ArrayDeque<>();
        Deque<Integer> ls = new ArrayDeque<>();
        int[] right= new int[n];
        int[] left = new int[n];
        int[] pre  = new int[n];
        int[] suf  = new int[n];
        int[] ppre = new int[n];
        int[] ssuf = new int[n];
        Arrays.fill(right, n-1);
        for (int i=0,j=n-1;i<n;i++,j--){
            while(!rs.isEmpty()&&A[i]<A[rs.peek()]){
                right[rs.pop()]=i-1;
            }
            while(!ls.isEmpty()&&A[j]<=A[ls.peek()]){
                left[ls.pop()]=j+1;
            }
            rs.push(i);
            ls.push(j);
            pre[i]=i==0?A[i]:(A[i]+pre[i-1])%M;
            suf[j]=i==0?A[j]:(A[j]+suf[j+1])%M;
            ppre[i]=i==0?pre[i]:(pre[i]+ppre[i-1])%M;
            ssuf[j]=i==0?suf[j]:(suf[j]+ssuf[j+1])%M;
        }
        long ans = 0;
        for (int i = 0; i<n; i++){
            long lval = ((1L*(i-left[i]+1)*pre[i]%M-(i==0?0:(ppre[i-1]-(left[i]<=1?0:ppre[left[i]-2])))+M)%M)*(right[i]-i+1)%M;
            long rval = ((1L*(right[i]-i+1)*suf[i]%M-(i==n-1?0:(ssuf[i+1]-(right[i]>=n-2?0:ssuf[right[i]+2])))+M)%M)*(i-left[i]+1)%M;
            long mid  = (1L*(i-left[i]+1)*(right[i]-i+1))%M*A[i]%M;
            ans = (ans + (lval + rval - mid + M)%M*A[i]%M + M)%M;
        }

        return (int)ans;
    }
}
