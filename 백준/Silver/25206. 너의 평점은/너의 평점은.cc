#include <iostream>
#include <unordered_map>

using namespace std;

class t_sol {
    private:
        static const unordered_map<string, double>& grade_map;
        double credit;
        string grade;
        double numerator, denominator;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            numerator = 0;
            denominator = 0;
        }
    
        void solve() {
            for (int i = 0 ; i < 20 ; i++) {
                cin >> grade >> credit >> grade;
                if (grade == "P") {
                    continue;
                }
                numerator += grade_map.at(grade) * credit;
                denominator += credit;
            }
            cout << fixed;
            cout.precision(5);
            cout << numerator / denominator;
        }
    
    public:
        t_sol(void) {
            stream();
            get_input();
            solve();
        }
};

const unordered_map<string, double>& t_sol::grade_map = {
    {"A+", 4.5},
    {"A0", 4.0},
    {"B+", 3.5},
    {"B0", 3.0},
    {"C+", 2.5},
    {"C0", 2.0},
    {"D+", 1.5},
    {"D0", 1.0},
    {"F", 0.0}
};

int main(void) {
    t_sol s;
    return 0;
}