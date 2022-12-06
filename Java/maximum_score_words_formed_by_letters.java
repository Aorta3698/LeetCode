class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = getCount(letters);
        int[] wScore = new int[words.length];
        int[][] wCount = new int[words.length][26];
        for (int i = 0; i < words.length; i++){
            char[] arr = words[i].toCharArray();
            wScore[i] = getScore(arr, score);
            wCount[i] = getCount(arr);
        }

        return dfs(0, count, wScore, wCount, 0);
    }

    private int dfs(int idx, int[] count, int[] wScore, int[][] wCount, int key){
        if (idx >= wScore.length) return 0;

        int max = 0;
        for (int i = idx; i < wScore.length; i++){
            int score = 0;
            if ((key & (1 << i)) == 0 && canTake(count, wCount[i])){
                score += (wScore[i] + dfs(i + 1, take(count, wCount[i]), wScore, wCount, key | (1 << i)));
                max = Math.max(score, max);
            }
        }

        return max;
    }

    private static int[] take(int[] count, int[] wCount){
        int[] copy = count.clone();
        for (int i = 0; i < 26; i++) copy[i] -= wCount[i];
        return copy;
    }

    private static boolean canTake(int[] count, int[] wCount){
        for (int i = 0; i < 26; i++)
            if (wCount[i] > count[i])
                return false;
        return true;
    }

    private static int getScore(char[] arr, int[] score){
        int sum = 0;
        for (char ch : arr) sum += score[ch - 'a'];
        return sum;
    }

    private static int[] getCount(char[] arr){
        int[] count = new int[26];
        for (char ch : arr) count[ch - 'a']++;
        return count;
    }
}
