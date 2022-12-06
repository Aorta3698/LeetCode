class Solution {
    public String restoreString(String s, int[] indices) {
        char[] ans = new char[indices.length];
        int idx = 0;
        for (int i : indices)
            ans[i] = s.charAt(idx++);

        return String.valueOf(ans);
    }
}
