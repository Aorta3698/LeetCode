class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source==target){
            return 0;
        }
        Map<Integer, List<Integer>> routeMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++){
            for (int n : routes[i]){
                routeMap.computeIfAbsent(n, o -> new ArrayList<>()).add(i);
            }
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] dest = new boolean[routes.length];
        boolean[] visited = new boolean[routes.length];
        for (int key : routeMap.keySet()){
            List<Integer> buses = routeMap.get(key);
            for (int i = 0; i < buses.size(); i++){
                for (int j = i+1; j < buses.size(); j++){
                    map.computeIfAbsent(buses.get(i), o -> new HashSet<>()).add(buses.get(j));
                    map.computeIfAbsent(buses.get(j), o -> new HashSet<>()).add(buses.get(i));
                }
                if (key==source){
                    queue.offer(buses.get(i));
                    visited[buses.get(i)]=true;
                }
                if (key==target){
                    dest[buses.get(i)]=true;
                }
            }
        }
        int ans = 1;
        while(!queue.isEmpty()){
            for (int sz = queue.size(); sz>0;sz--){
                int cur = queue.poll();
                if (dest[cur]){
                    return ans;
                }
                for (int next : map.getOrDefault(cur, Set.of())){
                    if (!visited[next]){
                        queue.offer(next);
                        visited[next]=true;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
