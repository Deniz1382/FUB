def string_reverse(word):
    if len(word)<=1:
        return word
    else:
        return string_reverse(word[1:]) + word[0]
    
print(string_reverse("deniz"))