class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        int uniq = 0;
        for (int i = 0; i < 26; i++){
            if (count[i] > 0){
                uniq++;
            }
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(sb.length() < uniq){
            for (int i = 0; i < 26; i++){
                int y = find(i, s, count, sb, idx);
                if (y > idx){
                    idx = y;
                    break;
                }
            }
        }

        return sb.toString();
    }

    private int find(int target, String s, int[] count, StringBuilder sb, int idx){
        if (count[target] == 0) return idx;

        int[] sum = new int[26];
        for (int i = idx; i < s.length(); i++){
            int n = s.charAt(i) - 'a';
            if (count[n] == 0){
                continue;
            }
            if (n == target){
                count[n] = 0;
                sb.append(s.charAt(i));
                idx = i + 1;
                break;
            }
            if (++sum[n] == count[n]){
                return idx;
            }
        }
        for (int i = 0; i < 26; i++){
            count[i] -= sum[i];
        }

        return idx;
    }
}
