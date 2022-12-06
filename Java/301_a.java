class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        for (int n : amount){
            if (n>0)
            maxheap.offer(n);
        }
        int ans = 0;
        while(!maxheap.isEmpty()){
            int a = maxheap.poll();
            int b = 0;
            if (maxheap.size()>0){
                b = maxheap.poll();
            }
            if (--a>0){
                maxheap.offer(a);
            }
            if (--b>0){
                maxheap.offer(b);
            }
            ans++;
        }
        return ans;
    }
}
