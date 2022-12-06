class Solution {
    public int numWays(String s) {
        int count = 0, M = (int)(1e9 + 7);
        for (char ch : s.toCharArray()){
            count += ch - '0';
        }
        if (count % 3 > 0)
            return 0;
        if (count == 0)
            return (int)((1L * s.length() - 1) * (s.length() - 2) / 2 % M);
        int one = 0, two = 0, cur = 0;
        for (char ch : s.toCharArray()){
            cur += ch - '0';
            if (cur == count / 3){
                one++;
            }
            if (cur == count / 3 * 2){
                two++;
            }
        }
        return (int)(1L * one * two % M);
    }
}
