class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length, ans = 1;
        int[] odd = new int[n];
        int[] even = new int[n];
        Integer[] inc = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Integer[] dec = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(inc, Comparator.comparingInt(o -> arr[o]));
        Arrays.sort(dec, Comparator.comparingInt(o ->-arr[o]));
        Deque<Integer> os=new ArrayDeque<>();
        Deque<Integer> es=new ArrayDeque<>();
        for (int i = 0; i <n;++i){
            while(!os.isEmpty()&&os.peek()<inc[i]){
                odd[os.pop()]=inc[i];
            }
            while(!es.isEmpty()&&es.peek()<dec[i]){
                even[es.pop()]=dec[i];
            }
            os.push(inc[i]);
            es.push(dec[i]);
        }
        boolean[][] dp = new boolean[n][2];
        dp[n-1][0]=dp[n-1][1]=true;
        for (int i =n-2;i>=0;--i){
            dp[i][0]=dp[odd[i]][1];
            dp[i][1]=dp[even[i]][0];
            if (dp[i][0]){
                ans++;
            }
        }
        return ans;
    }
}

class Solution {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length, M = 20001;
        int[] odd = new int[n];
        int[] even = new int[n];
        for (int i = 0; i < n; i++){
            odd[i]=even[i]=-1;
        }
        TreeSet<Integer> oddSet = new TreeSet<>();
        TreeSet<Integer> evenSet = new TreeSet<>();
        for (int i = 0; i < n; i++){
            ++arr[i];
            oddSet.add(arr[i]*M+i);
            evenSet.add(arr[i]*M-i);
        }
        for (int i = 0; i < n; i++){
            int oddCur = arr[i]*M+i;
            int evenCur= arr[i]*M-i;
            oddSet.remove(oddCur);
            evenSet.remove(evenCur);
            Integer o = oddSet.higher(oddCur);
            Integer e = evenSet.lower(evenCur);
            if (o!=null){
                odd[i]=o%M;
            }
            if (e!=null){
                even[i]=-(e%M-M);
            }
        }
        int ans = 0;
        Boolean[][] memo = new Boolean[n][2];
        for (int i = 0;i<n;i++){
            if(dfs(i,0,odd,even,memo)){
                ans++;
            }
        }
        return ans;
    }

    private boolean dfs(int i, int n, int[] odd, int[] even, Boolean[][] memo){
        if (i==-1){
            return false;
        }
        if (i == odd.length-1){
            return true;
        }
        if (memo[i][n]!=null){
            return memo[i][n];
        }
        return memo[i][n]=n==0? dfs(odd[i],n^=1,odd,even, memo) : dfs(even[i],n^=1,odd,even,memo);
    }
}
