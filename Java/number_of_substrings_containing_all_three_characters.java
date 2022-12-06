class Solution {
    public int numberOfSubstrings(String s) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == 'a') A.add(i);
            else if (ch == 'b') B.add(i);
            else C.add(i);
        }

        int ans = 0;
        int a = 0, b = 0, c = 0;

        for (char ch : s.toCharArray()){
            if (a >= A.size() || b >= B.size() || c >= C.size()) break;
            ans += s.length() - Math.max(A.get(a), Math.max(B.get(b), C.get(c)));
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;
        }

        return ans;
    }
}
