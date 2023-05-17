#include <vector>

using namespace std;

int solution(int n) {
    if (n % 2 == 1) {
        return 0;
    }
    vector<long long> dp(n + 1, 0);
    dp[0] = 1;
    dp[2] = 3;
    for (int i = 4 ; i <= n ; i += 2) {
        dp[i] = (dp[i - 2] * 4 - dp[i - 4] + 1'000'000'007) % 1'000'000'007;
    }
    return dp.at(n);
}