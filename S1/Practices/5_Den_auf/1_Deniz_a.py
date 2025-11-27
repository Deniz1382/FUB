#Blocksatz is a method of aligning text on paper. In this approach, the first word of a line is aligned to the left margin, 
# and the last word to the right margin.
#  The remaining words are evenly distributed across the line.
#(a) Write a Python function blocksatz that receives a list of words and formats them in block alignment. 
# Your function should return a list of lines #each formatted in block alignment.
# Assume that each line is 80 characters long. If a word is longer than 80 characters, it should be truncated.

def blocksatz(words):
    t_char = sum(len(word) for word in words)
    end = t_char + (len(words)-1)
    temp = words
    #for i in range (1, end//80):
    if len(t_char)>=80 :
        print ("next line")
        return temp
    else:
        temp = words[1:]
        print (temp)

words = ["elephant", "strawberry", "encyclopedia", "magnificent", "astronaut", "butterfly", "galaxy", "horizon","gav","elephant", "strawberry", "encyclopedia", "magnificent", "astronaut", "butterfly", "galaxy", "horizon","gav"]
blocksatz(words)   


