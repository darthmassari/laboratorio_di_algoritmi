package melipack.set;

import java.util.*;

/* Remark: AbstractSet<E>
 * This class provides a skeletal implementation of the Set interface to minimize the effort
 * required to implement this interface.
 * 
 * The process of implementing a set by extending this class is identical to that of
 * implementing a Collection by extending AbstractCollection, except that all of the methods
 * and constructors in subclasses of this class must obey the additional constraints imposed
 * by the Set interface (for instance, the add method must not permit addition of multiple
 * instances of an object to a set).
 * 
 * Note that this class does not override any of the implementations from the
 * AbstractCollection class, but merely adds implementations for equals() and hashCode() method.
 */

public class BinarySearchTree<E extends Comparable<? super E>> extends AbstractSet<E> 
{


    protected static class BSTNode<E> 
    {
        protected E element;

        protected BSTNode<E> left = null,
                           right = null,
                           parent = null;
 
        /**
         *  Initializes this BSTNode object.
         *
         *  This default constructor is defined for the sake of subclasses of
         *  the BinarySearchTree class. 
         */
        public BSTNode() { }
        

        /**
         *  Initializes this BSTNode object from element.
         *
         */ 
         public BSTNode (E element) 
         {
       	  this.element = element;
         } // constructor
         

        /**
         *  Initializes this BSTNode object from element and parent.
         *
         */ 
         public BSTNode (E element, BSTNode<E> parent) 
         {
             this.element = element;
             this.parent = parent;
         } // constructor
         

    } // class BSTNode



    protected BSTNode<E> root;
    protected int size;    
    
    
    /**
     *  Initializes this BinarySearchTree object to be empty, to contain only elements
     *  of type E, to be ordered by the Comparable interface, and to contain no 
     *  duplicate elements.
     *
     */ 
    public BinarySearchTree() 
    {
        root = null;
        size = 0;  
    } // default constructor


    /**
     * Initializes this BinarySearchTree object to contain a shallow copy of
     * a specified BinarySearchTree object.
     * The worstTime(n) is O(n), where n is the number of elements in the
     * specified BinarySearchTree object.
     *
     * @param otherTree - the specified BinarySearchTree object that this
     *                BinarySearchTree object will be assigned a shallow copy of.
     *
     */
    public BinarySearchTree (BinarySearchTree<? extends E> otherTree)
    {
         root = copy (otherTree.root, null);
         size = otherTree.size;  
    } // copy constructor


    protected BSTNode<E> copy (BSTNode<? extends E> p, BSTNode<E> parent)
    {
        if (p != null)
        {
            BSTNode<E> q = new BSTNode<E> (p.element, parent);
            q.left = copy (p.left, q);
            q.right = copy (p.right, q);
            return q;
        } // if
        return null;
    } // method copy
    
    /*    
    
    /**
     *  Returns the size of this BinarySearchTree object.
     *
     * @return the size of this BinarySearchTree object.
     *
     */
    public int size( )
    {
        return size;
    } // method size()
  


    /**
     *  Ensures that this BinarySearchTree object contains a specified element.
     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
     *
     *  @param element - the element whose presence is ensured in this 
     *                 BinarySearchTree object.
     *
     *  @return true - if this BinarySearchTree object changed as a result of this
     *                method call (that is, if element was actually inserted); otherwise,
     *                return false.
     *
     *  @throws ClassCastException - if element cannot be compared to the 
     *                  elements already in this BinarySearchTree object.
     *  @throws NullPointerException - if element is null.
     *
     */
    public boolean add (E element)  
    {
        if (root == null) 
        {
            if (element == null)
                throw new NullPointerException();
            root = new BSTNode<E> (element);
            size++;             
            return true;
        } // empty tree
        else 
        {
            BSTNode<E> current = root;
            int comp;
            while (true) 
            {
                comp = element.compareTo (current.element);
                if (comp == 0)
                    return false;
                if (comp < 0)  
                    if (current.left != null)
                        current = current.left;
                    else // current.left == null
                    {
                        current.left = new BSTNode<E> (element, current);
                        size++;                             
                        return true;
                    } 
                else if (current.right != null)  // comp > 0
                        current = current.right;
                    else // current.right == null
                    {
                        current.right = new BSTNode<E> (element, current);
                        size++;                           
                        return true;
                    } 
            } // while
        } // root not null
    } // method add


    /**
     *  Finds the BSTNode object that houses a specified element, if there is such a BSTNode.
     *  The worstTime(n) is O(n), and averageTime(n) is O(log n).
     *
     *  @param obj - the element whose BSTNode is sought.
     *
     *  @return the BSTNode object that houses obj - if there is such a BSTNode;
     *                otherwise, return null.  
     *
     *  @throws ClassCastException - if obj is not comparable to the elements
     *                  already in this BinarySearchTree object.
     *  @throws NullPointerException - if obj is null.
     *
     */
    protected BSTNode<E> getBSTNode (E obj) 
    {
        int comp;

        if (obj == null) throw new NullPointerException();
        
        BSTNode<E> current = root;
        while (current != null) 
        {
            comp = (obj).compareTo (current.element);
            if (comp == 0)
                return current;
            else if (comp < 0)
                current = current.left;
            else
                current = current.right;
        } // while
        return null;
    } // method getBSTNode
    
    

   /**
     *  Determines if there is at least one element in this BinarySearchTree object that
     *  equals a specified element.
     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).  
     *
     *  @param obj - the element sought in this BinarySearchTree object.
     *
     *  @return true - if there is an element in this BinarySearchTree object that
     *                equals obj; otherwise, return false.
     *
     *  @throws ClassCastException - if obj cannot be compared to the 
     *           elements in this BinarySearchTree object. 
     *  @throws NullPointerException - if obj is null.
     *  
     */ 
    public boolean contains (E obj) 
    {
        return getBSTNode (obj) != null;
    } // method contains

  

