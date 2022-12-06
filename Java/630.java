class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(o -> o[1]));
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        int curTime = 0;
        for (int[] c : courses){
            curTime += c[0];
            if (curTime<=c[1]){
                maxheap.offer(c[0]);
            }else{
                maxheap.offer(c[0]);
                curTime -= maxheap.poll();
            }
        }
        return maxheap.size();
    }
}
