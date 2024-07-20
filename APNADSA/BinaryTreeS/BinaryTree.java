package APNADSA.BinaryTreeS;


/*
 * Pre Order Binary Tree
 * Process: --> step 1: create Node class with data, left node , right node
 *          --> step 2: create a method to Build Tree of return type Node
 *          --> step 3: intialize index with -1 intially with static 
 *          --> step 4: check that data is eqaul to -1 or not 
 *                         --> if it is -1 then return null (Base case)
 *          --> step 5: create a new Node and store data in it 
 *          --> step 6:recursively call left and right nodes untill
 */
public class BinaryTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int index = -1;
    // Build tree by using array
    public  Node BuildTree(int nodes[]){ // Time Complexity O(N)
        index++;
        if(index >= nodes.length || nodes[index] == -1){
            return null;
        }
        Node newNode = new Node(nodes[index]);
        newNode.left = BuildTree(nodes);
        newNode.right= BuildTree(nodes);
        return newNode;
    }


    

    /* PreOrder Traversal --> O(N)
     * 
     * step 1 --> first print root value 
     * step 2 --> then call left sub tree
     * step 3 --> then call right sub tree
     */
    public void PreOrder_Traversal(Node root){  
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        PreOrder_Traversal(root.left);  // left node called recursively 
        PreOrder_Traversal(root.right); // right node called recurively
       
    }

    /* In Order Traversal --> O(N)
     * 
     * Step 1 --> first call left sub tree
     * step 2 --> then print root value 
     * step 3 --> next call right sub tree
     */

    public void InOrder_Traversal(Node root){
        if(root == null){
            return;
        }
        InOrder_Traversal(root.left);
        System.out.print(root.data +" ");
        InOrder_Traversal(root.right);
        
    }

    /* Post Order Traversal --> O(N)
     * 
     * Step 1 --> first call left sub tree
     * step 2 --> then call right sub tree
     * step 3 --> pritn the root value
     */

    public void PostOrder_Traversal(Node root){
        if(root == null){
            return;
        }
        PostOrder_Traversal(root.left);
        PostOrder_Traversal(root.right);
        System.out.print(root.data + " ");
    }
    // Main method 
    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
        Node root =bt.BuildTree(nodes);
        bt.PreOrder_Traversal(root);
        System.out.println();
        bt.InOrder_Traversal(root);
        System.out.println();
        bt.PostOrder_Traversal(root);
        System.out.println();
    }

}
