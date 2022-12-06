class Twitter {

    Map<Integer, Item> map;
    Map<Integer, Set<Integer>> following;
    int time = 0;

    public Twitter() {
        map = new HashMap<>();
        following = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Item item = new Item(tweetId, time++);
        item.next = map.get(userId);
        map.put(userId, item);
        follow(userId, userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Item> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));
        for (int f : following.getOrDefault(userId, Set.of())){
            if (map.containsKey(f)){
                maxheap.offer(map.get(f));
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!maxheap.isEmpty() && ans.size() < 10){
            Item cur = maxheap.poll();
            ans.add(cur.val);
            if (cur.next != null){
                maxheap.add(cur.next);
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, o -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId) && followerId != followeeId){
            following.get(followerId).remove(followeeId);
        }
    }

    private class Item{
        Item next;
        int val;
        int time;
        Item(int val, int time){
            this.val = val;
            this.time = time;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
