class Solution {
    public long goodTriplets(int[] A, int[] B) {
        int n = A.length;
        int[] idx = new int[n];
        for(int i = 0; i < n; i++){
            idx[B[i]] = i;
        }
        int[] bit = new int[n+1];
        long ans = 0;
        for(int i = 0;i < n;i++){
            int pos = idx[A[i]];
            int l = query(bit, pos);
            int r = (n-1-pos) - (i - query(bit, pos));
            ans += 1L * l * r;
            update(bit, pos, 1);
        }
        return ans;
    }

    public int query(int[] bit, int i)
    {
        int sum = 0;
        for(i++; i > 0;i -= i&-i){
            sum += bit[i];
        }
        return sum;
    }

    public void update(int[] bit, int i, int v)
    {
        for(i++;i < bit.length;i += i&-i){
            bit[i] += v;
        }
    }
}

// class Solution {
//     public long goodTriplets(int[] A, int[] B) {
//         int n = A.length;
//         int[] idx = new int[n];
//         int[] time = new int[n];
//         int[] last = new int[n+1];
//         for (int i = 0; i < n; i++){
//             idx[A[i]]=i;
//         }
//         TreeMap<Integer, Integer>[] pre = new TreeMap[n+1];
//         Arrays.setAll(pre, o -> new TreeMap<>());
//         for (int i = 0; i < n; i++){
//             time[B[i]]=i;
//             update(pre, 1, idx[B[i]], i, last);
//         }
//         long ans = 0;
//         for (int i = 1; i < n-1; i++){
//             int t = time[A[i]];
//             int l = query(pre, i-1, t-1);
//             int r = (n - query(pre, i, n-1)) - (query(pre, n-1, t) - query(pre, i, t));
//             ans += 1L * l * r;
//         }

//         return ans;
//     }

//     private void update(TreeMap<Integer, Integer>[] bit, int inc, int idx, int time, int[] last){
//         ++idx;
//         while(idx < bit.length){
//             bit[idx].put(time, last[idx]+inc);
//             last[idx] += inc;
//             idx += idx & -idx;
//         }
//     }

//     private int query(TreeMap<Integer, Integer>[] bit, int idx, int time){
//         ++idx;
//         int ans = 0;
//         while(idx > 0){
//             Map.Entry<Integer, Integer> map = bit[idx].floorEntry(time);
//             ans += map == null? 0 : map.getValue();
//             idx -= idx & -idx;
//         }
//         return ans;
//     }
// }
