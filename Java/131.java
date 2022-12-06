class Solution {
    boolean[][] ok;
    public List<List<String>> partition(String s) {
        ok = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--){
            for (int j = i; j < s.length(); j++){
                ok[i][j] = s.charAt(i) == s.charAt(j) && (j-i<=1 || ok[i+1][j-1]);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        solve(0, s, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int cur, String s, List<String> tmp, List<List<String>> ans){
        if (cur == s.length()){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = cur; i < s.length(); i++){
            if (ok[cur][i]){
                tmp.add(s.substring(cur, i+1));
                solve(i+1, s, tmp, ans);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
