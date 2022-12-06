https://leetcode.com/problems/add-bold-tag-in-string/discuss/1859111/Java-with-Rabin-Karp
class Solution {
    public String boldWords(String[] words, String s) {
        boolean[] bold = new boolean[s.length() + 2];
        for (String w : words){
            add(s, w, bold);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (!bold[i] && bold[i + 1]){
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (bold[i + 1] && !bold[i + 2]){
                sb.append("</b>");
            }
        }

        return sb.toString();
    }

    private void add(String s, String w, boolean[] bold){
        if (w.length() > s.length()){
            return;
        }

        int p = 31, m = (int)1e9+7;
        long h = 1, sh = 0, wh = 0;
        for (int i = 0; i < w.length(); i++){
            if (i < w.length() - 1){
                h = h * p % m;
            }
            sh = (sh * p + s.charAt(i)) % m;
            wh = (wh * p + w.charAt(i)) % m;
        }

        for (int i = w.length(); i <= s.length(); i++){
            if (sh == wh){
                Arrays.fill(bold, i - w.length() + 1, i + 1, true);
            }
            if (i < s.length()){
                sh = ((sh - h * s.charAt(i - w.length())) * p % m + s.charAt(i) + m) % m;
            }
        }
    }
}
