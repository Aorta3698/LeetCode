https://leetcode.com/problems/longest-absolute-file-path/discuss/1947860/Java-or-0ms-or-Prefix-Sum
class Solution {
    public int lengthLongestPath(String input) {
        int[] count = new int[input.length() + 2];
        String[] lines = input.split("\n");
        int ans = 0;
        for (int i = 0; i < lines.length; i++){
            int t = getTab(lines[i]);
            int sz = lines[i].length() - t;
            if (lines[i].indexOf(".") == -1){
                count[t + 1] = count[t] + sz;
            }else{
                ans = Math.max(ans, count[t] + sz + t);
            }
        }
        return ans;
    }

    private int getTab(String s){
        int count = 0;
        while(count < s.length() && s.charAt(count) == '\t'){
            ++count;
        }
        return count;
    }
}
