https://leetcode.com/problems/minimum-window-substring/discuss/1622019/Java-or-Two-Pointers-or-Detailed-Explanations
class Solution {
    public String minWindow(String s, String t) {
        int[] req = new int[60];
        Arrays.fill(req, Integer.MIN_VALUE);
        for (char ch : t.toCharArray()) req[ch - 'A'] = Math.max(++req[ch - 'A'], 1);

        int startIdx = -1, endIdx = 0;
        int bestS = -1, bestE = s.length() - 1;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++){
            if (req[arr[i] - 'A'] <= Integer.MIN_VALUE / 2) continue;

            startIdx = startIdx == -1? i : startIdx;
            req[arr[i] - 'A']--;

            if (found(req)){
                endIdx = i;
                while(startIdx < endIdx && req[arr[startIdx] - 'A'] < 0)
                    req[arr[startIdx++] - 'A']++;

                if (bestE - bestS > endIdx - startIdx) {bestE = endIdx; bestS = startIdx;}
                req[arr[startIdx++] - 'A']++;
            }
        }

        return bestS == -1? "" : s.substring(bestS, bestE + 1);
    }

    private boolean found(int[] req){
        for (int r : req)
            if (r > 0)
                return false;
        return true;
    }
}
