class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int g = 0, sum = 0;
        for (int i = 0, j = -1, preS = 0, preC = 0; i < grades.length; i++){
            sum += grades[i];
            if (sum > preS && i-j > preC){
                g++;
                preC = i-j;
                preS = sum;
                j = i;
                sum = 0;
            }
        }
        return g;
    }
}
