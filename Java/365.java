https://leetcode.com/problems/water-and-jug-problem/discuss/2014729/2-Solution-GCD-or-BFS-or-Concise-Java
class Solution {
    public boolean canMeasureWater(int A, int B, int T) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if (cur == T)
                return true;
            for (int k : new int[]{A, B, -A, -B}){
                if (seen.contains(cur + k) || cur > A + B || cur < 0)
                    continue;
                seen.add(cur + k);
                queue.offer(cur + k);
            }
        }

        return false;
    }
}

// BETTER SOLUTOIN HERE
class Solution {
    public boolean canMeasureWater(int A, int B, int T) {
        return T % gcd(A, B) == 0 && T <= A + B;
    }

    private int gcd(int a, int b){
        return a == 0? b : gcd(b % a, a);
    }
}
