#include <algorithm>
#include <climits>
#include <cmath>
#include <vector>
using namespace std;

int solution(vector<vector<int>> land) {
    // vector<vector<int>> dp(land.size(), vector<int>(4, 0));
    // for (int i = 0 ; i < 4 ; i++) {
    //     dp[0][i] = land[0][i];
    // }
    // for (int i = 1 ; i < land.size() ; i++) {
    //     for (int j = 0 ; j < 4 ; j++) {
    //         int value = INT_MIN;
    //         for (int k = 0 ; k < 4 ; k++) {
    //             if (j != k) {
    //                 value = max(value, dp[i - 1][k]);
    //             }
    //         }   
    //         dp[i][j] = value + land[i][j];
    //     }
    // }
    // int answer = INT_MIN;
    // for (int i = 0 ; i < 4 ; i++) {
    //     answer = max(answer, dp[land.size() - 1][i]);
    // }
    // return answer;
    
    for (int i = 0 ; i < land.size() - 1 ; i++) {
        land[i + 1][0] += max(max(land[i][1], land[i][2]), land[i][3]);
        land[i + 1][1] += max(max(land[i][0], land[i][2]), land[i][3]); 
        land[i + 1][2] += max(max(land[i][0], land[i][1]), land[i][3]); 
        land[i + 1][3] += max(max(land[i][0], land[i][1]), land[i][2]);
    }
    return *max_element(land.at(land.size() - 1).begin(), land.at(land.size() - 1).end());
}