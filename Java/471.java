class Solution {
    public String encode(String s) {
        return solve(0, s.length()-1, s, new String[s.length()][s.length()]);
    }

    private String solve(int lo, int hi, String s, String[][] memo){
        if (memo[lo][hi] != null){
            return memo[lo][hi];
        }
        if (hi-lo<4){
            return memo[lo][hi]=s.substring(lo,hi+1);
        }
        String ans = s.substring(lo, hi+1);
        String repeat = ans+ans, cut = repeat.substring(1, repeat.length() - 1);
        int len = cut.indexOf(ans)+1;
        String b = len>0? ans.length()/len+"["+solve(lo, lo+len-1, s, memo)+"]" : ans;
        if (ans.length() > b.length()){
            ans = b;
        }
        for (int i = lo; i < hi; i++){
            String res = solve(lo, i, s, memo) + solve(i+1, hi, s, memo);
            if (res.length()<ans.length()){
                ans=res;
            }
        }
        return memo[lo][hi]=ans;
    }
}
