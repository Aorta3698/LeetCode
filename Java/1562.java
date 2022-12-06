class Solution {
    public int findLatestStep(int[] arr, int m) {
        int sz = arr.length, ans = -1, grp = 0;
        int[] size = new int[sz];
        int[] parent = IntStream.range(0, sz).toArray();

        for (int i = 0; i < arr.length; i++){
            int n = arr[i], nsz = 1;
            size[--n] = 1;
            if (m == 1){
                grp++;
            }

            if (n > 0 && size[n - 1] > 0){
                if (size[find(n - 1, parent)] == m){
                    grp--;
                }
                nsz = union(n, n - 1, parent, size);
            }

            if (n < sz - 1 && size[n + 1] > 0){
                if (size[find(n + 1, parent)] == m){
                    grp--;
                }
                nsz = union(n, n + 1, parent, size);
            }

            if (nsz > 1){
                if (m == 1) grp--;
                if (m == nsz) grp++;
            }

            if (grp > 0){
                ans = i+1;
            }
        }

        return ans;
    }

    private int find(int x, int[] parent){
        return x == parent[x]? x : (parent[x] = find(parent[x], parent));
    }

    private int union(int x, int y, int[] parent, int[] size){
        x = find(x, parent);
        y = find(y, parent);
        if (x == y){
            return 0;
        }

        if (size[x] > size[y]){
            parent[y] = x;
            size[x] += size[y];
            return size[x];
        }else{
            parent[x] = y;
            size[y] += size[x];
            return size[y];
        }
    }
}
