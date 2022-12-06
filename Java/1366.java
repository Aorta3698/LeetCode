class Solution {
    public String rankTeams(String[] votes) {
        int n = votes.length, m = votes[0].length();
        Map<Character, A> map = new HashMap<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                char ch = votes[j].charAt(i);
                map.computeIfAbsent(ch, o -> new A(ch, m)).scores[i]++;
            }
        }

        List<A> list = new ArrayList<>(map.values());
        Collections.sort(list, (a, b) -> {
            for (int i = 0; i < a.scores.length; i++){
                if (a.scores[i] != b.scores[i]){
                    return b.scores[i] - a.scores[i];
                }
            }
            return a.ch - b.ch;
        });

        StringBuilder sb = new StringBuilder();
        for (A team : list){
            sb.append(team.ch);
        }

        return sb.toString();
    }

    private class A{
        char ch;
        int[] scores;
        A(char ch, int n){
            this.ch = ch;
            this.scores = new int[n];
        }
    }
}
