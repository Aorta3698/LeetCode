class Solution {
    public int minFlipsMonoIncr(String s) {
        //two states - those that end with 0, and those that don't
        //for those that do end with 0, everything before it has to be 0
        //and those that end with 1, we can split the string, but if any subgroup after it ends with 0,
        //we can only take 0 route. Otherwise, we take the min of prevMin
        //each group ends with 0
        //000111100010 -> 000, 1111000, 10
        char[] arr = s.toCharArray();
        int n = arr.length, zero = 0, one = 0, prevMin = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--){
            if (arr[i] == '0') zero++;
            if (arr[i] == '1') one++;
            if (i == 0 || arr[i] == '1' && arr[i - 1] == '0'){
                int toZero= one + (prevMin == Integer.MAX_VALUE? 0 : prevMin);
                int toOne = zero;
                one = 0;
                prevMin = Math.min(toZero, toOne);
            }
        }

        return prevMin;
    }
}
