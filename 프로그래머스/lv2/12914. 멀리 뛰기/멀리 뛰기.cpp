#include <vector>

using namespace std;

long long solution(int n) {
    vector<long long> vec(2001);
    vec[0] = vec[1] = 1;
    for (int i = 2 ; i < vec.size() ; i++) {
        vec[i] = (vec[i - 1] + vec[i - 2]) % 1234567;
    }
    return vec[n];
}