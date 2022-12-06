class Solution {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        int[] count = new int[26];
        for (char ch : arr) count[ch - 'A']++;

        int ans = 0;
        for (int i = 1; i <= arr.length; i++)
            ans += gen(arr, i, count, 0);

        return ans;
    }

    private int gen(char[] arr, int len, int[] count, int cur){
        if (cur == len) return 1;

        int sum = 0;
        for (int i = 0; i < 26; i++){
            if (count[i] == 0) continue;
            count[i]--;
            sum += gen(arr, len, count, cur + 1);
            count[i]++;
        }

        return sum;
    }
}
