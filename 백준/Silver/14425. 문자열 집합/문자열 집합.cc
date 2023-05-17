#include <iostream>
#include <string>
#include <unordered_set>

using namespace std;

class sol {
    private:
        int number_of_set, number_of_given;
        string temp;
        unordered_set<string> us;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> number_of_set >> number_of_given;
            for (int i = 0 ; i < number_of_set ; i++) {
                cin >> temp;
                us.insert(temp);
            }
        }
        
        void solve(void) {
            int count = 0;
            for (int i = 0 ; i < number_of_given ; i++) {
                cin >> temp;
                if (us.find(temp) != us.end()) {
                    count++;
                }
            }
            cout << count;
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