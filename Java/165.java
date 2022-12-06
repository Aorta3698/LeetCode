class Solution {
    public int compareVersion(String version1, String version2) {
        String[] one = version1.split("\\.");
        String[] two = version2.split("\\.");
        int i = 0, j = 0;
        while(i < one.length || j < two.length){
            int a = i >= one.length? 0 : Integer.parseInt(one[i]);
            int b = j >= two.length? 0 : Integer.parseInt(two[j]);
            if (a != b) return a > b? 1 : -1;
            i++;
            j++;
        }
        return 0;
    }
}
