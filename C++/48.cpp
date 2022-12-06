class Solution {
public:
    void rotate(vector<vector<int>>& A) {
        int n = A.size();
        for (int k{0}; k < n/2; ++k){
            for (int i{0}; i < n-2*k-1; ++i){
                swap(A[k][k+i], A[k+i][n-k-1]);
                swap(A[n-1-i-k][k], A[k][k+i]);
                swap(A[n-1-k][n-1-k-i], A[n-1-i-k][k]);
            }
        }
    }
};
