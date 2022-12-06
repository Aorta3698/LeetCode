https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/discuss/1941425/Java-or-Create-a-timeline-or-with-comments
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        minheap.offer(0);
        Person[] all = new Person[times.length * 2];
        for (int i = 0; i < times.length; i++){
            all[2 * i] = new Person(i, times[i][0], false, true);
            all[2 * i + 1] = new Person(i, times[i][1], true, false);
        }
        Arrays.sort(all, (a, b) -> {
            int i = a.leave? -1 : 1;
            int j = b.leave? -1 : 1;
            return a.time == b.time? i - j : a.time - b.time;
        });

        int[] seat = new int[times.length];
        for (int i = 0; true; i++){
            if (all[i].arrive){
                if (targetFriend == all[i].idx){
                    return minheap.peek();
                }
                seat[all[i].idx] = minheap.poll();
                if (minheap.isEmpty()){
                    minheap.offer(seat[all[i].idx] + 1);
                }
            }else{
                minheap.offer(seat[all[i].idx]);
            }
        }
    }

    private class Person {
        boolean leave;
        boolean arrive;
        int time;
        int idx;
        Person (int idx, int time, boolean leave, boolean arrive){
            this.time = time;
            this.leave = leave;
            this.arrive = arrive;
            this.idx = idx;
        }
    }
}
