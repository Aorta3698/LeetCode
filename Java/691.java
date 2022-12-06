class Solution {
    public int minStickers(String[] S, String T) {
        int[] tcnt = new int[26];
        int need = 0;
        List<Integer> list = new ArrayList<>();
        for (char ch : T.toCharArray()){
            if (tcnt[ch-'a']++ == 0){
                need++;
                list.add(ch-'a');
            }
        }
        int[][] cnt = new int[S.length][26];
        for (int i = 0; i < S.length;i++){
            for (char ch : S[i].toCharArray()){
                cnt[i][ch-'a']++;
            }
        }
        List<Integer>[] letters = new ArrayList[S.length];
        Arrays.setAll(letters, o-> new ArrayList<>());
        for (int i = 0; i < S.length; i++){
            for (int j = 0; j < 26; j++){
                if (tcnt[j]>0&&cnt[i][j]>0){
                    letters[i].add(j);
                }
            }
        }

        int res = solve(need, list, tcnt, cnt, S, letters, new HashMap<>());
        return res > 100? -1 : res;
    }

    private int solve(int need, List<Integer> lneed, int[] tcnt, int[][] cnt, String[] S, List<Integer>[] letters, Map<Integer, Integer> map){
        if (need == 0){
            return 0;
        }
        int hash = 0;
        for (int i : lneed){
            hash = 17 * hash + Math.max(tcnt[i], 0)+1;
        }
        if (map.containsKey(hash)){
            return map.get(hash);
        }
        int ans = 100000;
        for (int i = 0; i < S.length; i++){
            int n = need;
            List<Integer> list = new ArrayList<>();
            for (int j : letters[i]){
                if (tcnt[j]>0){
                    tcnt[j]-=cnt[i][j];
                    list.add(j);
                    if (tcnt[j]<=0){
                        n--;
                    }
                }
            }
            if (!list.isEmpty()){
                ans = Math.min(ans, solve(n, lneed, tcnt, cnt, S, letters, map));
            }
            for (int j : list){
                tcnt[j]+=cnt[i][j];
            }
        }
        map.put(hash, ans+1);
        return ans+1;
    }
}
