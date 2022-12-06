https://leetcode.com/problems/shortest-distance-to-a-character/discuss/1636571/Java-Simple-BFS
class Solution {
    public int[] shortestToChar(String s, char c) {
        Queue<Integer> queue = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == c)
                queue.offer(i);

        int step = 0;
        boolean[] visited = new boolean[arr.length];
        while(!queue.isEmpty()){
            int size = queue.size();
            while(--size >= 0){
                int cur = queue.poll();
                if (cur < 0 || cur == arr.length || visited[cur]) continue;
                visited[cur] = true;
                ans[cur] = step;
                queue.offer(cur + 1);
                queue.offer(cur - 1);
            }
            step++;
        }

        return ans;
    }
}
