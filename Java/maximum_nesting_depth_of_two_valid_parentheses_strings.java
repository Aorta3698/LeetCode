class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        char[] arr = seq.toCharArray();
        int[] ans = new int[arr.length];
        int[] depth = new int[arr.length];
        int maxDepth = getDepth(arr, depth);
        for (int i = 0; i < depth.length; i++)
            if (depth[i] <= maxDepth / 2)
                ans[i] = 1;

        return ans;
    }

    private int getDepth(char[] arr, int[] depth){
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == '(') stack.push(i);
            if (arr[i] == ')'){
                max = Math.max(stack.size(), max);
                depth[i] = depth[stack.peek()] = stack.size();
                stack.poll();
            }
        }

        return max;
    }
}
