class Solution {
    public int numberOfWeakCharacters(int[][] A) {
        Arrays.sort(A, (a, b) -> a[1] == b[1]? a[0] - b[0] : b[1] - a[1]);
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < A.length; i++){
            while(!stack.isEmpty() && A[i][1] == A[stack.peek()][1]){
                stack.pop();
            }
            if (!stack.isEmpty() && A[i][1] < A[stack.peek()][1] && A[i][0] < A[stack.peek()][0]) ans++;
            else
                stack.push(i);
        }

        return ans;
    }
}
