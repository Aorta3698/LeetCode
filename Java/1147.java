class Solution {
    public int longestDecomposition(String text) {
        int a = 0, i = 0, j = text.length()-1, ans = 0;
        while(i<j){
            if (text.substring(a,i+1).equals(text.substring(j,text.length()-a))){
                a=i+1;
                ans+=2;
            }
            i++;
            j--;
        }
        return ans+(a==i&&a==j+1?0:1);
    }
}
