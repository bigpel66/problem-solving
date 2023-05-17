#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class c_input {
    public:
        int n;
        int target;
        vector<int> v;
    
        c_input() {}
};

void get_input(c_input& input) {
    cin.tie(nullptr);
    ios_base::sync_with_stdio(false);
    cin >> input.n;
    for (int i = 0 ; i < input.n ; i++) {
        cin >> input.target;
        input.v.push_back(input.target);
    }
    cin >> input.target;
}

void solution(c_input input) {
    int count = 0;
    for (auto&& i : input.v) {
        if (i == input.target) {
            count++;
        }
    }
    cout << count;
}

int main() {
    c_input input;
    get_input(input);
    solution(input);
    return 0;
}