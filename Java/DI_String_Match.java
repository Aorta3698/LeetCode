class Solution {
    public int[] diStringMatch(String s) {
        int i = 0;
        int d = s.length();
        int[] ans = new int[d + 1];
        int idx = 0;
        for (char ch : s.toCharArray())
            ans[idx++] = ch == 'I'? i++ : d--;

        ans[idx] = i;
        return ans;
    }
}
