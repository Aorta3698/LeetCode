https://leetcode.com/problems/next-closest-time/discuss/1949109/Java-or-Concise-BackTracking-or-with-comments
class Solution {
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        for (char ch : time.toCharArray()){
            if (Character.isDigit(ch)){
                set.add(ch - '0');
            }
        }

        List<String> all = new ArrayList<>();
        solve(0, set, all, new StringBuilder());
        all.sort(Comparator.comparingInt(o -> parse(o)));
        for (int i = 0; true; i++){
            if (time.equals(all.get(i)))
                return all.get((i + 1) % all.size());
        }
    }

    private void solve(int cur, Set<Integer> list, List<String> all, StringBuilder sb){
        if (cur >= 60 || sb.length() == 2 && cur >= 24)
            return;
        if (sb.length() == 5){
            all.add(sb.toString());
            return;
        }
        if (sb.length() == 2){
            sb.append(':');
            cur = 0;
        }
        int sz = sb.length();
        for (int n : list){
            sb.append(n);
            solve(10 * cur + n, list, all, sb);
            sb.setLength(sz);
        }
    }

    private int parse(String s){
        return 60 * Integer.parseInt(s.substring(0, 2)) + Integer.parseInt(s.substring(3));
    }
}
