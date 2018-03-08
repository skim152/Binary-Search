
package shinyeobproject3;

/**
 *
 * @author Shinyeob Kim
 */

public class TreeNode<T>
{
    protected T data; 				// The information that will be stored in the node. 
    protected TreeNode<T> left;   	// The nodes left child
    protected TreeNode <T>right;  	// The nodes right child


	public TreeNode (T dataNode)
	{	
		this.data = dataNode;
		this.left= null;
		this.right = null;
	}
	
	/**
	 * Return the data within this TreeNode
	 * 
	 * @return the data within the TreeNode
	 */
	public T getData()
	{
		return data;
	}
	
	
	/**  
	 * @return a string of how the operator node should be displayed in in-order form. 
	 */ 
   @Override
   public String toString()
   {   
       return  data + " ";
   }
}