class VideoSharingPlatform {

    int[] likes;
    int[] dislikes;
    int[] views;
    PriorityQueue<Integer> minheap;
    Map<Integer, String> map;
    public VideoSharingPlatform() {
        likes = new int[100001];
        views = new int[100001];
        dislikes = new int[100001];
        minheap = new PriorityQueue<>();
        minheap.offer(0);
        map = new HashMap<>();
    }

    public int upload(String video) {
        int id = minheap.poll();
        if (minheap.isEmpty()){
            minheap.offer(id+1);
        }
        map.put(id, video);
        return id;
    }

    public void remove(int videoId) {
        if (map.containsKey(videoId)){
            map.remove(videoId);
            minheap.offer(videoId);
        }
    }

    public String watch(int videoId, int startMinute, int endMinute) {
        if (map.containsKey(videoId)){
            views[videoId]++;
            return map.get(videoId).substring(startMinute, Math.min(endMinute+1, map.get(videoId).length()));
        }
        return "-1";
    }

    public void like(int videoId) {
        if (map.containsKey(videoId)){
            likes[videoId]++;
        }
    }

    public void dislike(int videoId) {
        if (map.containsKey(videoId)){
            dislikes[videoId]++;
        }
    }

    public int[] getLikesAndDislikes(int videoId) {
        if (map.containsKey(videoId)){
            return new int[]{likes[videoId], dislikes[videoId]};
        }
        return new int[]{-1};
    }

    public int getViews(int videoId) {
        if (map.containsKey(videoId)){
            return views[videoId];
        }
        return -1;
    }
}

/**
 * Your VideoSharingPlatform object will be instantiated and called as such:
 * VideoSharingPlatform obj = new VideoSharingPlatform();
 * int param_1 = obj.upload(video);
 * obj.remove(videoId);
 * String param_3 = obj.watch(videoId,startMinute,endMinute);
 * obj.like(videoId);
 * obj.dislike(videoId);
 * int[] param_6 = obj.getLikesAndDislikes(videoId);
 * int param_7 = obj.getViews(videoId);
 */
