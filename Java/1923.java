class Solution {
    public int longestCommonSubpath(int n, int[][] paths) {
        int lo = 0, hi = 100000, prime = 10711;
        long M = 98123582938771L;
        long[] exp = new long[100001];
        long e = 1;
        for (int i = 0; i < 100001; i++){
            exp[i]=e;
            e *= prime;
            e %= M;
        }
        while(lo < hi){
            int mid = (lo+hi+1) >> 1;
            Map<Long, Integer> map = new HashMap<>();
            boolean ok = true;
            for (int i = 0; i < paths.length && ok; i++){
                long hash = 0;
                ok = false;
                int[] p = paths[i];
                for (int j = 0; j < p.length; j++){
                    hash *= prime;
                    hash += (p[j]+1);
                    if (j >= mid){
                        hash -= (p[j-mid]+1) * exp[mid] % M;
                        hash += M;
                    }
                    hash %= M;
                    if (j >= mid-1 && map.getOrDefault(hash, 0)==i){
                        map.merge(hash, 1, Integer::sum);
                        ok = true;
                    }
                }
            }
            if (ok){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        return lo;
    }
}
