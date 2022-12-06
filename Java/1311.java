class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new ArrayDeque<>(List.of(id));
        boolean[] seen = new boolean[101];
        seen[id] = true;

        while(level-- > 0 && !queue.isEmpty()){
            int sz = queue.size();
            while(--sz >= 0){
                int cur = queue.poll();
                for (int next : friends[cur]){
                    if (!seen[next]){
                        queue.offer(next);
                        seen[next] = true;
                    }
                }
            }
        }

        Map<String, Integer> map = new HashMap<>();
        while(!queue.isEmpty()){
            for (String s : watchedVideos.get(queue.poll())){
                map.merge(s, 1, Integer::sum);
            }
        }

        List<String> ans = new ArrayList<>(map.keySet());
        Collections.sort(ans, (a, b) ->
                map.get(a) == map.get(b)?
                a.compareTo(b) :
                Integer.compare(map.get(a), map.get(b))
        );

        return ans;
    }
}
