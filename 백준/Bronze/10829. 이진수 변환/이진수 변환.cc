#include <iostream>

long long n;
std::string answer = "";

void input_setting()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(0);
    std::cout.tie(0);
}

void input()
{
    std::cin >> n;
}

char itoa(int n)
{
    return (n + '0');
}

void solution()
{
    while (1)
    {
        answer += itoa(n % 2);
        if (n < 2)
            break ;
        n /= 2;
    }
}

void print()
{
    for (int i = answer.length() - 1; i >= 0; i--)
        std::cout << answer[i];
}

int main(void)
{
    input_setting();
    input();
    solution();
    print();
    return (0);
}