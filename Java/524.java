class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        List<Integer>[] idx = new ArrayList[26];
        for (int i = 0; i < idx.length; i++) idx[i] = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) idx[s.charAt(i) - 'a'].add(i);
        for (String d : dictionary){
            String cand = d;
            int[] cnt = new int[26];
            int prev = 0;
            for (char ch : d.toCharArray()){
                int j = ch - 'a';
                while (cnt[j] < idx[j].size() && idx[j].get(cnt[j]) < prev) {
                    cnt[j]++;
                }
                if (cnt[j] == idx[j].size()){
                    cand = "";
                    break;
                }
                prev = idx[j].get(cnt[j]++);
            }
            if (cand.length() > ans.length()) ans = cand;
            if (cand.length() == ans.length() && ans.compareTo(cand) > 0) ans = cand;
        }

        return ans;
    }
}
