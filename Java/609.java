class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String p : paths){
            String[] all = p.split(" ");
            for (int i = 1; i < all.length; i++){
                int start = all[i].lastIndexOf("(");
                String key = all[i].substring(start);
                StringBuilder sb = new StringBuilder(all[0]);
                sb.append('/');
                sb.append(all[i].substring(0, start));
                map.computeIfAbsent(key, o -> new ArrayList<>()).add(sb.toString());
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet())
            if (map.get(key).size() > 1)
                ans.add(map.get(key));

        return ans;
    }
}
