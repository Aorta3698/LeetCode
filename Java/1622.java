class Fancy {

    int M = (int)1e9+7;
    long add = 0;
    long mul = 1;
    List<Long> seq = new ArrayList<>();
    public Fancy() {
    }

    public void append(int v) {
        long val = v;
        val = (val - add + M) % M;
        val = val * modInverse(mul) % M;
        seq.add(val);
    }

    public void addAll(int inc) {
        add+=inc;
    }

    public void multAll(int m) {
        add = add*m%M;
        mul = mul*m%M;
    }

    public int getIndex(int idx) {
        return idx < 0 || idx >= seq.size()?
            -1 : (int)((seq.get(idx)*mul+add)%M);
    }

    private int modInverse(long n){
        // a^(M-1) % M = 1 % M
        // a^(M-2) % M = a^-1 % M
        long ans = 1;
        int e = M-2;
        for (int i = 0; e > 0; i++, e>>=1){
            if ((e&1)==1){
                ans = (ans * n) % M;
            }
            n = n * n % M;
        }
        return (int)ans;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
