class Solution {
    public String predictPartyVictory(String A) {
        BitSet r = new BitSet(), d = new BitSet();
        for (int i = 0; i < A.length(); i++){
            if (A.charAt(i) == 'R') r.set(i);
            else d.set(i);
        }

        while(true){
            for (int i = 0; i < A.length(); i++){
                if (r.get(i) && mark(d, i) == -1) return "Radiant";
                if (d.get(i) && mark(r, i) == -1) return "Dire";
            }
        }
    }

    private int mark(BitSet bit, int idx){
        int k = bit.nextSetBit(idx + 1);

        if (k == -1){
            k = bit.get(0, idx).nextSetBit(0);
        }
        if (k != -1){
            bit.clear(k);
        }

        return k;
    }
}
