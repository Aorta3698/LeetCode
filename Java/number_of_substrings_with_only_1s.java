class Solution {
    public int numSub(String s) {
        long ans = 0;
        long count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '0') {
                count = 0;
                continue;
            }

            ans += ++count;
        }

        return (int)(ans % (int)(1e9 + 7));
    }
}
