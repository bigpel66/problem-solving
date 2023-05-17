#include <algorithm>
#include <iostream>
#include <vector>

using	Answer = std::pair<int, int>;
using	Cast = std::pair<std::string, Answer>;

int									g_trial;
std::vector<Cast>					g_cast;
std::vector<std::string>			g_answer;

void	pre_setting(void)
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);
}

void	input_action(void)
{
	std::cin >> g_trial;
	g_cast = std::vector<Cast>(g_trial, std::make_pair(std::string(3, '\0'), std::make_pair(0, 0)));
	for (auto&& i : g_cast)
		std::cin >> i.first >> i.second.first >> i.second.second;
}

bool	match(std::string& temp, Cast& c)
{
	int							strike = 0;
	int							ball = 0;

	for (int i = 0 ; i < 3 ; ++i)
	{
		for (int j = 0 ; j < 3 ; ++j)
		{
			if (temp[i] == c.first[j])
			{
				if (i == j)
					++strike;
				else
					++ball;
			}
		}
	}
	if (strike == c.second.first && ball == c.second.second)
		return (true);
	return (false);
}

void	solution(void)
{
	for (int i = 123 ; i < 1000; ++i)
	{
		bool						candidate = true;
		std::string					temp = std::to_string(i);
		if (temp[0] == temp[1] || temp[0] == temp[2] || temp[1] == temp[2])
			continue ;
		if (temp[0] == '0' || temp[1] == '0' || temp[2] == '0')
			continue ;
		for (auto&& j : g_cast)
		{
			if (!match(temp, j))
			{
				candidate = false;
				break;
			}
		}
		if (candidate)
			g_answer.push_back(temp);
	}
}

void	output_action(void)
{
	std::cout << g_answer.size();
}

int		main(void)
{
	pre_setting();
	input_action();
	solution();
	output_action();
	return (0);
}