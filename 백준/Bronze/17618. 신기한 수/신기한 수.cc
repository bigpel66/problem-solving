#include <bits/stdc++.h>
using namespace std;
int n, ans;
int main(void) {
    cin >> n;
    for(int i = 1; i <= n; i++) {
        string s = to_string(i);
        int sum = 0;
        for(int j = 0; j < s.size(); j++) {
            sum += s[j] - '0';
        }
        if(i % sum == 0) {
            ans++;
        }
    }
    cout << ans;
}