class Solution {
    public int calculateTime(String keyboard, String word) {
        int sum = 0;
        int prev = 0;
        for (int i = 0; i < word.length(); i++){
            int cur = keyboard.indexOf(word.charAt(i));
            sum += Math.abs(cur - prev);
            prev = cur;
        }

        return sum;
    }
}
