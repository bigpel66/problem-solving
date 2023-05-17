#include <iostream>
#include <vector>
#include <algorithm>

int s1; int s2; int s3;

std::vector<int> v;

void    input()
{
    std::cin >> s1 >> s2 >> s3;
    v = std::vector<int>(s1 * s2 * s3 + 1);
}

void    output(int ans)
{
    std::cout << ans;
}

void    solution()
{
    for (int i = 1; i <= s1; ++i)
    {
        for (int j = 1; j <= s2; ++j)
        {
            for (int k = 1; k <= s3; ++k)
            {
                ++v[i + j + k];
            }
        }
    }

    auto iter = std::max_element(std::begin(v), std::end(v));
    output(std::distance(std::begin(v), iter));

}

int main(void)
{
    input();
    solution();
}