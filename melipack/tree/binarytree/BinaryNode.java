package melipack.tree.binarytree;

/*******************************************************
 *
 *  The BinaryNode class
 *
 ********************************************************/

public class BinaryNode<E> {

	private BinaryNode<E> left, right;	// children can be null
	private E data;

	/** Constructs a node where left and right are null **/
	public BinaryNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}


	/** Constructs inner node **/
	public BinaryNode(BinaryNode<E> left, E data, BinaryNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}


	public void setData(E data) {
		this.data = data;
	}

	public void setLeft(BinaryNode<E> left) {
		this.left = left;
	}

	public void setRight(BinaryNode<E> right) {
		this.right = right;
	}
	
	public E getData() {
		return data;
	}

	public BinaryNode<E> getLeft() {
		return left;
	}

	public BinaryNode<E> getRight() {
		return right;
	}
		


	/** Does it have a left child? **/
	public boolean hasLeft() {
		return left != null;
	}


	/** Does it have a right child? **/
	public boolean hasRight() {
		return right != null;
	}
	
   	/********************************************
   	 * 				ESERCITAZIONE
   	 ******************************************/
	
	/**
	 * @return true if the binary trees rooted at these nodes 
         * have the same structure and contain the same values,
         * false otherwise. 
	 */
	public boolean equals(Object other) {
		BinaryNode<?> t2;
		if (other == null) return false;
		if (!(other instanceof BinaryNode<?>)) return false;
		else t2 = (BinaryNode<?>) other;
		if (!data.equals(t2.data)  ||  hasLeft() != t2.hasLeft() || hasRight() != t2.hasRight())
			return false;
		if (this.left != null && !left.equals(t2.left)) return false;
		if (this.right!= null && !right.equals(t2.right)) return false;
		return true;
	}
	
	
	/**
     * @return the size of the subtree rooted at this node,
     * that is the number of non-null descendants of this node, plus one.
     */

   	public int size() {  //this node cannot be empty
		int lsize = 0, rsize = 0;
		if ( left !=null ) lsize = left.size();  
		if ( right !=null ) rsize = right.size();
			return 1 + lsize + rsize;
	}  // method size
   	
   	
   	/********************************************
   	 * 				END ESERCITAZIONE
   	 ******************************************/
   	

}
