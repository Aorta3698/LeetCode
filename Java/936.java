https://leetcode.com/problems/stamping-the-sequence/discuss/2458160/Work-backward-or-Java
class Solution {
    public int[] movesToStamp(String stamp, String target) {
        LinkedList<Integer> ans = new LinkedList<>();
        char[] T = target.toCharArray(), S = stamp.toCharArray();
        int sz, m = stamp.length(), n = target.length(), del = 0;
        do{ sz = ans.size();
            for (int i = 0; i < n - m + 1; i++){
                boolean ok = T[i] != 'X';
                for (int j = i; j < i + m && ok; j++){
                    ok &= T[j] == 'X' || T[j] == '?' || T[j] == S[j - i];
                }
                for (int j = i; j < i + m && ok; j++){
                    if (Character.isLowerCase(T[j])){
                        del++;
                    }
                    T[j] = j == i || T[j] == 'X'? 'X' : '?';
                }
                if (ok){
                    ans.addFirst(i);
                }
            }
        }while(sz != ans.size() && del != n);

        return del != n? new int[0] : ans.stream().mapToInt(o -> o).toArray();
    }
}
