class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < 26; i++){
            if (count[i] > 0){
                maxheap.offer(count[i]);
            }
        }

        int ans = 0;
        while(maxheap.size() > 1){
            int cur = maxheap.poll();
            if (cur == maxheap.peek()){
                ans++;
                if (--cur > 0){
                    maxheap.offer(cur);
                }
            }
        }

        return ans;
    }
}
