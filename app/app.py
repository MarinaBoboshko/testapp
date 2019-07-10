import random
with open('text.txt', "w+") as f:
    for i in range(10):
        f.write(f"{random.randint(0, 10)}\n")
print(open('text.txt').read())


