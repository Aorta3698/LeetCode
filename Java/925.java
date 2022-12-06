class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0, n = name.length(), m = typed.length();
        while(i < n && j < m){
            if (name.charAt(i) != typed.charAt(j)) return false;
            int cnt = 0;
            while(i + cnt < n && name.charAt(i + cnt) == name.charAt(i))
                cnt++;
            i = i + cnt;
            while(j < m - 1 && typed.charAt(j + 1) == typed.charAt(j)){cnt--; j++;}
            j++;
            if (cnt > 1) return false;
        }

        return i == n && j == m;
    }
}
