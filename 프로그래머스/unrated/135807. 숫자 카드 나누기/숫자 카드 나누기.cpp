#include <algorithm>
#include <cmath>
#include <vector>

using namespace std;

int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}

int series_gcd(vector<int>& v) {
    sort(v.begin(), v.end(), less<int>());
    int common = v.at(0);
    for (auto&& i : v) {
        common = gcd(common, i);
        if (common == 1) {
            return 1;
        }
    }
    return common;
}

bool is_not_dividable(vector<int>& v, int common) {
    for (auto&& i : v) {
        if (i % common == 0) {
            return false;
        }
    }
    return true;
}

int solution(vector<int> arrayA, vector<int> arrayB) {
    int common1 = series_gcd(arrayA);
    int common2 = series_gcd(arrayB);
    bool v1 = (common2 != 1 && is_not_dividable(arrayA, common2));
    bool v2 = (common1 != 1 && is_not_dividable(arrayB, common1));
    if (v1 && v2) {
        return max(common1, common2);
    } else if (v1 && !v2) {
        return common2;
    } else if (!v1 && v2) {
        return common1;
    } else {
        return 0;
    }
}