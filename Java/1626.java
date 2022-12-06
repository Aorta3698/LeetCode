class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Player[] all = new Player[n];
        for (int i = 0; i < n; i++){
            all[i] = new Player(scores[i], ages[i]);
        }
        Arrays.sort(all, (a, b) -> a.age == b.age? a.score - b.score : a.age - b.age);

        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = i - 1; j >= 0; j--){
                if (all[j].score <= all[i].score){
                    all[i].best = Math.max(all[i].best, all[j].best + all[i].score);
                }
            }
            ans = Math.max(ans, all[i].best);
        }

        return ans;
    }

    private class Player{
        int score;
        int age;
        int best;
        Player(int score, int age){
            this.score = score;
            this.age = age;
            this.best = score;
        }
    }
}
