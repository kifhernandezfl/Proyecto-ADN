package adn;
import java.io.*;

public class ADN 
{   
    static Lista Sequence = new Lista();
    int max_occurrences = Integer.MIN_VALUE;
    String motif_winner = "";

    public void compareMotif(String motif_candidate)
    {
        int counter = counterOccurrences(motif_candidate);
	if(counter > max_occurrences)
        {
            max_occurrences = counter;
            motif_winner = motif_candidate;
	}
    }
	
    public int counterOccurrences(String motif_candidate)
    {
        int counter = 0;
	String gen_sequence;
        Sequence temp = Sequence.head;

        while(temp != null)
	{
            gen_sequence = temp.sequence;
			
            for(int i=0; i<(gen_sequence.length() - motif_candidate.length());i++)
                if(gen_sequence.substring(i, i + motif_candidate.length()).equals(motif_candidate))
		{
                    counter += 1;
                    i += motif_candidate.length() - 1;
		}
            temp = temp.next;
	}
        return counter;
    }
	
    public void countChromosomes() throws IOException 
    {
        int [] chromosomes = new int[23];
        String cromosoma;
	int index;
        Sequence temp = Sequence.head;
		
	while(temp != null)
        {
            if (temp.sequence.contains(motif_winner))
            {
                //chromosomes[Integer.parseInt(temp.chromosome.replace("chr", ""))] += 1;
		cromosoma = temp.chromosome;
                cromosoma=cromosoma.replace("chr", "");
		index = Integer.parseInt(cromosoma) - 1;
                chromosomes[index] += 1;
            }
            temp = temp.next;
	}
		
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	for(int i = 0; i<23; i++)
        {
            bw.write("Cromosoma" + (i+1) + ":" + chromosomes[i] + "\n");
	}bw.flush();
    }
	
    public void generateCombinations(String subsequence, int size)
    {
        if(size == 1)
        {
            compareMotif(subsequence + "A");
            compareMotif(subsequence + "C");
            compareMotif(subsequence + "G");
            compareMotif(subsequence + "T");		
	}else
	{
            generateCombinations(subsequence + "A", size -1);
            generateCombinations(subsequence + "C", size -1);
            generateCombinations(subsequence + "G", size -1);
            generateCombinations(subsequence + "T", size -1);
	}
    }

    public static void main(String[] args) 
    {
	try
	{
            FileReader fr = new FileReader("C:\\\\Users\\\\Fernando\\\\Documents\\\\NetBeansProjects\\\\JavaApplication3\\\\sequence.txt");
            BufferedReader br = new BufferedReader(fr);
			
            String input = br.readLine();
            ADN run = new ADN();
            int star, en= 0;
            
            while(input != null)
            {
		String data[] = input.split(",");
                star= Integer.parseInt(data[2]);
                en=Integer.parseInt(data[3]);
		Sequence.insertAtEnd(new Sequence(data[0],data[1],star,en));
		input = br.readLine();
            }
            Sequence.printList();
            run.generateCombinations("",4);
            
            System.out.println("motif ganador:" + run.motif_winner + "\tOcurrencias:" + run.max_occurrences);
            
            run.countChromosomes();
        }catch(Exception ex){ex.printStackTrace();}
    }
}
