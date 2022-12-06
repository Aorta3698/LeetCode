class Solution {
    public List<Integer> peopleIndexes(List<List<String>> fav) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i < fav.size(); i++){
            map.put(i, new HashSet<>(fav.get(i)));
        }

        for (int i = 0; i < fav.size(); i++){
            boolean add = true;
            for (int j = 0; j < fav.size() && add; j++){
                if (i == j) continue;
                Set<String> list = map.get(j);
                int k;
                for (k = 0; k < fav.get(i).size(); k++){
                    if (!list.contains(fav.get(i).get(k))){
                        break;
                    }
                }
                if (k == fav.get(i).size()){
                    add = false;
                }
            }
            if (add){
                ans.add(i);
            }
        }

        return ans;
    }
}
