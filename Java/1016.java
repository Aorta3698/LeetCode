class Solution {
    public boolean queryString(String s, int n) {
        if (2 * n > s.length() * (s.length() + 1))
            return false;
        BitSet bit = new BitSet(n + 1);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '0')
                continue;
            for (int j = i, sum = 0; j < s.length() && sum <= n; j++){
                sum = 2 * sum + s.charAt(j) - '0';
                if (sum > 0 && sum <= n){
                    bit.set(sum);
                }
            }
        }
        return bit.cardinality() == n;
    }
}
