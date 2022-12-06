class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < senders.length; i++){
            map.merge(senders[i], messages[i].split(" ").length, Integer::sum);
        }
        String ans = "";
        for (String key : map.keySet()){
            if (ans.isEmpty() || map.get(key) > map.get(ans) || map.get(key) == map.get(ans) && key.compareTo(ans) > 0){
                ans = key;
            }
        }
        return ans;
    }
}
