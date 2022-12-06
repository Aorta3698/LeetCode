class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        if (arr[0].equals("0"))
            return arr[0];
        StringBuilder sb = new StringBuilder();
        for (String n : arr){
            sb.append(n);
        }

        return sb.toString();
        //272, 27 -> 272 vs 272 | 27227 vs 27272
        //7478, 74 -> 7478 vs 7474
        //747, 74  -> 747 vs 747
        //74789, 74 -> 74789 vs 74747
    }
}
