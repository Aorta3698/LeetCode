https://leetcode.com/problems/add-bold-tag-in-string/discuss/1859111/Java-with-Rabin-Karp

class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean[] bold = new boolean[s.length() + 2]; // pad 2 spaces, one for the start, one for the end.
        for (String w : words){
            add(s, w, bold);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (!bold[i] && bold[i + 1]){ // i + 1 is the current index for boolean array
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (bold[i + 1] && !bold[i + 2]){
                sb.append("</b>");
            }
        }

        return sb.toString();
    }

    private void add(String s, String w, boolean[] bold){ // Rabin-Karp algo
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

// merge interval method (long)
class Solution {
    public String addBoldTag(String s, String[] words) {
        List<int[]> intervals = new ArrayList<>();
        for (String w : words){
            add(s, w, intervals);
        }

        intervals.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        int i = 0, sz = intervals.size();
        while(i < sz){
            int start = intervals.get(i)[0];
            int end = intervals.get(i++)[1];
            while(i < sz && end >= intervals.get(i)[0]){
                end = Math.max(end, intervals.get(i)[1]);
                i++;
            }
            merged.add(new int[]{start, end});
        }

        char[] ans = new char[7 * merged.size() + s.length()];
        i = 0; sz = merged.size();
        for (int j = 0, k = 0; i < s.length(); i++){
            if (j < sz && i == merged.get(j)[0]){
                ans[k++] = '<';
                ans[k++] = 'b';
                ans[k++] = '>';
            }

            ans[k++] = s.charAt(i);

            if (j < sz && i == merged.get(j)[1] - 1){
                j++;
                ans[k++] = '<';
                ans[k++] = '/';
                ans[k++] = 'b';
                ans[k++] = '>';
            }
        }

        return String.valueOf(ans);
    }

    private void add(String s, String w, List<int[]> intervals){
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
                intervals.add(new int[]{i - w.length(), i});
            }
            if (i < s.length()){
                sh = ((sh - h * s.charAt(i - w.length())) * p % m + s.charAt(i) + m) % m;
            }
        }
    }
}
