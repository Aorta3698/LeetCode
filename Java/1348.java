class TweetCounts {

    Map<String, List<Integer>> map;
    public TweetCounts() {
        map = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        map.computeIfAbsent(tweetName, o -> new ArrayList<>()).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int interval = switch(freq){
            case "minute" : yield 60;
            case "hour"   : yield 3600;
            case "day"    : yield 86400;
            default: yield 0;
        };

        List<Integer> ans = new ArrayList<>();
        List<Integer> cur = map.getOrDefault(tweetName, List.of());
        for (int i = 0; i < (endTime - startTime) / interval + 1; i++){
            ans.add(0);
        }
        for (int n : cur){
            if (n > endTime || n < startTime){
                continue;
            }
            int j = (n - startTime) / interval;
            ans.set(j, ans.get(j) + 1);
        }

        return ans;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
