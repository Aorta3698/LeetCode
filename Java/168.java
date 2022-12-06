https://leetcode.com/problems/excel-sheet-column-title/discuss/1645958/Java-Solution-That-Doesn't-Use-ColNum-or-0MS
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            int d = columnNumber % 26;
            sb.append(d == 0? 'Z' : (char)('A' + d - 1));
            columnNumber -= (d == 0? 26 : d);
            columnNumber /= 26;
        }
        //25 * 26 + 26 = YZ, so we subtract have to substract d because otherwise it'd be ZZ.

        return sb.reverse().toString();
    }
}
