package melipack.tree.binarytree;

import melipack.tree.BinaryTree;

import java.util.*;


public class LinkedBinaryTree<E> implements BinaryTree<E> {

	private BinaryNode<E> root;
	private int size;

	/**
    * @return an empty binary tree.
    */
    public LinkedBinaryTree( )
    {
    	root =  null;
    	size = 0;
    } // constructor LinkedBinaryTree


    /**
    * @return a binary tree with the specified element as its root.
    */
   	public LinkedBinaryTree (E element) 
   	{
      	size = 1;
      	root = new BinaryNode<E>(element);
   	}  // constructor LinkedBinaryTree



   	/**
    * @return a binary tree from the two specified binary trees.
    */
   	public LinkedBinaryTree (LinkedBinaryTree<E> leftSubtree, E element, LinkedBinaryTree<E> rightSubtree) 
   	{
   		root = new BinaryNode<E>(leftSubtree.getRoot(), element, rightSubtree.getRoot() );
   		size = 1 + leftSubtree.size + rightSubtree.size; 
	}  // constructor LinkedBinaryTree 
   	
 
   	
     	

	/**
    * @return the number of elements in the binary tree.
    */
	public int size() 
	{
	      return size;
	}  // method size
	
	
   	/**
    * @return true if the binary tree is empty and false otherwise.
    */
    public boolean isEmpty( )
    {
    	return root == null;
	}  // method isEmpty
    
		    
	/**
    * @return the root of the binary tree.
    */
	public BinaryNode<E> getRoot() 
	{
	      return root;
	}  // method root
	
	/**
	* @return a reference to the element if it is found
    * in the root, null otherwise.
    */
 	public E getDataBtree()
 	{
 		if ( isEmpty() ) return null;
 		else return root.getData();
 	}	

    /**
     *  Removes all elements from the binary tree.
     *
     */
     public void clear() {
     	root =  null;
     	size = 0;
     }
     
     
 	/**
     * Removes the left subtree of this binary tree.
     */
    public void removeLeftSubtree() 
    {
    	if (root.getLeft() != null)  size = size - root.getLeft().size();
       	root.setLeft(null);
    }  // method removeLeftSubtree


    /**
     * Removes the right subtree of this binary tree.
     */
    public void removeRightSubtree() 
    {
       	if (root.getRight() != null) size = size - root.getRight().size(); 
       	root.setRight(null);
    }  // method removeRightSubtree   	
   	
  
	
    /**
     * @return a new BinaryTree whose root is referenced to the left subtree
     * Notice that this binary tree and its left subtree have
     * to be updated consistently.  The new subtrees are not detached.
     */
    public BinaryTree<E> getLeftBtree()
    { 
    	LinkedBinaryTree<E> leftSubtree = new LinkedBinaryTree<E>();
    	if (isEmpty() || root.getLeft() == null) return leftSubtree;
    	leftSubtree.root = root.getLeft();
    	leftSubtree.size = root.getLeft().size(); 
    	return leftSubtree;
    }
   	 
   	    
    /**
     * @return a new BinaryTree whose root is referenced to the right subtree
     * Notice that this binary tree and its right subtree have
     * to be updated consistently.  The new subtrees are not detached.
     */
    public BinaryTree<E> getRightBtree()
    {
    	LinkedBinaryTree<E> rightSubtree = new LinkedBinaryTree<E>();
    	if (isEmpty() || root.getRight() == null) return rightSubtree;
    	rightSubtree.root = root.getRight();
    	rightSubtree.size = root.getRight().size();
    	return rightSubtree;
    }
    

   	/**
	 * Performs a preorder traversal on the binary tree by calling
	 * a recursive preorder method that starts with the root.
     */
	public Iterator<E> iteratorPreOrder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();
      	preorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorPreOrder


   	/**
	 * Performs a recursive preorder traversal.
     */
	protected void preorder (BinaryNode<E> node, List<E> templist) 
   	{
		if (node != null) 
		{
			if (node.getData() != null) templist.add(node.getData());
			preorder (node.getLeft(), templist);
			preorder (node.getRight(), templist);
      	}//if
	}  // method preorder	