    /**
     *  Finds the successor of a specified BSTNode object in this BinarySearchTree.
     *  The worstTime(n) is O(n) and averageTime(n) is constant.
     *
     *  @param e - the BSTNode object whose successor is to be found.
     *
     *  @return the successor of e, if e has a successor; otherwise, return null.
     *
     */
    protected BSTNode<E> successor (BSTNode<E> e) 
    {
        if (e == null)
            return null;
        else if (e.right != null) // e has a right child
        {
            // successor is leftmost BSTNode in right subtree of e
            BSTNode<E> p = e.right;
            while (p.left != null)
                p = p.left;
            return p;

        } 
        else // e has no right child
        {
            // go up the tree to the left as far as possible, then go up to the right.
            BSTNode<E> p = e.parent;
            BSTNode<E> ch = e;
            while (p != null && ch == p.right) 
            {
                ch = p;
                p = p.parent;
            } // while
            return p;
        } 
    } // method successor



    /**
     *  Ensures that this BinarySearchTree object does not contain a specified 
     *  element.
     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
     *
     *  @param obj - the object whose absence is ensured in this 
     *                 BinarySearchTree object.
     *
     *  @return true - if this BinarySearchTree object changed as a result of this
     *                method call (that is, if obj was actually removed); otherwise,
     *                return false.
     *
     *  @throws ClassCastException - if obj cannot be compared to the 
     *                  elements already in this BinarySearchTree object. 
     *  @throws NullPointerException - if obj is null.
     *
     */
    
    
    
    public boolean remove (E obj)
    {
        BSTNode<E> e = getBSTNode (obj);
        if (e == null)
            return false;
        deleteBSTNode (e);       
        return true;
    } // method remove


     /**
      *  Deletes the element in a specified BSTNode object from this BinarySearchTree.
      *  
      *  @param p � the BSTNode object whose element is to be deleted from this
      *                 BinarySearchTree object.
      *
      *  @return the BSTNode object that was actually deleted from this BinarySearchTree
      *                object. 
      *
      */

    protected BSTNode<E> deleteBSTNode (BSTNode<E> p) 
    {
        size--;

        // If p has two children, replace p's element with p's successor's
        // element, then make p reference that successor.
        if (p.left != null && p.right != null) 
        {
            BSTNode<E> s = successor (p);
            p.element = s.element;
            p = s;
        } // p had two children


        // At this point, p has either no children or one child.

        BSTNode<E> replacement = null;
         
        if (p.left != null)
            replacement = p.left;
        else
            replacement = p.right;

        // If p has at least one child, link replacement to p.parent.
        if (replacement != null) 
        {
            replacement.parent = p.parent;
            if (p.parent == null)
                root = replacement;
            else if (p == p.parent.left)
                p.parent.left  = replacement;
            else
                p.parent.right = replacement;
        } // p has at least one child  
        else if (p.parent == null)
            root = null;
        else
        {
            if (p == p.parent.left)
                p.parent.left = null;
            else
                p.parent.right = null;        
        } // p has a parent but no children
        return p;
    } // method deleteBSTNode



    // HOMEWORK: iterazione    


    /**
     *  Returns an iterator positioned at the smallest element in this 
     *  BinarySearchTree object.
     *
     *  @return an iterator positioned at the smallest element in this
     *                BinarySearchTree object.
     *
     */
    public Iterator<E> iterator()
    {
         return new TreeIterator();
    } // method iterator

    
    protected class TreeIterator implements Iterator<E>
    {

        protected BSTNode<E> lastReturned = null,
                           next;               

        /**
         *  Positions this TreeIterator to the smallest element, according to the Comparable
         *  interface, in the BinarySearchTree object.
         *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
         *
         */
        protected TreeIterator() 
        {             
            next = root;
            if (next != null)
                while (next.left != null)
                    next = next.left;
        } // default constructor


        /**
         *  Determines if there are still some elements, in the BinarySearchTree object this
         *  TreeIterator object is iterating over, that have not been accessed by this
         *  TreeIterator object.
         *
         *  @return true - if there are still some elements that have not been accessed by
         *                this TreeIterator object; otherwise, return false.
         *
         */ 
        public boolean hasNext() 
        {
            return next != null;
        } // method hasNext


        /**
         *  Returns the element in the BSTNode this TreeIterator object was positioned at 
         *  before this call, and advances this TreeIterator object.
         *  The worstTime(n) is O(n) and averageTime(n) is constant.
         *
         *  @return the element this TreeIterator object was positioned at before this call.
         *
         *  @throws NoSuchElementException - if this TreeIterator object was not 
         *                 positioned at a BSTNode before this call.
         *
         */
        public E next() 
        {
            if (next == null)
                throw new NoSuchElementException();
            lastReturned = next;
            next = successor (next);             
            return lastReturned.element;
        } // method next

        /**
         *  Removes the element returned by the most recent call to this TreeIterator
         *  object�s next() method.
         *  The worstTime(n) is O(n) and averageTime(n) is constant.
         *
         *  @throws IllegalStateException - if this TreeIterator�s next() method was not
         *                called before this call, or if this TreeIterator�s remove() method was
         *                called between the call to the next() method and this call.
         *
         */ 
        public void remove() 
        {
            if (lastReturned == null)
                throw new IllegalStateException();
 
            if (lastReturned.left != null && lastReturned.right != null)
                next = lastReturned;
            deleteBSTNode(lastReturned);
            lastReturned = null; 
        } // method remove     

    } // class TreeIterator



} // class BinarySearchTree

