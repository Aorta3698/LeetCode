https://leetcode.com/problems/utf-8-validation/discuss/1947937/Java-or-case-by-case
class Solution {
    public boolean validUtf8(int[] data) {
        int cur = 0;
        while(cur < data.length){
            int end = bytes(data[cur]);
            if (end == -1)
                return false;
            for (int i = cur + 1; i < data.length && i < cur + end; i++){
                if (!set(data[i], 0) || set(data[i], 1))
                    return false;
            }
            cur += end;
        }
        return cur == data.length;
    }

    private int bytes(int n){
        if (!set(n, 0))
            return 1;
        if (!set(n, 1))
            return -1;
        if (!set(n, 2))
            return 2;
        if (!set(n, 3))
            return 3;
        if (!set(n, 4))
            return 4;
        return -1;
    }

    private boolean set(int n, int idx){
        int i = 7 - idx;
        return (n & (1 << i)) > 0;
    }
}
