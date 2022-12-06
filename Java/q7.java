public int[] q7(int[] A) {
    int[] ans = new int[]{0, 0}; //no profit
    for (int i = 0, minIdx = 0; i < A.length; i++){
        if (A[i] < A[minIdx]) minIdx = i;
        if (A[i] - A[minIdx] > ans[1] - ans[0]){
            ans[0] = A[minIdx];
            ans[1] = A[i];
        }
    }

    return ans;
}
