class Solution {
public:
    int maximumRobots(vector<int>& C, vector<int>& R, long long B) {
        deque<int> d;
        int n = size(C), i, j;
        long long sum = 0;
        for (i = 0, j = 0; i < n; ++i){
            sum += R[i];
            while(!d.empty() && C[d.back()] <= C[i]){
                d.pop_back();
            }
            d.push_back(i);
            long long cost = sum * (i - j + 1) + C[d.front()];
            if (cost > B){
                sum -= R[j];
                if (d.front() == j){
                    d.pop_front();
                }
                ++j;
            }
        }
        return i-j;
    }
};
