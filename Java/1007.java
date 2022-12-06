class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int goal = -1, n = tops.length, min = n;
        int[] t = new int[7], b = new int[7];

        for (int i = 0; i < tops.length; i++){
            if (tops[i] == bottoms[i]){
                if (goal != -1 && goal != tops[i]) {
                    return -1;
                }
                goal = tops[i];
                min++;
            }
            t[tops[i]]++;
            b[bottoms[i]]++;
        }

        int max = 0;
        for (int i = 1; i <= 6 && min == n; i++){
            if (t[i] + b[i] > max){
                max = t[i] + b[i];
                goal = i;
            }
        }

        return t[goal] + b[goal] >= min?
            Math.min(n - t[goal], n - b[goal]) : -1;
    }
}
