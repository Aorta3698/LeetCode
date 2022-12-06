https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/discuss/1710751/Java-7-Lines-1ms-99-Faster
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length(), m = n % k, len = n + (m == 0? 0: k - m);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < len - n; i++) sb.append(fill);
        s = sb.toString();

        String[] ans = new String[len / k];
        for (int i = 0; i < len; i+=k)
            ans[i/k] = s.substring(i, i + k);

        return ans;
    }
}
