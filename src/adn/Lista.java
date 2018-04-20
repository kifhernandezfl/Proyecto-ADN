package adn;
import java.io.*;

public class Lista 
{
	Sequence head = null;
	
	public boolean isEmpty()
	{
		return head == null ? true : false;
		/*
		* if(head == null)
		* 		return true;
		* else 
		* 		return false;
		*/
	}
	
	public void printList()
	{	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Sequence temp = head;
		
		try
		{   
			bw.write("Grades: \n");
			while(temp!=null)
			{
				bw.write(temp.toString());
				temp=temp.next;
			}
			bw.flush();
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	public void insertAtBegin(Sequence newnodo)
	{
		newnodo.next = head;
		head = newnodo;
	}
	
	public void  insertAtEnd(Sequence newnodo)
	{
		if(isEmpty())
			head = newnodo;
		else
		{
			Sequence temp = head;
			
			while(temp.next != null)
				temp = temp.next;
			
			temp.next = newnodo;
		}
		
	}
	
	public void insertAt(Sequence newnodo)
	{
		Sequence temp = head;
		Sequence aft = temp.next;
		newnodo.next = aft;
		temp.next=newnodo;
		
	}
	
	public void insertAtIndex(Sequence newnodo, int index)
	{
		Sequence temp = head;
		
		for(int i=0; i<index-1; i++)
			temp = temp.next;
		
		newnodo.next = temp.next;
		temp.next = newnodo;
	}
	
	public void deleteAtBegin()
	{
		Sequence temp = head;
		head = head.next;
		temp = null;
		System.gc();
	}
	
	public void deleteAtEnd()
	{
		Sequence temp = head;
        
        while(temp.next.next != null)
        {
            temp = temp.next;
        }
 
    temp.next = null;       
	}
	
	public void deleteAtIndex(int index)
	{
		Sequence temp = head;
		Sequence toDelete;
		
		for(int i=0; i<index-1; i++)
			temp = temp.next;
		
		toDelete = temp.next;
		temp.next = temp.next.next;
		toDelete = null;
		System.gc();
	}
	
	/*public void reverse()
	{
		Stack tempStack = new Stack();
		nodo temp = head;
		
		while(temp != null)
		{
			tempStack.Push(temp.clone());
			temp = temp.next;
		}
		head =  tempStack.head;
	}*/	
}
