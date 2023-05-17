#include <string>
#include <vector>

using namespace std;

int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}

int solution(vector<int> arr) {
    while (arr.size() != 1) {
        int a = *(arr.end() - 2);
        int b = *(arr.end() - 1);
        arr.pop_back();
        arr.pop_back();
        arr.push_back(a * b / gcd(a, b));
    }
    return *arr.begin();
}