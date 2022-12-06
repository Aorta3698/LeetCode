https://leetcode.com/problems/shifting-letters-ii/discuss/2455716/Java-LineSweep
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] line = new int[s.length()+1];
        for (int[] sh : shifts){
            int d = sh[2] == 1? 1 : -1;
            line[sh[0]] += d;
            line[sh[1]+1] -= d;
        }
        char[] A = s.toCharArray();
        for (int i = 0, j = 0; i < A.length; i++){
            j += line[i];
            A[i] = (char)('a' + (((A[i] - 'a' + j) % 26) + 26) % 26);
        }
        return String.valueOf(A);
    }
}
