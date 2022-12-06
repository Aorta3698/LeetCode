class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            if (entry.getValue().size() == edges.length){
                return entry.getKey();
            }
        }

        return -1;
    }
}
