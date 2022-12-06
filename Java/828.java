class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length(), ans = 0;
        int[] next = new int[n];
        int[] prev = new int[n];
        int[] arr = new int[26];
        Arrays.fill(next, n);
        Arrays.fill(prev,-1);
        Arrays.fill(arr, -1);
        for (int i = 0; i < n; i++){
            int v = s.charAt(i)-'A';
            if (arr[v]>=0){
                next[arr[v]]=i;
            }
            prev[i]=arr[v];
            arr[v]=i;
        }
        for (int i = 0;i <n;++i){
            ans += (next[i]-i)*(i-prev[i]);
        }
        return ans;
    }
}
