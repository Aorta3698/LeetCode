class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        solve(0, 0, word, ans, new StringBuilder());
        return ans;
    }

    private void solve(int i, int sz, String s, List<String> ans, StringBuilder sb){
        if (i >= s.length()){
            sb.append(sz == 0? "" : sz);
            ans.add(sb.toString());
            return;
        }
        int len = sb.length();
        sb.append(sz == 0? "" : sz);
        sb.append(s.charAt(i));
        solve(i + 1, 0, s, ans, sb);
        sb.setLength(len);
        solve(i + 1, sz + 1, s, ans, sb);
        sb.setLength(len);
    }
}
