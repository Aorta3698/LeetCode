class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()){
            cnt[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        int i = find(cnt, 25), j = find(cnt, i - 1);
        boolean turn = true;
        while(j >= 0 && i >= 0){
            if (turn){
                int take = Math.min(repeatLimit, cnt[i]);
                sb.append(((char)(i + 'a')+"").repeat(take));
                cnt[i] -= take;
                if (cnt[i] == 0){
                    i = find(cnt, i);
                }else{
                    turn = !turn;
                }
            }else{
                j = j >= i? find(cnt, i - 1) : find(cnt, j);
                if (j < 0) break;
                sb.append((char)(j + 'a'));
                cnt[j]--;
                turn = !turn;
            }
        }

        return sb.isEmpty()?
            ((char)(i + 'a')+"").repeat(repeatLimit) : sb.toString();
    }

    private int find(int[] cnt, int i){
        while(i >= 0 && cnt[i] == 0) i--;
        return i;
    }
}
