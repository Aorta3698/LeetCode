class Solution {
    public int minFlips(String s) {
        int ok = 0;
        for (int i = 0; i < s.length(); i++){
            if (i % 2 == 0){
                ok += s.charAt(i) - '0';
            }else{
                ok += '1' - s.charAt(i);
            }
        }
        if (s.length() % 2 == 0)
            return Math.min(ok, s.length() - ok);
        int ans = s.length();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1'){
                ok = s.length() - ok + 1;
            }else{
                ok = s.length() - ok - 1;
            }
            ans = Math.min(Math.min(ok, s.length() - ok), ans);
        }
        return ans;
    }
}
