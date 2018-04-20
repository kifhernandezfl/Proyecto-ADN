class Sequence: 
        def __init__(self, sequence, chromosome,start,end):
        self.sequence = sequence
        self.chromosome = chromosome
        self.start = start
        self.end = end
        self.next = None
    
    def toString(self):
        response = "Sequence:" + self.sequence + "\tChromosome:" + self.chromosome + "\tStart:" + str(self.start) + "\tEnd:" + str(self.end)
        return response
    
    def clone(self):
        clone_ = Sequence(self.sequence,self.chromosome,self.start,self.end)
        return clone_
    
seq1 = Sequence("AACT","chr1",112,132)
print(seq1.toString())
print(seq1.clone().toString())
