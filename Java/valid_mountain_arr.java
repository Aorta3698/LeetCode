class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        
        boolean top = false;
        boolean ascend = false;
        boolean descend = false;
        for (int i = 0; i < arr.length-1; i++){
            if (arr[i] == arr[i+1])
                return false;
            if (!top){
                if (arr[i] > arr[i+1])
                    top = true;
                else
                    ascend = true;
            }
            if (top){
                if (arr[i] < arr[i+1])
                    return false;
                else
                    descend = true;
            }
        }

        return ascend && descend;
    }
}
