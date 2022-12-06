class FileSharing {

    TreeMap<Integer, Set<Integer>> map;
    PriorityQueue<Integer> minheap;
    int hi;

    public FileSharing(int m) {
        map = new TreeMap<>();
        minheap = new PriorityQueue<>(List.of(1));
        hi = 1;
    }

    public int join(List<Integer> ownedChunks) {
        int id = minheap.poll();
        map.put(id, new HashSet<>(ownedChunks));
        if (minheap.isEmpty()){
            minheap.offer(++hi);
        }
        return id;
    }

    public void leave(int userID) {
        map.remove(userID);
        minheap.offer(userID);
    }

    public List<Integer> request(int userID, int chunkID) {
        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()){
            if (map.get(key).contains(chunkID)){
                ans.add(key);
            }
        }
        if (!ans.isEmpty()){
            map.get(userID).add(chunkID);
        }
        return ans;
    }
}

/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
 */
