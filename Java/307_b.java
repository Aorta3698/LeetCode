class Solution {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        for (char ch : num.toCharArray()){
            count[ch-'0']++;
        }
        StringBuilder sb = new StringBuilder();
        int mid = -1;
        for (int i = 9; i >= 0; i--){
            if (count[i] % 2 == 1 && mid == -1){
                mid = i;
            }
            if (count[i] >= 2 && (i > 0 || sb.length()>0)){
                sb.append((""+i).repeat(count[i]/2));
            }
        }
        if (mid == -1 && sb.length() == 0){
            return "0";
        }
        if (mid >= 0){
            return sb.toString()+mid+sb.reverse().toString();
        }else{
            return sb.toString()+sb.reverse().toString();
        }
    }
}
