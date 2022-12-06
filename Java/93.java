class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() > 12)
            return ans;
        solve(0, 0, s, ans, new StringBuilder());
        return ans;
    }

    private void solve(int i, int j, String s, List<String> ans, StringBuilder sb){
        if (i == 4 || j == s.length()){
            if (i == 4 && j == s.length()){
                ans.add(sb.toString());
            }
            return;
        }

        for (int k = j; k < Math.min(j + 3, s.length()); k++){
            if (s.charAt(j) == '0' || Integer.parseInt(s.substring(j, k + 1)) <= 255){
                int sz = sb.length();
                sb.append(s.substring(j, k + 1));
                if (i < 3){
                    sb.append('.');
                }
                solve(i + 1, k + 1, s, ans, sb);
                sb.setLength(sz);
                if (s.charAt(j) == '0')
                    break;
            }
        }
    }
}
