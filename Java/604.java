class StringIterator {

    private char[] words;
    private int[] cnt;
    private int idx;
    public StringIterator(String compressedString) {
        idx = 0;
        words = new char[1001];
        cnt = new int[1001];
        int i = 0, n = compressedString.length(), j = 0;;
        while (i < n - 1){
            words[j] = compressedString.charAt(i);

            char ch = compressedString.charAt(++i);
            int sum = 0;
            while(Character.isDigit(ch)){
                sum *= 10;
                sum += ch - '0';
                if (i == n - 1) break;
                ch = compressedString.charAt(++i);
            }

            cnt[j++] = sum;
        }
    }

    public char next() {
        if (words[idx] == Character.MIN_VALUE) return ' ';

        return --cnt[idx] == 0? words[idx++] : words[idx];
    }

    public boolean hasNext() {
        return words[idx] != Character.MIN_VALUE;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
