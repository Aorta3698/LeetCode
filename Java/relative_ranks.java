https://leetcode.com/problems/relative-ranks/discuss/1634944/Java-5-lines-PriorityQueue-Comments
class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(score[b], score[a]));
        for (int i = 0; i < score.length; i++) maxheap.offer(i);
        String[] ans = new String[score.length], medal = {"", "Gold Medal", "Silver Medal", "Bronze Medal"};
        int rank = 0;
        while(!maxheap.isEmpty()) ans[maxheap.poll()] = ++rank <= 3? medal[rank] : String.valueOf(rank);

        return ans;
    }
}
