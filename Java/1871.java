https://leetcode.com/problems/jump-game-vii/discuss/2012482/Simple-Line-Sweep-Java-Solution-or-Explained.
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int cur = 0;
        int[] ok = new int[2*s.length()+1];
        for (int i = 0; i < s.length(); i++){
            cur += ok[i];
            if (i == 0 || s.charAt(i) == '0' && cur > 0){
                ok[i + minJump]++;
                ok[i + maxJump + 1]--;
            }
        }
        return cur > 0 && s.charAt(s.length() - 1) == '0';
    }
}
