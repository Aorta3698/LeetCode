class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int last = numbers.length-1;

        for (int i = 0; i < numbers.length; i++){
            if (numbers[first] + numbers[last] < target)
                first++;
            else if (numbers[first] + numbers[last] > target)
                last--;
            else
                break;
        }

        return new int[]{first+1, last+1};
    }
}
