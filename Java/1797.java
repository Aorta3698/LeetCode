https://leetcode.com/problems/design-authentication-manager/discuss/1871830/Deque-%2B-HashMap-Java
class AuthenticationManager {

    int inc;
    Map<String, Integer> expireMap;
    Deque<Item> deque;

    public AuthenticationManager(int timeToLive) {
        deque = new ArrayDeque<>();
        expireMap = new HashMap<>();
        inc = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        expireMap.put(tokenId, currentTime + inc);
        deque.offerLast(new Item(tokenId, currentTime + inc));
    }

    public void renew(String tokenId, int currentTime) {
        update(currentTime);
        if (expireMap.containsKey(tokenId)){
            deque.offerLast(new Item(tokenId, currentTime + inc));
            expireMap.put(tokenId, currentTime + inc);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        update(currentTime);
        return expireMap.size();
    }

    private void update(int curTime){
        while(!deque.isEmpty() && deque.peekFirst().time <= curTime){
            String id = deque.peekFirst().id;
            int time = deque.peekFirst().time;
            if (expireMap.containsKey(id) && expireMap.get(id).equals(time)){
                expireMap.remove(deque.pollFirst().id);
            }else{
                deque.pollFirst();
            }
        }
    }

    private class Item{
        String id;
        int time;
        Item(String id, int time){
            this.id = id;
            this.time = time;
        }
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
