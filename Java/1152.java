class Solution {
    private int MAX = (int)1e9 + 1;
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<String, Map<String, TreeSet<Integer>>> map = new HashMap<>();

        for (int i = 0; i < username.length; i++){
            map.computeIfAbsent(username[i], o -> new HashMap<>())
               .computeIfAbsent(website[i], o -> new TreeSet<>())
               .add(timestamp[i]);
            set.add(website[i]);
        }

        int max = 0;
        for (String a : set){
            for (String b : set){
                for (String c : set){
                    int score = 0;
                    for (String name : map.keySet()){
                        Map<String, TreeSet<Integer>> hist = map.get(name);
                        int time = next(hist.get(a), 0) + (a.equals(b)? 1 : 0);
                        time = next(hist.get(b), time) + (b.equals(c)? 1 : 0);
                        time = next(hist.get(c), time);
                        if (time < MAX){
                            score++;
                        }
                    }
                    if (score > max || score == max && compare(a, b, c, ans)){
                        max = score;
                        ans.clear();
                        ans.add(a);
                        ans.add(b);
                        ans.add(c);
                    }
                }
            }
        }

        return ans;
    }

    private int next(TreeSet<Integer> set, int start){
        if (set == null) return MAX;
        Integer ret = set.ceiling(start);
        return ret == null? MAX : ret;
    }

    private boolean compare(String a, String b, String c, List<String> ans){
        if (ans.isEmpty()) return true;
        int ret = a.compareTo(ans.get(0));
        if (ret != 0) return ret < 0;
        ret = b.compareTo(ans.get(1));
        if (ret != 0) return ret < 0;
        ret = c.compareTo(ans.get(2));
        return ret < 0;
    }
}
