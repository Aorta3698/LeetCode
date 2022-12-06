https://leetcode.com/problems/kth-distinct-string-in-an-array/discuss/1632009/Java-or-Easy-5-Lines-or-O(n)
class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) map.merge(s, 1, Integer::sum);
        for (String s : arr)
            if (map.get(s) == 1)
                if (--k == 0)
                    return s;
        return "";
    }
}
