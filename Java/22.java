https://leetcode.com/problems/generate-parentheses/discuss/2085253/Java-or-Bracktracking-or-Explained.
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(0, 2*n, new StringBuilder(), ans);
        return ans;
    }

    private void solve(int open, int remain, StringBuilder sb, List<String> ans){
        if (remain-- == 0){
            ans.add(sb.toString());
            return;
        }
        if (open > 0){
            sb.append(')');
            solve(open - 1, remain, sb, ans);
            sb.setLength(sb.length() - 1);
        }
        if (open < remain){
            sb.append('(');
            solve(open + 1, remain, sb, ans);
            sb.setLength(sb.length() - 1);
        }
    }
}
