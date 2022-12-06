class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] a = new int[n];
        int[] b = new int[n];
        Arrays.fill(a, -1);
        Arrays.fill(b, -1);
        solve(node1, edges, a);
        solve(node2, edges, b);
        int ans = -1;
        for (int i = 0; i < n; i++){
            if (a[i]>=0 && b[i]>=0 && (ans == -1 || Math.max(a[i], b[i]) < Math.max(a[ans], b[ans]))){
                ans = i;
            }
        }
        return ans;
    }

    private void solve(int n, int[] edges, int[] a){
        int cnt=0;
        while(n >= 0 && a[n]==-1){
            a[n]=cnt++;
            n=edges[n];
        }
    }
}
