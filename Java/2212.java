class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] ans = new int[12];
        backtrack(numArrows, 1, ans, new int[12], aliceArrows);

        int sum = Arrays.stream(ans).sum();
        for (int i = 1; i < 12; i++){
            if (ans[i] > 0){
                ans[i] += (numArrows - sum);
                break;
            }
        }

        return ans;
    }

    private void backtrack(int free, int i, int[] ans, int[] tmp, int[] alice){
        if (i == 12 && getScore(tmp) > getScore(ans)){
            System.arraycopy(tmp, 0, ans, 0, 12);
        }
        if (i == 12){
            return;
        }
        if (alice[i] < free){
            tmp[i] = alice[i] + 1;
            backtrack(free - alice[i] - 1, i + 1, ans, tmp, alice);
            tmp[i] = 0;
        }
        backtrack(free, i + 1, ans, tmp, alice);
    }

    private int getScore(int[] arr){
        int score = 0;
        for (int i = 0; i < 12; i++){
            if (arr[i] > 0){
                score += i;
            }
        }
        return score;
    }
}
