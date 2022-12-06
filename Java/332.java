https://leetcode.com/problems/reconstruct-itinerary/discuss/1723440/Java-or-Concise-or-100-Speed-4ms
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ans = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> t : tickets){
            map.computeIfAbsent(t.get(0), o -> new ArrayList<>()).add(t.get(1));
        }
        for (String key : map.keySet()){
            map.get(key).sort(Comparator.reverseOrder());
        }
        findPath(map, "JFK", ans);

        return ans;
    }

    private void findPath(Map<String, List<String>> map, String cur, LinkedList<String> ans){
        List<String> list = map.getOrDefault(cur, Collections.emptyList());
        while(!list.isEmpty()){
            findPath(map, list.remove(list.size() - 1), ans);
        }
        ans.addFirst(cur);
    }
}
