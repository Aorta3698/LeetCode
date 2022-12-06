https://leetcode.com/problems/detect-capital/discuss/1714262/Java-with-comments
class Solution {
    public boolean detectCapitalUse(String word) {
        int capCnt = 0;
        for (char ch : word.toCharArray())
            if (ch <= 'Z')
                capCnt++;

        if (capCnt == 0) return true;
        if (capCnt == 1) return word.charAt(0) <= 'Z';
        return capCnt == word.length();
    }
}
