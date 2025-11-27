def blocksatz(words):
    current_length = 0
    for i in range (len(words)):
        #rest=len(words)-current_length
        if (current_length<=80):
            current_length=current_length+len(words[i])+ 1
            print(f"current_length: {current_length}, word: {words[i]}")
        elif (current_length + sum(len(words[x]) + 1 for x in range(i, len(words))) <= 80): #!!!!
            for x in range(i,len(words)):
                print(words[x]," ",end="")
            return None
        else: #more than 80, should go to next line
            additional_spaces=80 - current_length
            asew= additional_spaces//(i-1) #asew=additional spaces each two words
            for j in range(0,i):
                print(words[j]," "*asew,end="")
            current_length = 0
            print("\n")
            

            
words = ["elephant", "strawberry", "encyclopedia", "magnificent", "astronaut", "butterfly", "galaxy", "horizon","gav","elephant", "strawberry", "encyclopedia", "magnificent", "astronaut", "butterfly", "galaxy", "horizon","pixel"]
blocksatz(words)   





          

