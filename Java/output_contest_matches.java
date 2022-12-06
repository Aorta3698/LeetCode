https://leetcode.com/problems/output-contest-matches/discuss/1612660/Java-or-98-Speed-or-Simulations-or-Explanations!

class Solution {
    public String findContestMatch(int n) {
        StringBuilder[] teams = new StringBuilder[n / 2 + 1];
        while(n > 1){
            for (int i = 1; i <= n/2; i++){
                StringBuilder sb = new StringBuilder();
                sb.append('(');
                if (teams[i] == null){
                    sb.append(i);
                    sb.append(',');
                    sb.append(n - i + 1);
                }else{
                    sb.append(teams[i]);
                    sb.append(',');
                    sb.append(teams[n - i + 1]);
                }
                sb.append(')');
                teams[i] = sb;
            }

            n /= 2;
        }

        return teams[1].toString();
    }
}
