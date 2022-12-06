class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        Comparator<Integer> comp = Comparator.comparingInt(o -> aliceValues[o] + bobValues[o]);
        comp = comp.reversed();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(comp);
        for (int i = 0; i < aliceValues.length; i++) maxheap.offer(i);

        int ans = 0;
        boolean myTurn = true;
        while(!maxheap.isEmpty()){
            if (myTurn) ans += aliceValues[maxheap.poll()];
            else ans -= bobValues[maxheap.poll()];
            myTurn = !myTurn;
        }

        return ans == 0? ans : ans > 0? 1 : -1;
    }
}
