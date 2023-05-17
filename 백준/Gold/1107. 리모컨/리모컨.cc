#include <cmath>
#include <iostream>
#include <unordered_set>

using namespace std;

class sol {
private:
    int target_chan;
    int number_of_malfunction;
    int answer;
    unordered_set<char> malfunctions;

    static const int& current_chan;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> target_chan >> number_of_malfunction;
        answer = abs(target_chan - current_chan);
        char temp;
        for (int i = 0 ; i < number_of_malfunction ; i++) {
            cin >> temp;
            malfunctions.insert(temp);
        }
    }

    bool contains_malfunction(const string& s) {
        for (auto&& i : s) {
            if (malfunctions.find(i) != malfunctions.end()) {
                return true;
            }
        }
        return false;
    }

    void solve(void) {
        for (int i = 0 ; i < target_chan + abs(target_chan - current_chan) ; i++) {
            string s = to_string(i);
            if (!contains_malfunction(s)) {
                answer = min(answer, abs(target_chan - i) + static_cast<int>(s.length()));
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

const int& sol::current_chan = 100;

int main(void) {
    sol ve;
    return 0;
}