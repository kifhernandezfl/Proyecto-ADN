package adn;

public class Sequence
{
    public String sequence;
    public String chromosome;
    public int start;
    public int end;
   
    public Sequence next = null;
   
    public Sequence() {};
   
    public Sequence(String sequence, String chromosome, int start, int end)
    {
    this.sequence = sequence;
    this.chromosome = chromosome;
    this.start = start;
    this.end = end;
    }
   
    public String aString()
    {
        return "Sequence:" + this.sequence + "\t" + "Chr:" + this.chromosome + "\n" + "Start:" + this.start + "End:" + this.end;
    }

}

