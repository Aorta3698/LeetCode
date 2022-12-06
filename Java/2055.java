class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        List<Integer> pipe = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '|'){
                pipe.add(i);
            }
        }

        for (int i = 0; i < queries.length; i++){
            int x = queries[i][0], y = queries[i][1];
            int lo = 0, hi = pipe.size();
            while(lo < hi){
                int mid = (hi + lo) >> 1;
                if (pipe.get(mid) >= x){
                    hi = mid;
                }else{
                    lo = mid + 1;
                }
            }
            if (lo == pipe.size() || pipe.get(lo) > y){
                continue;
            }

            int lpipe = lo;

            lo = -1; hi = pipe.size() - 1;
            while(lo < hi){
                int mid = (lo + hi + 1) >> 1;
                if (pipe.get(mid) <= y){
                    lo = mid;
                }else{
                    hi = mid - 1;
                }
            }
            if (lo == -1 || pipe.get(lo) < x){
                continue;
            }
            int rpipe = lo;

            ans[i] = pipe.get(rpipe) - pipe.get(lpipe) - (rpipe - lpipe);
        }

        return ans;
    }
}
