class Solution {
    public int minInsertions(String s) {
        int ans = 0, open = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                if (open % 2 == 1){
                    open--;
                    ans++;
                }
                open += 2;
            }else{
                if (--open == -1){
                    ++ans;
                    open = 1;
                }
            }
        }

        return ans + open;
    }
}
