https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/2234608/Java-or-O(n)-or-A-Stack-Solution
class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = -1;
        for (int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[i]<stack.peek()){
                stack.pop();
            }
            if (arr[i]>=max){
                stack.push(max);
            }
            max=Math.max(arr[i],max);
        }
        return stack.size();
    }
}
