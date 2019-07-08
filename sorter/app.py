def from_file(path):
    with open(path, 'r') as f:
        array = f.readlines()
    return array
array = from_file("text.txt")
a=sorted(array)
print (a)


#import random
#with open('text.txt', "w+") as f:
    #for i in range(10):
    #    f.write(random.randint(0, 10))
#b=[]
#for i in range(10):
#    a=random.randint(0, 100)
#    b.append(a)
#a=sorted(b)
#print(a)
