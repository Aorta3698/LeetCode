class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String d : cpdomains){
            String[] info = d.split(" "), sub = info[1].split("\\.");
            String key = null;
            int count = Integer.parseInt(info[0]);
            for (int i = sub.length - 1; i >= 0; --i){
                key = key == null? String.join(".", sub[i]) : String.join(".", sub[i], key);
                map.merge(key, count, Integer::sum);
            }
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet())
            ans.add(entry.getValue() + " " + entry.getKey());

        return ans;
    }
}
