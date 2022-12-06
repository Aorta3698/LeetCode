class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0, n = word.length(), m = abbr.length();
        char[] w = word.toCharArray(), a = abbr.toCharArray();
        while(i < n && j < m){
            if (Character.isAlphabetic(a[j]) && w[i] != a[j] || a[j] == '0') return false;
            if (Character.isAlphabetic(a[j]) && w[i] == a[j]){i++; j++; continue;}
            int sum = a[j] - '0';
            while(j < m - 1 && Character.isDigit(a[j + 1])){
                sum *= 10;
                sum += a[++j] - '0';
            }
            i += sum;
            j++;
        }

        return i == n && j == m;
    }
}
