class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i < arr.length; i++){
            int j = i + m;
            while(j < arr.length){
                if (arr[j] != arr[j - m])
                    break;
                j++;
            }
            if (j - i >= m * k) return true;
        }

        return false;
    }
}
