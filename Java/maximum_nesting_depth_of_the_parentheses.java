class Solution {
    public int maxDepth(String s) {
        char[] arr = s.toCharArray();
        return getMax(arr, 0, arr.length - 1);
    }

    private int getMax(char[] arr, int s, int e){
        int start = -1;
        int len, ans = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = s; i <= e; i++){
            if (arr[i] == '('){
                if (stack.isEmpty()) start = i;
                stack.push(arr[i]);
            }

            if (arr[i] == ')'){
                stack.pop();
                if (stack.isEmpty()){
                    len = 1 + getMax(arr, start + 1, i - 1);
                    ans = Math.max(ans, len);
                }
            }
        }

        if (start == -1) return 0;
        return ans;
    }
}
