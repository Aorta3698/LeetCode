class Solution {
    public int largestVariance(String s) {
        int ans = 0;
        for (int i = 0 ;i < 26; i++){
            for (int j = i+1; j<26; j++){
                ans = Math.max(kadane(i, j, s), ans);
                ans = Math.max(kadane(j, i, s), ans);
            }
        }
        return ans;
    }

    private int kadane(int a, int b, String s){
        int score = 0, max = 0;
        boolean ok = false;
        boolean startWithB = false;
        for (char ch : s.toCharArray()){
            if (ch - 'a' == a){
                score++;
            }
            if (ch - 'a' == b){
                if (startWithB && score>=0){
                    startWithB=false;
                }else if (--score<0){
                    startWithB=true;
                    score=-1;
                }
                ok=true;
            }
            if (ok){
                max=Math.max(max, score);
            }
        }

        return max;
    }
}
