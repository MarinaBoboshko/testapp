import random
with open('text.txt', "w+") as f:
    for i in range(10):
        f.write(f"{random.randint(0, 10)}\n")
with open(text.txt, 'r') as fi:
    print fi.read()


