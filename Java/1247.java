https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/discuss/1996007/I-didn't-see-that-it-was-%22x%22-and-%22y%22-only...
class Solution {
    public int minimumSwap(String s1, String s2) {
        boolean[] seen = new boolean[s1.length()];
        List<Integer>[] all = new ArrayList[26];
        Arrays.setAll(all, o -> new ArrayList<>());
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                all[s1.charAt(i) - 'a'].add(i);
            }else{
                seen[i] = true;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++){
            List<Integer> cur = all[i];
            for (int j = 0; j < cur.size(); j++){
                for (int k = j + 1; k < cur.size() && !seen[cur.get(j)]; k++){
                    if (!seen[cur.get(k)] && s2.charAt(cur.get(j)) == s2.charAt(cur.get(k))){
                        seen[cur.get(j)] = seen[cur.get(k)] = true;
                        ans++;
                    }
                }
            }
        }
        for (int i = 0; i < 26; i++){
            List<Integer> out = all[i];
            for (int j = 0; j < 26; j++){
                List<Integer> in = all[j];
                for (int k = 0; k < out.size(); k++){
                    for (int w = 0; w < in.size() && !seen[out.get(k)]; w++){
                        if (!seen[in.get(w)] && (""+s1.charAt(out.get(k))+s1.charAt(in.get(w)))
                                .equals(""+s2.charAt(in.get(w))+s2.charAt(out.get(k)))){
                            seen[in.get(w)] = seen[out.get(k)] = true;
                            ans += 2;
                        }
                    }
                }
            }
        }
        for (boolean b : seen){
            if (!b)
                return -1;
        }
        return ans;
    }
}
