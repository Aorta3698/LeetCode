class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        for (int i = 0; i < chars.length; i++){
            int j = i + 1;
            while(j < chars.length && chars[j] == chars[i]){
                ++j;
            }
            int d = (int)Math.log10(j - i) + 1;
            int m = j - i, tmp = d;
            chars[ans] = chars[i];
            while(d > 0 && j - i > 1){
                chars[ans + d--] = (char)('0' + m % 10);
                m /= 10;
            }
            ans += j - i > 1? tmp + 1 : 1;
            i = j - 1;
        }
        return ans;
    }
}
