class GenerateSequences:
    def __init__(self):
        self.test = 0
        
    def chromosome(self):
        return ("chr" + str(randint(1,23)))
    
    def getNucleotide(self):
        option = randint(1,4)
        
        if option == 1:
            return "A"
        elif option == 2:
            return "C"
        elif option == 3:
            return "G"
        else:
            return "T"
            
    def getSequence(self, length):
        if length == 1:
            return self.getNucleotide()
        else:
            return self.getNucleotide() + self.getSequence(length - 1)
        
    def saveSequences(self):
        file = open("sequence.txt","w")
        datasize = 1000
        
        for i in range(datasize):
            length = randint(5,50)
            start = randint(1,1000)
            experimental_read = self.getSequence(length) + "," + self.chromosome() + "," + str(start) + "," + str(start + length - 1) + "\n"
            file.write(experimental_read)
        
        file.close()    
        
test = GenerateSequences()
test.saveSequences()  