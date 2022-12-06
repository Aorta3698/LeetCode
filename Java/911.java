class TopVotedCandidate {

    private TreeMap<Integer, Integer> data = new TreeMap<>();
    int max = 0;

    public TopVotedCandidate(int[] persons, int[] times) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < persons.length; i++){
            int cur = map.merge(persons[i], 1, Integer::sum);
            if (cur < max) continue;
            if (cur > max){
                max++;
            }
            data.put(times[i], persons[i]);
        }
    }

    public int q(int t) {
        return data.floorEntry(t).getValue();
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