   	/**
   	 * Performs an inorder traversal on the binary tree by calling
	 * a recursive inorder method that starts with the root.
	 */
	public Iterator<E> iteratorInOrder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();
      	inorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorInOrder


   	/**
   	 * Performs a recursive inorder traversal.
     */
	protected void inorder (BinaryNode<E> node, List<E> templist) 
   	{
	if (node != null) 
 	{
         inorder (node.getLeft(), templist);
         if (node.getData() != null) templist.add(node.getData());
         inorder (node.getRight(), templist);
      	}//if

	}  // method inorder

	

   	/**
   	 * Performs a postorder traversal on the binary tree by calling
   	 * a recursive postorder method that starts with the root.
     */
	public Iterator<E> iteratorPostOrder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();
      	postorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorPostOrder


   	/**
   	 * Performs a recursive postorder traversal.
     */
	protected void postorder (BinaryNode<E> node, List<E> templist) 
   	{
		if (node != null) 
		{
			postorder (node.getLeft(), templist);
			postorder (node.getRight(), templist);
			if (node.getData() != null) templist.add(node.getData());
      	}//if
	}  // method postorder 

	
   	/**
   	 * Performs a levelorder traversal on the binary tree using a templist
     */
	public Iterator<E> iteratorLevelOrder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();
      	levelorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorLevelOrder


   	/**
   	 * Performs an iterative levelorder traversal.
     */
   	protected void levelorder(BinaryNode<E> node, List<E> templist) 
   	{
   		Queue<BinaryNode<E>> queueOfnodes = new LinkedList<BinaryNode<E>>();  
      	BinaryNode<E> current;
      	queueOfnodes.offer (node);
      	while (! queueOfnodes.isEmpty()) {
	         current = queueOfnodes.remove();
	         if (current.getData() != null) templist.add(current.getData());
	         if (current.getLeft() != null)  queueOfnodes.offer (current.getLeft());
	         if (current.getRight() != null) queueOfnodes.offer (current.getRight());
      	}//while
    }  // method levelorder 
   	 	

    
   	/**
	  * Performs an iterative preorder traversal on the binary tree using a templist
      */

	public Iterator<E> iteratorItPreorder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();
      	itpreorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorItPreorder


   	/**
	  * Performs an iterative preorder traversal.
      */
   	protected void itpreorder(BinaryNode<E> node, List<E> templist) 
   	{

   		Stack<BinaryNode<E>> stackOfNodes = new Stack<BinaryNode<E>>();  // stack of nodes
      	BinaryNode<E> current;

      	stackOfNodes.push(node);

      	while (! stackOfNodes.isEmpty()) {
         current = stackOfNodes.pop();
         if (current.getData() != null) templist.add(current.getData());
         if (current.getRight() != null) stackOfNodes.push (current.getRight());
         if (current.getLeft() != null)  stackOfNodes.push(current.getLeft());
      	}//while
        }  // method itpreorder 


   	/**
	  * Performs an iterative inorder traversal on the binary tree using a templist
	  */

	public Iterator<E> iteratorItInorder() 
   	{
      	ArrayList<E> templist = new ArrayList<E>();
      	itinorder (root, templist);
      	return templist.iterator();
   	}  // method iteratorItInorder


   	/**
	  * Performs an iterative inorder traversal.
      */
   	protected void itinorder(BinaryNode<E> node, List<E> templist) 
   	{
   		Stack<BinaryNode<E>> stackOfNodes = new Stack<BinaryNode<E>>();
   		Stack<Boolean> flags = new Stack<Boolean>();  // stack of boolean values

      	BinaryNode<E> current;
      	boolean visit;

      	stackOfNodes.push(node);
      	flags.push(false);

      	while (!stackOfNodes.isEmpty()) 
      	{
      		current = stackOfNodes.pop();
      		visit = flags.pop();
      		if (visit) { if (current.getData() != null) templist.add(current.getData()); }
      		else {
      			if (current.getRight() != null) { stackOfNodes.push(current.getRight()); flags.push(false); }
      			stackOfNodes.push(current); flags.push(true);
      			if (current.getLeft() != null)  { stackOfNodes.push(current.getLeft());  flags.push(false);}
      		} //end-if
      	}//end-while
       
   	}  // method itinorder 


/***************** HOMEWORK *******************************************
		public Iterator<E> iteratorItPostOrder() 
***********************************************************************/
   	
