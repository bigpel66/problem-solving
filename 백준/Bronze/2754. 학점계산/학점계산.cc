#include <iostream>
#include <unordered_map>

using namespace std;

class t_solution {
    private:
        static const unordered_map<string, double> gpa;
        string grade;

        void get_input() {
            cin >> grade;
        }

        void solve() {
            cout << fixed;
            cout.precision(1);
            cout << gpa.at(grade);
        }

    public:
        t_solution() {
            get_input();
            solve();
        }
};

const unordered_map<string, double> t_solution::gpa = {
    {"A+", 4.3},
    {"A0", 4.0},
    {"A-", 3.7},
    {"B+", 3.3},
    {"B0", 3.0},
    {"B-", 2.7},
    {"C+", 2.3},
    {"C0", 2.0},
    {"C-", 1.7},
    {"D+", 1.3},
    {"D0", 1.0},
    {"D-", 0.7},
    {"F", 0.0}
};

int main() {
    t_solution solve;
    return 0;
}