class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] all = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if (!digits.isEmpty()){
            solve(0, all, digits, ans, new StringBuilder());
        }
        return ans;
    }

    private void solve(int i, String[] all, String digits, List<String> ans, StringBuilder sb){
        if (i == digits.length()){
            ans.add(sb.toString());
            return;
        }
        for (char ch : all[digits.charAt(i) - '0'].toCharArray()){
            sb.append(ch);
            solve(i + 1, all, digits, ans, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
