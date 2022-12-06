https://leetcode.com/problems/minimum-unique-word-abbreviation/discuss/2391921/Java-or-Binary-Search-%2B-Backtracking-or-33ms
class Solution {
    String[] dict;
    int n;
    public String minAbbreviation(String target, String[] dictionary) {
        n = target.length();
        dict = Arrays.stream(dictionary).filter(o -> o.length() == n).toArray(String[]::new);
        String[] ans = new String[n];
        Arrays.fill(ans, "");
        int lo = 1, hi = n;
        while(lo < hi){
            int mid = (lo+hi)>>1;
            for (int mode : new int[]{0, 1}) if (ans[mid].isEmpty()){
                ans[mid]=solve(0, 0, mid, mode, target, new StringBuilder());
            }
            if (!ans[mid].isEmpty()){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo==n?target:ans[lo];
    }

    private String solve(int idx, int len, int mxLen, int mode, String target, StringBuilder sb){
        if (len + n-idx < mxLen || len > mxLen){
            return "";
        }
        if (idx == n){
            return check(sb.toString());
        }
        int sz = sb.length();
        for (int i = idx; i < n; i++){
            String res = "";
            if (mode == 0){
                sb.append(target.substring(idx, i+1));
                res = solve(i+1, len+i-idx+1, mxLen, mode^1, target, sb);
            }else{
                sb.append(i-idx+1);
                res = solve(i+1, len+1, mxLen, mode^1, target, sb);
            }
            if (!res.isEmpty()){
                return res;
            }
            sb.setLength(sz);
        }
        return "";
    }

    private String check(String s){
        for (String l : dict){
            boolean same = true;
            for (int i = 0, j = 0; i < s.length(); i++){
                if (Character.isDigit(s.charAt(i))){
                    int end = i==s.length()-1 || !Character.isDigit(s.charAt(i+1))? i : i+1;
                    j+=Integer.parseInt(s.substring(i, end+1));
                    i=end;
                }else if (s.charAt(i) == l.charAt(j)){
                    j++;
                }else{
                    same = false;
                    break;
                }
            }
            if (same){
                return "";
            }
        }
        return s;
    }
}
