#include <iostream>
#include <vector>

using namespace std;

class t_sol {
    private:
        int number_of_basket;
        int number_of_query;
        int begin, end;
        vector<int> basket;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> number_of_basket >> number_of_query;
            basket = vector<int>(number_of_basket + 1, 0);
            for (int i = 1 ; i < basket.size() ; i++) {
                basket[i] = i;
            }
        }
        
        void solve(void) {
            for (int i = 0 ; i < number_of_query ; i++) {
                cin >> begin >> end;
                vector<int> temp = vector<int>(basket.begin() + begin, basket.begin() + end + 1);
                for (int i = begin ; i <= end ; i++) {
                    basket[i] = temp.at(temp.size() - 1 - (i - begin));
                }
            }
            for (int i = 1 ; i < basket.size() ; i++) {
                cout << basket.at(i) << ' ';
            }
        }
    
    public:
        t_sol(void) {
            stream();
            get_input();        
            solve();
        }
};

int main(void) {
    t_sol s;
    return 0;
}