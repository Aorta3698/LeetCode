class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prev = 'x';
        for (char ch : countAndSay(n-1).toCharArray()){
            if (prev == ch || prev == 'x')
                count++;
            else{
                sb.append(count);
                sb.append(prev);
                count = 1;
            }
            prev = ch;
        }

        sb.append(count);
        sb.append(prev);

        return sb.toString();
    }
}
