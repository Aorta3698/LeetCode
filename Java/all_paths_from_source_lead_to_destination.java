class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges){
            if (e[0] == destination) return false;
            if (!map.containsKey(e[0])) map.put(e[0], new ArrayList<>());
            map.get(e[0]).add(e[1]);
        }

        return traverse(new boolean[n], source, destination, map);
    }

    private boolean traverse(boolean[] seen, int start, int end, HashMap<Integer, List<Integer>> map){
        if (start == end) return true;
        if (seen[start]) return false;
        if (map.get(start) == null) return false;

        seen[start] = true;
        for (int nei : map.get(start)){
            if(!traverse(seen, nei, end, map))
                return false;
        }
        seen[start] = false;
        return true;
    }
}
