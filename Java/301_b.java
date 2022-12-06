class SmallestInfiniteSet {

    PriorityQueue<Integer> minheap;
    boolean[] used;
    public SmallestInfiniteSet() {
        minheap = new PriorityQueue<>();
        minheap.offer(1);
        used=new boolean[1002];
    }

    public int popSmallest() {
        int ans = minheap.poll();
        if (minheap.isEmpty()){
            minheap.offer(ans+1);
        }
        used[ans]=true;
        return ans;
    }

    public void addBack(int num) {
        if (used[num]){
            used[num]=false;
            minheap.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
