// slightly better solution
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[] ans = new int[8];
        int m = 0, cur = 0, start = -1;
        for (int c : cells){
            cur = (cur << 1) + c;
        }
        cur = next(cur);
        start = cur;
        Map<Integer, Integer> map = new HashMap<>();

        do{
            map.put(m++, cur);
            cur = next(cur);
        }while(start != cur);

        cur = map.get(--n % m);

        for (int i = 7; i >= 0; i--){
            ans[7 - i] = (cur & (1 << i)) > 0? 1 : 0;
        }

        return ans;
    }

    private int next(int cur){
        int next = 0;
        for (int i = 6; i >= 1; i--){
            int x = cur & (1 << (i - 1));
            int y = cur & (1 << (i + 1));
            if (x + y == 0 || x * y > 0){
                next |= (1 << i);
            }
        }
        return next;
    }
}

// one solution
// class Solution {
//     public int[] prisonAfterNDays(int[] cells, int n) {
//         int[] ans = new int[8];
//         boolean[] seen = new boolean[1 << 8];
//         int m = 0, cur = 0;
//         for (int c : cells){
//             cur = (cur << 1) + c;
//         }

//         Map<Integer, Integer> map = new HashMap<>();
//         Map<Integer, Integer> tMap = new HashMap<>();
//         while(!seen[cur]){
//             seen[cur] = true;
//             map.put(m, cur);
//             tMap.put(cur, m++);
//             int next = 0;
//             for (int i = 6; i >= 1; i--){
//                 int x = cur & (1 << (i - 1));
//                 int y = cur & (1 << (i + 1));
//                 if (x + y == 0 || x * y > 0){
//                     next |= (1 << i);
//                 }
//             }
//             cur = next;
//         }

//         int cycle = m - tMap.get(cur);
//         int non = tMap.get(cur);
//         cur = map.get(n < non? n : non + (n - non) % cycle);

//         for (int i = 7; i >= 0; i--){
//             ans[7 - i] = (cur & (1 << i)) > 0? 1 : 0;
//         }

//         return ans;
//     }
// }
