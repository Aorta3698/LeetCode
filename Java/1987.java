class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int M = (int)1e9+7, one = 0, zero = 0;
        for (char ch : binary.toCharArray()){
            switch(ch){
                case '0' -> zero = (one + zero)%M;
                default  -> one  = (one + zero + 1)%M;
            };
        }
        return (one + zero + (binary.contains("0")?1:0))%M;
    }
}
