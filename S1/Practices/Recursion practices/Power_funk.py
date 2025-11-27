def power(a,b):
    if b==0:
        return 1
    else:
        return power(a,b-1) * a
    
print(power(2,3))