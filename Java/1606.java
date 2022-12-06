class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] got = new int[k];
        int[] time = new int[k];
        BitSet bit = new BitSet();
        bit.set(0, k);
        var minheap = new PriorityQueue<Integer>(Comparator.comparingLong(o -> time[o]));
        for (int i = 0; i < arrival.length; i++){
            while(!minheap.isEmpty() && arrival[i] >= time[minheap.peek()]){
                bit.set(minheap.poll());
            }
            int j = i%k, idx = bit.nextSetBit(j);
            if (idx == -1){
                idx = bit.nextSetBit(0);
            }
            if (idx >= 0){
                time[idx]=arrival[i]+load[i];
                got[idx]++;
                minheap.offer(idx);
                bit.clear(idx);
            }
        }
        int max = Arrays.stream(got).max().getAsInt();
        return IntStream.range(0, k).filter(o -> got[o] == max).boxed().toList();
    }
}
