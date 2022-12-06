https://leetcode.com/problems/maximum-score-of-a-node-sequence/discuss/2193581/Java-PriorityQueue
class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        PriorityQueue<Integer>[] minheap = new PriorityQueue[scores.length];
        Comparator<Integer> cmp = Comparator.comparingInt(o -> scores[o]);
        Arrays.setAll(minheap, o -> new PriorityQueue<>(cmp));
        for (int[] e : edges){
            minheap[e[0]].offer(e[1]);
            minheap[e[1]].offer(e[0]);
            if (minheap[e[0]].size()>3){
                minheap[e[0]].poll();
            }
            if (minheap[e[1]].size()>3){
                minheap[e[1]].poll();
            }
        }

        int ans = -1;
        for (int[] e : edges){
            for (int x : minheap[e[0]]){
                if (x != e[1]){
                    for (int y : minheap[e[1]]){
                        if (y != e[0] && y != x){
                            ans = Math.max(ans, scores[x] + scores[y] + scores[e[0]] + scores[e[1]]);
                        }
                    }
                }
            }
        }

        return ans;
    }
}
