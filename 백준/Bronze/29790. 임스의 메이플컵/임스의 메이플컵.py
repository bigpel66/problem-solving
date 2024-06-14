N, U, L = map(int, input().split())
p1 = N >= 1000
p2 = U >= 8000 or L >= 260
if p1 and p2:
    print("Very Good")
elif p1:
    print("Good")
else:
    print("Bad")
