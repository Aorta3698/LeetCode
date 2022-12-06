class Solution {
    public int countVowelStrings(int n) {
        int[] count = new int[5];
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++){
            for (int j = 3; j >= 0; j--){
                count[j] += count[j+1];
            }
        }
        return Arrays.stream(count).sum();
    }
}
