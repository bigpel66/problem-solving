#include <iostream>
#include <stack>
#include <string>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_word, answer;
    vector<string> v;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_word;
        answer = 0;
        v = vector<string>(number_of_word);
        for (int i = 0 ; i < number_of_word ; i++) {
            cin >> v[i];
        }
    }

    bool is_good_word(const string& s) {
        stack<char> st;
        for (size_t i = 0 ; i < s.length() ; i++) {
            if (st.empty() || st.top() != s.at(i)) {
                st.push(s.at(i));
            } else if (st.top() == s.at(i)){
                st.pop();
            }
        }
        return st.empty();
    }

    void solve(void) {
        for (size_t i = 0 ; i < v.size() ; i++) {
            if (is_good_word(v.at(i))) {
                answer++;
            }
        }
        cout << answer;
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