class Solution {
    public int maxEnvelopes(int[][] E) {
        Arrays.sort(E, (a, b) -> a[0] == b[0]? b[1] - a[1] : a[0] - b[0]);
        List<Integer> ans = new ArrayList<>();
        for (int[] n : E){
            int lo = 0, hi = ans.size();
            while(lo < hi){
                int mid = (lo + hi) >> 1;
                if (ans.get(mid) >= n[1])
                    hi = mid;
                else
                    lo = mid + 1;
            }
            if (lo == ans.size()){
                ans.add(n[1]);
            }else{
                ans.set(lo, n[1]);
            }
        }
        return ans.size();
    }
}
