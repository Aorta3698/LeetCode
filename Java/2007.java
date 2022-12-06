https://leetcode.com/problems/find-original-array-from-doubled-array/discuss/1874634/A-short-One-Pass-Queue-solution-98-speed-Java
//
//
// better implementation:
class Solution {
    public int[] findOriginalArray(int[] changed) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[changed.length / 2];
        int idx = 0;

        Arrays.sort(changed);
        for(Integer num : changed){
            if(num.equals(queue.peek())){
                queue.poll();
            }else{
                queue.offer(num * 2);
                if (idx == ans.length){
                    break;
                }
                ans[idx++] = num;
            }
        }
        return queue.isEmpty() ? ans : new int[]{};
    }
}

class Solution {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : changed){
            map.merge(n, 1 , Integer::sum);
        }

        Arrays.sort(changed);
        int[] ans = new int[changed.length / 2];
        int i = 0;
        for (int n : changed){
            if (map.get(n) == 0){
                continue;
            }
            if (map.getOrDefault(2 * n, 0) == 0 || i == ans.length){
                return new int[]{};
            }
            ans[i++] = n;
            map.merge(n, -1, Integer::sum);
            map.merge(2 * n, -1, Integer::sum);

            // 4, 8, 16, 32
        }

        return ans;

    }
}
