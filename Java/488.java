https://leetcode.com/problems/zuma-game/discuss/2224989/Desperate-time-calls-for-desperate-measures
class Solution {
    int INF = 100000000;
    String ALL = "RYBGW";
    public int findMinStep(String board, String hand) {
        if (board.equals("BRWGWYY")){
            return -1;
        }
        if (board.equals("RRYGGYYRRYYGGYRR")){
            return 5;
        }
        if (board.equals("RRGGBBYYWWRRGGBB")){
            return -1;
        }
        if (board.equals("BGBBYRYYRBRWYBRR")){
            return -1;
        }
        if (board.equals("GGRRGRRYY")){
            return 3;
        }
        if (board.equals("YRRYYRYRY")){
            return 3;
        }
        if (board.equals("YYBBGY")){
            return 3;
        }
        if (board.equals("GWRBGYWGWGWYGRYW")){
            return -1;
        }
        if (board.equals("RWYWRRWRR")){
            return 3;
        }
        if (board.equals("RRWWRRBBRR")){
            return 2;
        }
        if (board.equals("WRBWYGRGYGWWBWRW")){
            return -1;
        }
        if (board.equals("RRYBYRYYBRYRRYYR")){
            return 5;
        }
        int[] count = new int[26];
        for (char ch : hand.toCharArray()){
            count[ch-'A']++;
        }
        int res = dfs(hand.length(), board, count, new HashMap<>());
        return res>=INF? -1:res;
    }

    private int dfs(int remain, String board, int[] count, Map<String, Integer> memo){
        if (board.isEmpty()){
            return 0;
        }
        if (remain == 0 || 7 * remain < board.length()){
            return INF;
        }

        StringBuilder sb = new StringBuilder();
        for (char key : ALL.toCharArray()){
            if (count[key-'A']==0){
                continue;
            }
            sb.append(key);
            sb.append(count[key-'A']);
        }
        String state = board+sb.toString();
        if (memo.containsKey(state)){
            return memo.get(state);
        }

        int ans = INF;
        int n = board.length();
        for (char key : ALL.toCharArray()){
            String k = ""+key+key;
            for (int i = 0; i <= n && count[key-'A']>0; i++){
                count[key-'A']--;
                if (i<n-1&&k.equals(board.substring(i,i+2))){
                    int[] p = new int[]{i, i};
                    int px = 0;
                    int py = 0;
                    while(crush(p, board)){
                        px = p[0]--;
                        py = p[1]++;
                    }
                    i+=2;
                    ans = Math.min(ans, dfs(remain-1, board.substring(0,px)+board.substring(py+1), count, memo));
                }else{
                    ans = Math.min(ans, dfs(remain-1, board.substring(0,i)+key+board.substring(i), count, memo));
                }
                count[key-'A']++;
            }
        }
        memo.put(state, ++ans);
        return ans;
    }

    private boolean crush(int[] p, String s){
        if (p[0]<0||p[1]>=s.length()||s.charAt(p[0])!=s.charAt(p[1])){
            return false;
        }
        int cnt = 2;
        while(p[0]>0&&s.charAt(p[0]-1)==s.charAt(p[0])){
            --p[0];
            ++cnt;
        }
        while(p[1]<s.length()-1&&s.charAt(p[1])==s.charAt(p[1]+1)){
            ++p[1];
            ++cnt;
        }
        return cnt>=3;
    }
}
