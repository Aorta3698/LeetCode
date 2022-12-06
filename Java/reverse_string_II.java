class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder ans = new StringBuilder();
        boolean reverse = true;
        for (int i = 0; i < s.length(); i+=k){
            StringBuilder sb = new StringBuilder();
            String seg = i+k > s.length()? s.substring(i) : s.substring(i, i + k);
            sb.append(seg);
            if (reverse) sb.reverse();
            ans.append(sb);
            reverse = !reverse;
        }

        return ans.toString();
    }
}
