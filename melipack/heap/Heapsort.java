package melipack.heap;

import java.util.*;

public class Heapsort<T extends Comparable<? super T>> {
	   /**
	    *  Sorts a specified array of objects into ascending order, according to
	    *  the element class's implementation of the Comparable interface.
	    *  The worstTime(n) is O(n * log n).
	    *
	    *  @param x � the array to be sorted.  
	    *
	    */
	  public static <T extends Comparable<? super T>> void heapSortA (T[] x) {
		
	   int dim = x.length;
	   
	   BinaryHeap<T> heap = new ArrayBinaryHeap<T>(x); //costruzione Max-Heap
	   for (int c = dim-1; c >= 0 ; c--)
		   x[c]= heap.deleteMax(); 
	   } // method heapSort
	  
	   //Homework: estendere la classe ArrayBinaryHeap per la gestione del comparatore
	  
	  
	  public static <T extends Comparable<? super T>> void heapSortAL (T[] x) {
		  // uso implementazione mediante ArrayList (*)
		   int dim = x.length;
		   
		   BinaryHeap<T> heap = new ArrayListBinaryHeap<T>( x ); // (*) //costruzione Max-Heap
		   for (int c = dim-1; c >=0 ; c--)
			   x[c]= heap.deleteMax(); 
		   } // method heapSort
	  
	  
	  public static <T extends Comparable<? super T>> void heapSortAL (T [] x, Comparator<T> comparator) {
		   int dim = x.length;
		   //costruzione Max-Heap
		   BinaryHeap<T> heap = new ArrayListBinaryHeap<T>( x, comparator );
		   for (int c = dim -1; c >= 0 ; c--)
			   x[c]= heap.deleteMax(); 
		   
		   } // method heapSort
	  
	  
	  
	  public static <T extends Comparable<? super T>> void heapSort (T[] x) {
			
		  int end = x.length - 1; //Notice that x[0 ... end]
		  /*** heapify ***/
		  for( int hole = (end - 1) / 2; hole >= 0; hole-- ) 
			   fixHeap(x, hole, end); 
		  /****************/
		  T maxItem; 
		  for (int c = end; c > 0 ; c--) {
			  maxItem = x[0];  //findMax( );
			  x[0] = x[c];
			  x[c] = maxItem;
			  fixHeap(x, 0, c-1 );  
		  }
	  } // method heapSort
	  

	  /**
	    * Internal method to percolate down in the heap.
		* @param hole the index at which the percolate begins.
		* @param end the index at which the percolate ends.
		*/
		    private static <T extends Comparable<? super T>> void fixHeap(T[] x, int hole, int end)  // Fix down
		{
		    int child;
		    T item = x[hole];
		    while (hole*2 + 1 <= end) {  //there exists the left child
		    	child = hole * 2 + 1;  //left child
		    	// if there exists the right child
		    	if( child != end && (x[child + 1]).compareTo(x[child] ) > 0 ) child++;
		    	if( (x[child]).compareTo(item) > 0 ) {
		    		x[hole] = x[child];
		    		hole = child; 
		    	} else break; 
		    }
		    x[hole] = item;
		}

}




