total = sum(map(int, input().split()))
chicken = int(input())
print(total - 2 * chicken if total >= 2 * chicken else total)
