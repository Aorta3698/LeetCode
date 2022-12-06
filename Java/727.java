https://leetcode.com/problems/minimum-window-subsequence/discuss/2229178/Java-or-Jump-Table-O(max(262*N-MN))
class Solution {
    public String minWindow(String A, String B) {
        int[][][] next = new int[26][26][A.length()];
        for (int i = 1; i < B.length(); i++){
            int from = B.charAt(i-1)-'a';
            int to = B.charAt(i)-'a';
            for (int j = A.length()-1,k=0; j >= 0; j--){
                if (A.charAt(j)-'a'==from){
                    next[from][to][j]=k;
                }
                if (A.charAt(j)-'a'==to){
                    k=j;
                }
            }
        }
        int st = -1;
        int end = 10000000;
        for (int i = 0; i < A.length(); i++){
            if (A.charAt(i) != B.charAt(0)){
                continue;
            }
            int k = i;
            int from = A.charAt(i)-'a';
            for (int j = 1; j < B.length() && k - i < end-st; j++){
                k = next[from][B.charAt(j)-'a'][k];
                from = B.charAt(j) - 'a';
                if (k==0) {
                    break;
                }
            }
            if ((B.length()==1||k != 0) && k - i < end-st){
                st = i;
                end = k;
            }
        }

        return st==-1?"":A.substring(st, end+1);
    }
}
