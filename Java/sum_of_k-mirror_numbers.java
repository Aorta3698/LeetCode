class Solution {
    public long kMirror(int k, int n) {
        int count = 0;
        long ans = 0L;
        long cur = 0L;
        for (int i = 1; count < n; i++){
            int len = cur == 0? 1 : (int)Math.log10(cur) + 1;
            int offset = (int) Math.pow(10, len / 2);
            cur = palindromeGenerator(cur + offset, len);
            if (convert(k, cur)){
                ans += cur;
                count++;
            }
        }

        return ans;
    }
    private long palindromeGenerator(long num, int length) {
        if (num < 10) return num;

        int numOfDigits = (int)Math.log10(num) + 1;
        if (numOfDigits > length)
            return ((long) Math.pow(10, numOfDigits - 1) + 1);

        num = num - num % (long) Math.pow(10, numOfDigits / 2);
        long temp = num;
        for (int j = 0; j < numOfDigits / 2; j++) {
            long digit = (long) Math.pow(10, numOfDigits - j - 1);
            num += (int) ((temp / digit) * Math.pow(10, j));
            temp = temp % digit;
        }

        return num;
    }

    private boolean convert(int base, long num){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(num % base);
            num /= base;
        }

        return verify(sb.toString());
    }

    private boolean verify(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }
}
