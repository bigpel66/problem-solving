#include <iostream>
#include <sstream>
#include <string>

using namespace std;

class t_solution {
    private:
        static const string& s;
    
        int byte_size;
    
        void get_input(void) {
            cin >> byte_size;
        }
    
        string repeat(int count, const string& str) {
            stringstream ss;
            for (int i = 0 ; i < count ; i++) {
                ss << str;
            }
            return ss.str();
        }
    
        void solve(void) {
            cout << repeat(byte_size / 4, s) + "int";
        }
    
    public:
        t_solution(void) {
            get_input();
            solve();
        }
};

const string& t_solution::s = "long ";

int main(void) {
    t_solution s;
    return 0;
}