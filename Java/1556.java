https://leetcode.com/problems/thousand-separator/discuss/1639332/Java-String.format()-1-Line
class Solution {
    public String thousandSeparator(int n) {
        return String.format("%,3d", n).replace(",",".").replace(" ","");
    }
}
