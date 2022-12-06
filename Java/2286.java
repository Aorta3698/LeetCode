class BookMyShow {

    int st;
    int cap;
    int[] A;
    long[] bit;
    public BookMyShow(int n, int m) {
        cap = m;
        A=new int[n];
        bit=new long[n+1];
    }

    public int[] gather(int k, int maxRow) {
        if (k > cap){
            return new int[0];
        }
        int lo = st, hi = maxRow+1;
        while(lo < hi){
            if (cap - A[lo] >= k){
                break;
            }
            lo++;
        }
        if (lo >= maxRow+1){
            return new int[0];
        }
        int[] ans = new int[]{lo, A[lo]};
        A[lo]+=k;
        add(lo, k);
        while (st < A.length && A[st]==cap){
            st++;
        }
        return ans;
    }

    public boolean scatter(int k, int maxRow) {
        if (1L*(maxRow+1)*cap - sum(maxRow) < k){
            return false;
        }
        while(k > 0){
            int fill = Math.min(cap - A[st], k);
            add(st, fill);
            A[st] += fill;
            k-= fill;
            while (st < A.length && A[st]==cap){
                st++;
            }
        }
        return true;
    }

    private void add(int idx, int inc){
        for (++idx; idx < bit.length; idx += idx & -idx){
            bit[idx]+=inc;
        }
    }

    private long sum(int idx){
        long ans = 0;
        for (++idx; idx > 0; idx -= idx & -idx){
            ans += bit[idx];
        }
        return ans;
    }
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */
