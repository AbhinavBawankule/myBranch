import java.util.NoSuchElementException;

/**
An implementation of a queue as a circular array.
 */
public class CircularArrayQueue
{
    private Object[] elements;
    //private data
    private int currentSize;
    private int head;
    private int tail;


    /**
    Constructs an empty queue.
     */
    public CircularArrayQueue() {

        final int INITIAL_SIZE = 10;
        elements = new Object[INITIAL_SIZE];
        currentSize = head = tail = 0; 
    }



    /**
    Checks whether this queue is empty.
    @return true if this queue is empty
     */
    public boolean empty()
    {
        return currentSize == 0;
    }


    /**
    Adds an element to the tail of this queue.
    @param newElement the element to add
     */
    public void add(Object element)
    {
        //grow the Array
        grow();  
        currentSize++; 
        elements[tail] = element;
        tail = (tail +1) % elements.length;

    }


    /**
    Removes an element from the head of this queue.
    @return the removed element
     */

    public Object remove()
    {
        if (currentSize == 0) {throw new NoSuchElementException();}
        currentSize--;

        Object result = elements[head];
        head = (head + 1) % elements.length;

        head = (head +1) % elements.length;

        return result; 

    }
    public Object removeLast()
    {       
        Object result = elements[tail]; 
        tail = (tail -1) % elements.length;
        return result; 

    }

    public void firstToLast()
    {
        Object first = elements[head]; 
        //if (currentSize != elements.length)
        head++;
        elements[tail+1] = first;  
        tail++;

        
    }
    public int size()
    {return currentSize;}
    public void addFirst(Object element)
    {
        grow();
        if(head == 0)
        {elements[head+ elements.length - 1] = element;
            head += elements.length-1; 
        }
        else
        {elements[head-1] = element;
            head--;
        }
    }

    public void lastToFirst()
    {
        if(head == 0) 
            {elements[elements.length] = elements[tail];
            head = head + elements.length;}
        else
        {elements[head-1] = elements[tail];
        head--;}
        tail++; 
    }
    /**
    Grows the element array if the current size equals the capacity.
     */
    private void grow()
    {
        if (currentSize == elements.length)
        {Object[] elements1 = new Object[elements.length * 2];
            for (int i = 0; i <= elements.length; i++)
            {
                elements1[i] = elements[(head + i) % elements.length];
            }
            head = 0;
            tail = currentSize; 
            elements = elements1; 
        }     
    }
    public String toString()
    {
     String result = " "; 
     int headt = head;
        for (int i = head; head != tail;)
     { result += elements[head]; 
         
        head = (head +1)%elements.length;
        
    }
    head = headt; 
    return result; 
}
}
//CircularArrayQueue
