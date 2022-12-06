class Solution {
    public List<Integer> splitIntoFibonacci(String s) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; i++){
            ans.clear();
            long first = parse(s.substring(0, i + 1));
            ans.add((int)first);
            if (first > Integer.MAX_VALUE || i > 0 && s.charAt(0) == '0')
                break;
            for (int j = i + 1; j < s.length() - 1; j++){
                long second = parse(s.substring(i + 1, j + 1));
                if (second > Integer.MAX_VALUE || j > i + 1 && s.charAt(i + 1) == '0')
                    break;
                ans.add((int)second);
                if (check(j + 1, s, first, second, ans))
                    return ans;
                ans.clear();
                ans.add((int)first);
            }
        }
        return List.of();
    }

    private long parse(String s){
        return Long.parseLong(s);
    }

    private boolean check(int k, String s, long first, long second, List<Integer> ans){
        if (k == s.length())
            return true;
        long next = first + second;
        String n = String.valueOf(next);
        if (next > Integer.MAX_VALUE || !s.substring(k).startsWith(n))
            return false;
        ans.add((int)next);
        return check(k + n.length(), s, second, next, ans);
    }
}
