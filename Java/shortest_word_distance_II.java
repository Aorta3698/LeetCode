class WordDistance {

    Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++){
            List<Integer> t = map.getOrDefault(wordsDict[i], new ArrayList<>());
            t.add(i);
            map.put(wordsDict[i], t);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> a = map.get(word1);
        List<Integer> b = map.get(word2);
        int min = Integer.MAX_VALUE;

        int idx = 0;
        int idy = 0;
        int dis = 0;

        while(idx < a.size() && idy < b.size()){
            dis = a.get(idx) - b.get(idy);
            min = Math.min(min, Math.abs(dis));
            if (dis > 0) idy++;
            if (dis < 0) idx++;
        }

        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
