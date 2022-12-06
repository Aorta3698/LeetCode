https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/discuss/2454952/on-with-o1-space-no-dp-oa-2-wks-ago-with-constraint-1e5-java
class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int zero = 0, one = 0, ans = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1'){
                ans = Math.max(ans, one+zero);
            }
            one = s.charAt(i) == '1'? Math.min(one+1, one+zero) : Math.max(0, --one);
            zero += '1' - s.charAt(i);
        }
        return ans;
    }
}
