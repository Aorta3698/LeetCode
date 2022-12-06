class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++){
            int cur = asteroids[i];
            if (cur < 0){
                boolean present = true;
                int prev = stack.isEmpty()? 0 : asteroids[stack.peek()];
                while(present && prev > 0 && -cur >= prev){
                    if (asteroids[stack.pop()] == -cur) present = false;
                    prev = stack.isEmpty()? 0 : asteroids[stack.peek()];
                }
                if (prev <= 0 && present) stack.push(i);
            }else{
                stack.push(i);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++){
            ans[i] = asteroids[stack.pollLast()];
        }

        return ans;
    }
}
