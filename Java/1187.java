https://leetcode.com/problems/make-array-strictly-increasing/discuss/2301221/Java-or-10-Lines-DP-or-Space-O(M)-Time-O(NM%2BMlogM)-or-Iterative-or-Explained!
class Solution {
    public int makeArrayIncreasing(int[] A, int[] B) {
        TreeSet<Integer> set = new TreeSet<>(Arrays.stream(B).boxed().toList());
        int[] dp = new int[B.length+1];
        dp[0]=-1;
        int INF = (int)2e9;
        for (int i = 0; i < A.length; i++){
            for (int j = B.length; j >= 0; j--){
                int a = A[i] > dp[j]? A[i] : INF;
                Integer b = set.higher(j==0?INF:dp[j-1]);
                dp[j]=Math.min(a, b==null?INF:b);
            }
        }
        for (int i = 0; i <= B.length; i++) if (dp[i] != INF){
            return i;
        }
        return -1;
    }
}

class Solution {
    public int makeArrayIncreasing(int[] A, int[] B) {
        TreeSet<Integer> set = new TreeSet<>(Arrays.stream(B).boxed().toList());
        int[] dp = new int[B.length+1];
        dp[0]=-1;
        int INF = (int)2e9;
        for (int i = 0; i < A.length; i++){
            int[] ndp = new int[B.length+1];
            for (int j = 0; j <= B.length; j++){
                int one = A[i]>dp[j]? A[i] : INF;
                Integer two = set.higher(j==0?INF:dp[j-1]);
                two = two == null? INF: two;
                ndp[j]=Math.min(one, two);
            }
            dp=ndp;
            // System.out.println(Arrays.toString(dp));
        }

        for (int i = 0; i <= B.length; i++) if (dp[i] != INF){
            return i;
        }
        return -1;
    }
}

class Solution {
    int INF = (int)1e9;
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        arr2 = Arrays.stream(arr2).distinct().sorted().toArray();
        int res = solve(0, 0, 0, arr1, arr2, new Integer[arr1.length][arr2.length][2]);
        return res == INF? -1 : res;
    }

    private int solve(int i, int j, int p, int[] arr1, int[] arr2, Integer[][][] memo){
        if (i==arr1.length){
            return 0;
        }
        if (j==arr2.length){
            return arr1[i]>arr1[i-1]? solve(i+1, j, 0, arr1, arr2, memo) : INF;
        }
        if (memo[i][j][p]!=null){
            return memo[i][j][p];
        }

        int ans = INF;
        if (i>0&&arr1[i]>arr1[i-1]||i==0){
            ans = solve(i+1, j, 0, arr1, arr2, memo);
        }
        int lo = j, hi = arr2.length;
        while(lo < hi && i > 0){
            int mid = (lo+hi)>>1;
            if (arr2[mid]>arr1[i-1]){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        if (lo<arr2.length){
            int tmp = arr1[i];
            arr1[i]=arr2[lo];
            ans = Math.min(ans, solve(i+1, lo+1, 1, arr1, arr2, memo)+1);
            arr1[i]=tmp;
        }
        return memo[i][j][p]=ans;
    }
}
