class RLEIterator {

    long[][] arr;
    long cur = 0;
    public RLEIterator(int[] encoding) {
        arr = new long[encoding.length / 2][2];
        long sum = 0;
        for (int i = 0; i < encoding.length; i+=2){
            arr[i/2] = new long[]{encoding[i] + sum, encoding[i + 1]};
            sum = arr[i/2][0];
        }
    }

    public int next(int n) {
        cur += n;
        int lo = 0, hi = arr.length;
        while(lo < hi){
            int mid = (lo + hi) >> 1;
            if (cur <= arr[mid][0])
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo == arr.length? -1 : (int)arr[lo][1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
