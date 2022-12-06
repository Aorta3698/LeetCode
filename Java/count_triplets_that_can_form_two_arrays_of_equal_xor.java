class Solution {
    public int countTriplets(int[] arr) {
        int ij = 0;
        int jw = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                ij ^= arr[j - 1];
                jw = 0;
                for (int w = j; w < arr.length; ++w){
                    jw ^= arr[w];
                    if (jw == ij) count++;
                }
            }
            ij = 0;
        }

        return count;
    }
}
