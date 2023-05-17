#include <iostream>

using namespace std;

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    long long acc = 0;
    for (int i = 0 ; i < 3 ; i++) {
        long long temp;
        cin >> temp;
        acc += temp;
    }
    cout << acc;
    return 0;
}