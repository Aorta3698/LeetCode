class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int i = 0; i < digits.length; i++){
            if (digits[i] % 2 == 0 && !seen.contains(digits[i])){
                seen.add(digits[i]);
                for (int j = 0; j < digits.length; j++){
                    if (j == i) continue;
                    for (int w = 0; w < digits.length; w++){
                        if (w == i || w == j || digits[w] == 0) continue;
                        ans.add(100*digits[w] + 10*digits[j] + digits[i]);
                    }
                }
            }
        }

        int[] an = new int[ans.size()];
        int idx = 0;
        for (int i : ans)
            an[idx++] = i;
        Arrays.sort(an);
        return an;
    }
}
