package adn;
import java.io.*;
import java.util.*;

//Secuencia(String), cromosoma(String), inicio(int), fin(int).

public class Generate 
{
    public static String chromosome()
    {
        Random rd= new Random();
	return "chr" + (rd.nextInt(23)+1);
    }
	
    public static String nucleotide()
    {
        Random rd= new Random();
		
	switch(rd.nextInt(4))
        {   
            case 0: 	return "A"; 
            case 1: 	return "C"; 
            case 2: 	return "G"; 
            case 3: 	return "T";
            default:    return "";
    	}
    }
	
    public static String sequence(int length) 
    {
        if(length==1)
            return nucleotide();
        else 
            return nucleotide() + sequence(length - 1);
    }
	
	
    public static void saveSequences()
    {
        try
        {
            FileWriter file = new FileWriter("sequence.txt");
            BufferedWriter bw = new BufferedWriter(file);
            Random rd = new Random();
            int length,start,datasize = 1000000;
            String experimental_read;
                            
            for(int i=0; i<datasize; i++)
            {
                length = rd.nextInt(50) + 1;
		start = rd.nextInt(1000);
                experimental_read = sequence(length) + "," + chromosome() + "," + start + "," + (start + length - 1);
		bw.write(experimental_read + "\n");
            }
            bw.flush();
            bw.close();
	}
        catch (Exception ex)
	{
            ex.printStackTrace();
	}
    }
	
	
    public static void main(String[] args) 
    { 		
	saveSequences();
    }
}
