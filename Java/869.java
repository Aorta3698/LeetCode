https://leetcode.com/problems/reordered-power-of-2/discuss/2481411/Java-or-Sort
class Solution {
    public boolean reorderedPowerOf2(int n) {
        for (int i = 0; i <= 30; i++){
            char[] a = (""+(1<<i)).toCharArray();
            char[] b = (""+n).toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            if (Arrays.equals(a, b)){
                return true;
            }
        }
        return false;
    }
}
