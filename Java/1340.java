class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] right = new int[n];
        int[] left  = new int[n];
        Arrays.fill(right, -1);
        Arrays.fill(left , -1);
        Deque<Integer> rStack = new ArrayDeque<>();
        Deque<Integer> lStack = new ArrayDeque<>();
        for (int i = 0, j=n-1; i < n; i++,j--){
            while(!rStack.isEmpty() && i-rStack.peekLast()>d){
                rStack.pollLast();
            }
            while(!lStack.isEmpty() && lStack.peekLast()-j>d){
                lStack.pollLast();
            }
            while(!rStack.isEmpty() && arr[i]>arr[rStack.peek()]){
                right[rStack.pop()]=i;
            }
            while(!lStack.isEmpty() && arr[j]>arr[lStack.peek()]){
                left[lStack.pop()]=j;
            }
            rStack.push(i);
            lStack.push(j);
        }
        int ans = 0;
        Integer[] memo = new Integer[n];
        for (int i = 0; i < n; i++){
            ans = Math.max(ans, dfs(i, left, right, memo));
        }
        return ans;
    }

    private int dfs(int idx, int[] left, int[] right, Integer[] memo){
        if (idx==-1){
            return 0;
        }
        if (memo[idx]!=null){
            return memo[idx];
        }
        return memo[idx]=Math.max(dfs(left[idx],  left, right, memo),
                                  dfs(right[idx], left, right, memo))+1;
    }
}


class Solution {
    public int maxJumps(int[] arr, int d) {
        int ans = 0;
        int[] memo = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            ans = Math.max(ans, jump(i, d, arr, memo));
        }

        return ans;
    }

    private int jump(int i, int d, int[] arr, int[] memo){
        if (memo[i]!=0)
            return memo[i];

        int ans = 0;
        boolean l = true, r = true;
        for (int j = 1; j <= d && (l||r); j++){
            if (i-j<0||arr[i-j]>=arr[i]){
                l=false;
            }
            if (i+j>=arr.length||arr[i+j]>=arr[i]){
                r=false;
            }
            if (l){
                ans = Math.max(ans, jump(i-j, d, arr, memo));
            }
            if (r){
                ans = Math.max(ans, jump(i+j, d, arr, memo));
            }
        }

        return memo[i]=ans+1;
    }
}
