https://leetcode.com/problems/reorganize-string/discuss/1859352/Java-or-heap-solution
class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()){
            count[ch - 'a']++;
        }

        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < 26; i++){
            if (count[i] > 0){
                maxheap.offer(new int[]{count[i], i});
            }
        }

        int[] prev = new int[2];
        StringBuilder sb = new StringBuilder();
        while(!maxheap.isEmpty()){
            int[] cur = maxheap.poll();
            sb.append((char)('a' + cur[1]));
            --cur[0];
            if (prev[0] > 0){
                maxheap.offer(prev);
            }
            prev = cur;
        }

        return prev[0] == 0? sb.toString() : "";
    }
}
