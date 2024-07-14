P, K = map(int, input().split()) 

is_prime = [False, False] + [True] * (K - 2)
for i in range(2, int(K ** 0.5) + 1):
    if not is_prime[i]:
        continue
    for j in range(i * 2, K, i):
        if is_prime[j]:
            is_prime[j] = False

flag = True
for i in range(2, K):
    if is_prime[i] and P % i == 0:
        flag = False
        break
 
if flag:
    print("GOOD")
else:
    print("BAD", i)