  	/**
   	 * @return a string representation of the binary tree.
     */
   	public String toString() 
   	{
      	List<E> templist = new ArrayList<E>();
      	preorder (root, templist);

      	/* otherwise:
      	itpreorder (root, templist);
      	itinorder (root, templist);
      	*/

      	return templist.toString();
   	}  // method toString


	/**
	 * @return true if the binary trees have the same structure and
 	 * contain the same values, false otherwise. 
	 */
	public boolean equals(Object other) {
		LinkedBinaryTree<?> t2;
		if(!(other instanceof LinkedBinaryTree<?>))
			return false;
		else t2 = (LinkedBinaryTree<?>) other;
		if (this.isEmpty() && t2.isEmpty()) return true;
		if (this.isEmpty() != t2.isEmpty() ) return false;
		return ( root.equals(t2.root) );
	}

	
	/**
	 * @return a reference to the specified node containing the target element if it is found
	 * in the binary tree, null otherwise.
	 */
		public BinaryNode<E> find(E targetElement)  {
			return find( targetElement, root );
		} // method find
	
	
	private BinaryNode<E> find(E targetElement, BinaryNode<E> root) {
		if (root == null) return null;
		if (root.getData().equals(targetElement)) return root;
		BinaryNode<E> temp = find(targetElement, root.getLeft());
		if (temp == null) temp = find(targetElement, root.getRight());
		return temp;
	} // method find
	
	
	/* Removes the first occurrence of the specified
	 * element from this binary tree, if it is present.
	 * The data of the retrieved binary node is set to null. 
	 */
	public boolean remove(E targetElement) {
		if (targetElement == null) return false;
		BinaryNode<E> temp = find(targetElement, root);
		if (temp != null) {
			temp.setData(null);
			return true;
		} else return false;
	}


     /**
      * @return true if the tree contains an element that matches the
      * specified target element and false otherwise.
      */
  	public boolean contains (E targetElement) 
     	{
  		if (find(targetElement, root) != null) return true;
  		else return false;
     	}  // method contains
  	
  	
 	/**
     *  @return a binary tree from the specified array.
     */
	public LinkedBinaryTree (E[] array) {
		if (array.length == 0) {root = null; size = 0;}
		if (array.length == 1) {root = new BinaryNode<E>(array[0]); size = 1;}
   		root = buildTree(array, 0, array.length);
   		size = array.length; 	
	}  // constructor LinkedBinaryTree 
	
	
  	/**
   	 *  @param array � the specified array whose elements are to be inserted into the binary tree
     *  @param low: the smallest index in the range to be inserted.
     *  @param len: the length of the subarray to be inserted starting from the low index
     *  @return a binary tree from the specified array.
     */
	private static <E> BinaryNode<E> buildTree(E[] array, int low, int len) {
		if (len == 0) return null;
		BinaryNode<E> leftNode = buildTree(array, low + 1, (len-1)/2);
		BinaryNode<E> rightNode = buildTree(array, low + 1 + (len-1)/2, len-1-(len-1)/2);
		return new BinaryNode<E>(leftNode, array[low], rightNode);
	}
	
	
	/* II parziale 2022 */
	
	public void printLeafs() {
		if (this.isEmpty()) return;
		printLeafs(root);
	}
	
	public void printLeafs(BinaryNode<E> node) {
		if (node == null) return;
		if (node.getLeft() == null && node.getRight() == null)
			System.out.println(node.getData());
		else {
			printLeafs (node.getLeft());
			printLeafs (node.getRight());
		}
	}

	
}
