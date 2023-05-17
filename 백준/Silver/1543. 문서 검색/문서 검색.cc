#include <iostream>
#include <iterator>
#include <vector>

std::string					g_heystack;
std::string					g_needle;
int							g_answer;

void	pre_setting(void)
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);
}

void	input_action(void)
{
	std::getline(std::cin, g_heystack);
	std::getline(std::cin, g_needle);
}

void	solution(void)
{
	while (true)
	{
		unsigned long		index = g_heystack.find(g_needle);
		if (index == std::string::npos)
			break ;
		g_heystack = g_heystack.substr(index + g_needle.size(), g_heystack.size());
		++g_answer;
	}
}

void	output_action(void)
{
	std::cout << g_answer;
}

int		main(void)
{
	pre_setting();
	input_action();
	solution();
	output_action();
	return (0);
}