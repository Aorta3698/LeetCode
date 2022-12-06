// intutive
class Solution {
    public int countCollisions(String s) {
        return check(s, 1) + check(s, -1);
    }

    private int check(String s, int dir){
        int add = 0, n = s.length(), c = dir == 1? 'L' : 'R', ans = 0;
        for (int i = dir == 1? 0 : n - 1; i >= 0 && i < n; i += dir){
            if (s.charAt(i) == c){
                ans += add;
            }else{
                add = 1;
            }
        }
        return ans;
    }
}

// STACK SOLUTION
//
// class Solution {
//     public int countCollisions(String dir) {
//         boolean[] dead = new boolean[dir.length()];
//         Deque<Integer> stack = new ArrayDeque<>();
//         for (int i = 0; i < dir.length(); i++){
//             while(!stack.isEmpty() && bad(i, dir, stack, dead)){
//                 dead[i] = dead[stack.pop()] = true;
//             }
//             stack.push(i);
//         }

//         int ans = 0;
//         for (int i = 0; i < dead.length; i++){
//             if (dead[i] && dir.charAt(i) != 'S'){
//                 ans++;
//             }
//         }

//         return ans;
//     }

//     private boolean bad(int i, String dir, Deque<Integer> stack, boolean[] dead){
//         if (dir.charAt(i) == 'L' && (dead[stack.peek()] || dir.charAt(stack.peek()) != 'L')) return true;
//         if (dir.charAt(i) == 'S' && dir.charAt(stack.peek()) == 'R') return true;
//         return false;
//     }
// }
