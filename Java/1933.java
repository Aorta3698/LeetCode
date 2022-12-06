class Solution {
    public boolean isDecomposable(String s) {
        char prev = s.charAt(0);
        int cnt = 0, base = 1002;
        for (char ch : s.toCharArray()){
            if (ch != prev){
                if (cnt % 3 == 1) return false;
                if (cnt % 3 == 2) cnt += base;
                cnt = (cnt / base) * base;
            }
            cnt++;
            prev = ch;
        }

        if (cnt % 3 == 2) cnt += base;
        if (cnt % 3 == 1) return false;
        return 2 * base > cnt && cnt >= base;
    }
}
