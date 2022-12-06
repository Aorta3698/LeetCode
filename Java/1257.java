class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> map = new HashMap<>();
        for (List<String> r : regions){
            for (int i = 1; i < r.size(); i++){
                map.put(r.get(i), r.get(0));
            }
        }

        Set<String> parent = new HashSet<>();
        String p = region1;
        while(p != null){
            parent.add(p);
            p = map.get(p);
        }

        p = region2;
        while(p != null){
            if (!parent.add(p)){
                break;
            }
            p = map.get(p);
        }

        return p;
    }
}
