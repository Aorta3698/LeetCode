class Solution {
    public String maximumNumber(String num, int[] change) {
        StringBuilder sb = new StringBuilder();
        int st = -1, end = num.length();
        for (int i = 0; i < num.length(); i++){
            int d = num.charAt(i) - '0';
            if (d < change[d] && st == -1){
                st = i;
            }
            if (st > -1 && change[d] < d){
                end = i;
                break;
            }
            if (st > -1){
                sb.append(change[d]);
            }
        }
        return st == -1?
            num :
            num.substring(0, st) + sb.toString() + num.substring(end);
    }
}
