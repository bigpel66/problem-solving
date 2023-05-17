#include <functional>
#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        int number_of_test;
        int k, n;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> number_of_test;
        }
    
        vector<int> zero_base(int n) {
            vector<int> vec(n + 1, 0);
            for (size_t i = 0 ; i < vec.size() ; i++) {
                vec.at(i) = i;
            }
            return vec;
        }
        
        void upstair(vector<int>& vec) {
            vector<int> temp(vec.size(), 0);
            for (int i = 0 ; i < vec.size() ; i++) {
                int sum = 0;
                for (int j = 0 ; j <= i ; j++) {
                    sum += vec.at(j);
                }
                temp[i] = sum;
            }
            vec = move(temp);
        }
    
        void solve(void) {
            for (int i = 0 ; i < number_of_test ; i++) {
                cin >> k >> n;
                vector<int>&& vec = zero_base(n);
                for (int j = 0 ; j < k ; j++) {
                    upstair(vec);                    
                }
                cout << vec.at(vec.size() - 1) << '\n';
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