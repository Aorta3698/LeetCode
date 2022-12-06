class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i]==0 && i != arr.length-1){
                int tmp = arr[i+1];
                arr[i+1]=0;
                for (int j = arr.length-1; j > i+2;j--)
                    arr[j] = arr[j-1];
                if (i+2 != arr.length) arr[i+2]=tmp;
                i++;
            }
        }
    }
}
