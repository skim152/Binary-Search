
package shinyeobproject3;

/**
 *
 * @author Shinyeob Kim
 */

public class BSearchTree<T>
{
	private  String sortedList = "";
	
	private TreeNode<T> bstTree;
	
	public BSearchTree()
	{
		bstTree = null;	
	}
	

	public TreeNode<T> createBST(T array[])
	{
		bstTree = null;
		
		TreeNode<T> newNode;	
		
		for (int i = 0; i < array.length; i++)
		{
			newNode = new TreeNode<T>((T)array[i]);
			
			bstTree = insertValue(bstTree, newNode);
		}	
		return bstTree;
	}
	

	/**
	 * The method that allows a new value to be inserted in the tree.
	 * The insert method does not need to re-balance the tree if it becomes unbalanced.
	 * It should allow duplicate entries and it must be written using recursion.
	 * 
	 * @param tree the root node of the tree in which the new node will be added to. 
	 * @param nodeToAdd the node that will be added to the tree
	 * 
	 * @return the node containing the BST, after the new value has been inserted into it
	 */
	TreeNode<T> insertValue(TreeNode<T> tree, TreeNode<T> nodeToAdd)
	{
		// base case of the recursion
		// if the tree is null, or we have recursively traversed the tree until a null node has been reached, then return the nodeToAdd
		if (tree == null)
		{
			return nodeToAdd; 
		}
		
		// If the tree contains Integers as the numeric type
		if (tree.data instanceof Integer)
		{
		   //if the nodeToAdd already exists in the tree, then add the duplicate to the right child.
		   if ((Integer)nodeToAdd.data == (Integer)tree.data)
		   {
			   tree.right = insertValue(tree.right, nodeToAdd);
		   }
		   //if the nodeToAdd integer is greater than the current node of the tree, then traverse to the right
		   else if ((Integer)nodeToAdd.data > (Integer)tree.data)
		   {
		    	tree.right = insertValue(tree.right, nodeToAdd);
		   }
		   //if the nodeToAdd integer is less than the current node of the tree, then traverse to the left
		   else if ((Integer)nodeToAdd.data < (Integer)tree.data)
		   {
		    	tree.left = insertValue(tree.left, nodeToAdd);
		   }
		   
		   // return the node that contains the BST, with the new node added into it. 
		   return tree;	  
		}
		// else, the tree will contain Fractions as the numeric type
		else
		{
			//if the nodeToAdd already exists in the tree, then add the duplicate to the right child.
			if (((Fraction)nodeToAdd.data).compareTo(((Fraction)tree.data)) == 0)
			{
			tree.right = insertValue(tree.right, nodeToAdd);
			}
			
			//if the nodeToAdd fraction is greater than the current node of the tree, then traverse to the right
			else if (((Fraction)nodeToAdd.data).compareTo(((Fraction)tree.data)) > 0)
			{
			  tree.right = insertValue(tree.right, nodeToAdd);
			    	
			}
			//if the nodeToAdd fraction is less than the current node of the tree, then traverse to the left
			else if (((Fraction)nodeToAdd.data).compareTo(((Fraction)tree.data)) < 0)
			{
			  tree.left = insertValue(tree.left, nodeToAdd);
			}
			
			// return the node that contains the BST, with the new node added into it. 
			return tree;	  
		}
	}
	
	/**
	 * A method that performs a recursive in-order tree traversal to sort the contents of the tree into a string in ascending order
	 * 
	 * @param tree the node containing the BST beginning at the root node. 
	 */
	String sortTreeAscending(TreeNode<T> tree)
	{
		// base case, where if the node is null, then return the sorted list string. 
		if (tree == null)
		{
			return sortedList;	
		}
		
		// visits left node first, to get the smallest value
		sortTreeAscending(tree.left); 
		
		// then visits the parent node, which is greater than the left node, but less than the right node. 
		sortedList += String.valueOf(tree.data + " "); 
		
		// then visits the right node, which is greater than both the left and parent node
		sortTreeAscending(tree.right); 
		
		// return the ascending order sorted list
		return sortedList;
	}
	
	/**
	 * A method that performs a recursive in-order tree traversal to sort the contents of the tree into a string in descending order
	 * 
	 * @param tree the node containing the BST beginning at the root node.
	 */	
	String sortTreeDescending(TreeNode<T> tree)
	{
		// base case, where if the node is null, then return the sorted list string. 
		if (tree == null)
		{
			return sortedList;
		}
		
		// visits right node first to get the largest value
		sortTreeDescending(tree.right);
		
		// then visits the parent node, which is less than the right node, but greater than the left node. 
		sortedList += String.valueOf(tree.data + " ");

		// then visits the left node, which is less than both the right and parent node
		sortTreeDescending(tree.left);
				
		// return the descending order sorted list
		return sortedList;
	}	
}
