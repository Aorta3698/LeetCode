class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++){
            map.computeIfAbsent(keyName[i], o -> new HashMap<>())
               .merge(getTime(keyTime[i]), 1, Integer::sum);
        }

        List<String> ans = new ArrayList<>();
        for (String name : map.keySet()){
            Map<Integer, Integer> cur = map.get(name);
            for (int time : cur.keySet()){
                int sum = 0;
                for (int i = 0; i <= 60; i++){
                    sum += cur.getOrDefault(time + i, 0);
                }
                if (sum >= 3){
                    ans.add(name);
                    break;
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }

    private int getTime(String s){
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
    }
}
