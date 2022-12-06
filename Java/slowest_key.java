class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char maxKey = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++){
            int time = releaseTimes[i] - releaseTimes[i-1];
            if (time > max){
                max = time;
                maxKey = keysPressed.charAt(i);
            }else if (time == max && keysPressed.charAt(i) > maxKey){
                maxKey = keysPressed.charAt(i);
            }
        }

        return maxKey;
    }
}
