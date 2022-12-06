class Solution {
    public int countValidWords(String sentence) {
        Set<Character> pSet = new HashSet<>(Set.of('!', '.', ','));
        char[] arr = sentence.toCharArray();
        int ans = 0, n = arr.length;
        for (int i = 0, w = 0, p = 0, h = 0, d = 0; i < n; i++){
            if (arr[i] == ' ' || i == n - 1){
                if (i == n - 1){
                    if (Character.isDigit(arr[i])) break;
                    if (arr[i] == '-') break;
                    if (pSet.contains(arr[i])) p++;
                    if (Character.isAlphabetic(arr[i])) w = 1;
                }
                if (h <= 1 && p <= 1 && d == 0)
                    ans += Math.max(w, p);
                p = h = w = d = 0;
                continue;
            }

            if (Character.isDigit(arr[i])) d = 1;
            if (Character.isAlphabetic(arr[i])) w = 1;
            if (arr[i] == '-') h += 2 - w;
            if (arr[i] == '-' && !Character.isAlphabetic(arr[i + 1])) h++;
            if (pSet.contains(arr[i])) p++;
            if (pSet.contains(arr[i]) && arr[i + 1] != ' ') p++;
        }

        return ans;
    }
}
