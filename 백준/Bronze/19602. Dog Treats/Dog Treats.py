ONE, TWO, THREE = map(int, open(0).read().split())
print("happy" if ONE * 1 + TWO * 2 + THREE * 3 >= 10 else "sad")
