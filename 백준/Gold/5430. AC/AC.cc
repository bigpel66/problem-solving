#include <deque>
#include <iostream>
#include <string>
#include <regex>

using namespace std;

class sol {
private:
    int number_of_test;
    int number_of_entry;
    string command;
    deque<int> dq;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_test;
    }

    vector<string> re_split(string& s, const regex& r) {
        vector<string> temp;
        regex_token_iterator<string::iterator> iter(s.begin(), s.end(), r, -1);
        regex_token_iterator<string::iterator> end;
        while (iter != end) {
            temp.push_back(*iter++);
        }
        return temp;
    }

    void exec(void) {
        bool is_left_to_right = true;
        for (auto&& i : command) {
            if (i == 'R') {
                is_left_to_right = !is_left_to_right;
                continue;
            }
            if (dq.empty()) {
                cout << "error\n";
                return;
            }
            if (is_left_to_right) {
                dq.pop_front();
            } else {
                dq.pop_back();
            }
        }
        cout << '[';
        if (is_left_to_right) {
            for (auto&& iter = dq.begin() ; iter != dq.end() ; iter++) {
                cout << *iter;
                if (iter != dq.end() - 1) {
                    cout << ',';
                }
            }
        } else {
            for (auto&& iter = dq.rbegin() ; iter != dq.rend() ; iter++) {
                cout << *iter;
                if (iter != dq.rend() - 1) {
                    cout << ',';
                }
            }
        }
        cout << "]\n";
    }

    void solve(void) {
        string arr;
        for (int i = 0 ; i < number_of_test ; i++) {
            cin >> command >> number_of_entry >> arr;
            arr = string(arr.begin() + 1, arr.end() - 1);
            auto&& split = re_split(arr, regex(R"(,)"));
            dq = deque<int>(number_of_entry, 0);
            for (int j = 0 ; j < number_of_entry ; j++) {
                dq[j] = stoi(split.at(j));
            }
            exec();
        }
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

int main(void) {
    sol ve;
    return 0;
}