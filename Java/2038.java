class Solution {
    public boolean winnerOfGame(String colors) {
        int score = 0;
        char[] arr = colors.toCharArray();
        for (int i = 1; i < colors.length() - 1; i++){
            if (arr[i] == 'A' && arr[i] == arr[i - 1] && arr[i] == arr[i + 1]){
                score++;
            }
            if (arr[i] == 'B' && arr[i] == arr[i - 1] && arr[i] == arr[i + 1]){
                score--;
            }
        }

        return score > 0;
    }
}
