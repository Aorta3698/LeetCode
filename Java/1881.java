class Solution {
    public String maxValue(String n, int x) {
        int idx = n.length();
        int st = n.charAt(0) == '-'? 1 : 0;
        for (int i = st; i < n.length() && idx == n.length(); i++){
            if (st == 0 && x > n.charAt(i) - '0'){
                idx = i;
            }
            if (st == 1 && x < n.charAt(i) - '0'){
                idx = i;
            }
        }

        return n.substring(0, idx) + x + n.substring(idx);
    }
}
