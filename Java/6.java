https://leetcode.com/problems/zigzag-conversion/discuss/1884650/Change-Direction-Java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder[] arr = new StringBuilder[numRows];
        Arrays.setAll(arr, o -> new StringBuilder());
        int m = 2 * numRows - 2;

        for (int i = 0, j = 0, d = -1; i < s.length(); i++){
            if (i % m == m / 2 || i % m == 0){
                d = -d;
            }
            arr[j].append(s.charAt(i));
            j += d;
        }

        for (StringBuilder k : arr){
            sb.append(k);
        }

        return sb.toString();
    }
}
