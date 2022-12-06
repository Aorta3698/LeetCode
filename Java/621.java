//a_a_a
        //ababab
        //what about aaabbbcc, n = 1?
        //a_a_a
        //ababacc is wrong
        //Lee's: https://leetcode.com/problems/rearrange-string-k-distance-apart/discuss/278269/Python-O(N)-solution
// optimal?
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char t : tasks){
            count[t - 'A']++;
        }

        Arrays.sort(count);
        int br = count[25] - 1;
        int slots = br * n;
        for (int i = 24; i >= 0; i--){
            slots -= Math.min(br, count[i]);
        }

        return Math.max(0, slots) + tasks.length;
    }
}

// priorityqueue + queue solution
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] count = new int[26];
        Queue<int[]> queue = new ArrayDeque<>();
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (char t : tasks){
            count[t - 'A']++;
        }
        for (int i = 0; i < 26; i++){
            if (count[i] > 0){
                maxheap.offer(new int[]{count[i], 0});
            }
        }

        ++n;
        while(maxheap.size() + queue.size() > 1){
            int[] cur = maxheap.poll();
            time = cur[1] > time? cur[1] : ++time;
            cur[1] = time + n;
            if (--cur[0] > 0){
                queue.offer(cur);
            }
            if (!queue.isEmpty() && (maxheap.isEmpty() || queue.peek()[1] == time + 1)){
                maxheap.offer(queue.poll());
            }
        }

        time = Math.max(maxheap.peek()[1], ++time);
        int remain = maxheap.peek()[0];
        return time + (remain - 1) * n;
    }
}
