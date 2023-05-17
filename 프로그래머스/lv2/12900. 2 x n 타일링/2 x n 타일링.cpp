#include <vector>

using namespace std;

int solution(int n) {
    vector<int> vec(n + 1, 0);
    vec[0] = vec[1] = 1;
    for (int i = 2 ; i <= n ; i++) {
        vec[i] = (vec[i - 1] + vec[i - 2]) % 1'000'000'007;
    }
    return vec.at(n);
}