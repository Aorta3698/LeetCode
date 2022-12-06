https://leetcode.com/problems/finding-mk-average/discuss/2376918/Java-Clean-Solution-or-O(NlogN)-or-Fully-Commented.
class MKAverage {

    TreeMap<Integer, Integer>[] map = new TreeMap[3];
    Queue<Integer> queue = new ArrayDeque<>();
    int[] sum = new int[3];
    int[] cnt = new int[3];
    int m, k, L = 0, M = 1, R = 2, UP = 1, DOWN = -1;
    int[] store;
    public MKAverage(int m, int k) {
        this.m=m;
        this.k=k;
        store = new int[m];
        Arrays.setAll(map, o -> new TreeMap<>());
    }

    public void addElement(int num) {
        if (queue.size() < m){
            store[queue.size()]=num;
            queue.offer(num);
            if (queue.size()==m){
                Arrays.sort(store);
                for (int i = 0; i < m; i++){
                    int idx = i < k? L : i < m-k? M : R;
                    map[idx].merge(store[i], 1, Integer::sum);
                    cnt[idx]++;
                    sum[idx]+=store[i];
                }
            }
            return;
        }
        int del = queue.poll();
        int idx = pos(del), tmp = idx;
        sum[idx] -= del;
        cnt[idx]--;
        idx = pos(num);
        queue.offer(num);
        cnt[idx]++;
        sum[idx]+=num;
        map[idx].merge(num, 1, Integer::sum);
        if (cnt[R]>k){
            move(R, M, DOWN);
        }
        if (cnt[L]<k){
            move(M, L, DOWN);
        }
        if (cnt[R]<k){
            move(M, R, UP);
        }
        if (cnt[L]>k){
            move(L, M, UP);
        }
        if (map[tmp].merge(del, -1, Integer::sum) == 0){
            map[tmp].remove(del);
        }
    }

    private void move(int F, int T, int D){
        int n = D == UP? map[F].lastKey() : map[F].firstKey();
        map[T].merge(n, 1, Integer::sum);
        if (map[F].merge(n, -1, Integer::sum) == 0){
            map[F].remove(n);
        }
        sum[F]-=n;
        sum[T]+=n;
        cnt[F]--;
        cnt[T]++;
    }

    private int pos(int num){
        return  map[L].lastKey() >= num? L
            :   map[M].lastKey() >= num? M
            :   R;
    }

    public int calculateMKAverage() {
        return queue.size() < m? -1 : sum[M]/cnt[M];
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
