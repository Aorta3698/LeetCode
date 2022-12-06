class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int[] s = new int[128];
        for (char ch : suits){
            if (++s[ch]==5){
                return "Flush";
            }
        }
        int[] count = new int[15];
        for (int r : ranks){
            if (++count[r] == 3){
                return "Three of a Kind";
            }
        }
        for (int i = 0; i < 15; i++){
            if (count[i]==2){
                return "Pair";
            }
        }
        return "High Card";
    }
}
