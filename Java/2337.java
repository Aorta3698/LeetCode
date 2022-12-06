https://leetcode.com/problems/move-pieces-to-obtain-a-string/discuss/2319204/My-Contest-Woe-%3A(
class Solution {
    public boolean canChange(String s, String t) {
        if (!s.replace("_","").equals(t.replace("_",""))){
            return false;
        }
        for (int i = 0, r = 0, l = 0; i < s.length(); i++){
            if (s.charAt(i)=='R'){
                r++;
            }
            if (t.charAt(i)=='L'){
                l++;
            }
            if (t.charAt(i)=='R' && --r < 0){
                return false;
            }
            if (s.charAt(i)=='L' && --l < 0){
                return false;
            }
        }
        return true;
    }
}
