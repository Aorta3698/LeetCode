class Solution {
    public int[] minOperations(String boxes) {
        List<Integer> one = new ArrayList<>();
        for (int i = 0; i < boxes.length(); i++)
            if (boxes.charAt(i) == '1') one.add(i);

        int[] ans = new int[boxes.length()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = count(one, i);

        return ans;
    }

    private int count(List<Integer> pos, int idx){
        int sum = 0;
        for (int i : pos)
            sum += Math.abs(idx - i);
        return sum;
    }
}
