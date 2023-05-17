#include <iostream>

using namespace std;

int main() {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    int i, j;
    cin >> i >> j;
    if (i > 0 && j > 0) {
        cout << 1;
    } else if (i < 0 && j > 0) {
        cout << 2;
    } else if (i < 0 && j < 0) {
        cout << 3;
    } else {
        cout << 4;
    }
    return 0;
}