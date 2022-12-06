https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/discuss/1869426/Java-or-Binary-Search-and-BackTracking-99-at-4ms
class Solution {
    public int maxUniqueSplit(String s) {
        int lo = 1, hi = s.length();
        while(lo < hi){
            int mid = (lo + hi + 1) >> 1;
            if (ok(0, mid, 0, s, new HashSet<>())){
                lo = mid;
            }else{
                hi = mid - 1;
            }
        }

        return lo;
    }

    private boolean ok(int depth, int end, int curLen, String s, Set<String> seen){
        if (depth == end){
            return true;
        }

        for (int j = curLen; j < s.length(); j++){
            if (s.length() - j < end - depth){
                break;
            }
            String cur = s.substring(curLen, j + 1);
            if (seen.add(cur)){
                if (ok(depth + 1, end, j + 1, s, seen)){
                    return true;
                }
                seen.remove(cur);
            }
        }

        return false;
    }
}
