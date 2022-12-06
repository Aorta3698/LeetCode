https://leetcode.com/problems/design-a-leaderboard/discuss/1653621/Java-Weekly-Ques-TreeMap-With-Comments
class Leaderboard {

    private TreeMap<Integer, Integer> map;
    private Map<Integer, Integer> id;
    public Leaderboard() {
        map = new TreeMap<>(Comparator.reverseOrder());
        id = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (id.containsKey(playerId)){
            map.merge(id.get(playerId) + score, 1, Integer::sum);
            map.merge(id.get(playerId), -1, Integer::sum);
            id.put(playerId, id.get(playerId) + score);
        }else{
            id.put(playerId, score);
            map.merge(score, 1, Integer::sum);
        }
    }

    public int top(int K) {
        int sum = 0;
        for (int key : map.keySet()){
            if (K >= 0){
                int t = Math.min(K, map.get(key));
                sum += t * key;
                K -= t;
            }else
                break;
        }

        return sum;
    }

    public void reset(int playerId) {
        if (id.containsKey(playerId)){
            map.merge(id.get(playerId), -1, Integer::sum);
            id.remove(playerId);
        }
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
