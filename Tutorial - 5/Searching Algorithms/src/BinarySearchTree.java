import java.util.Random;

public class BinarySearchTree {
    public class TreeNode{
        public int data;
        public TreeNode leftChild, rightChild, parent;

        public TreeNode(int d){
            data = d;
            leftChild = null;
            rightChild = null;
            parent = null;
        }

        public void setLeftChild(TreeNode n){
            leftChild = n;
            if(n != null){
                n.parent = this;
            }
        }

        public void setRightChild(TreeNode n){
            rightChild = n;
            if(n != null){
                n.parent = this;
            }
        }
    }
    
    private TreeNode root;
    
    public TreeNode find(int findMe){
        TreeNode n = root;
        while(n != null){
            if(n.data == findMe)
                return n;
            if(n.data < findMe)
                n = n.rightChild;
            else
                n = n.leftChild;
        }
        return null;
    }
    
    /*
    * TO DO: print the contents of the tree in ascending order
    */
    public void output(TreeNode n){
        if(n != null){
            output(n.leftChild);
            System.out.println(n.data + " ");
            output(n.rightChild);
        }
    }
    
    /*
    * TO DO: insert the new value, respecting the order
    */
    public void insert(int value){
		/* Hints:
		   Case 1:
           if root is null (i.e. an empty tree): 
             create new node containing value and make root
             references the new node; done.			 
		   Case 2: 
		   if root is not an empty tree:
		   Use an auxiliary function, insertBelow() recursively to insert the 
		   given value below the given node, (i.e. the root), preserving the order. 
		*/
    }
	
	/* 
	Recursive auxiliarly function: inserts the given value below the given node
	*/
	private void insertBelow(TreeNode node, int value){
	    /* Hints:
		   Case 1:
	       if the value is greater than the node.data:
        	   a) if node.rightChild is null, set the node.rightChild
                  to reference the new node containing value.
               b) Otherwise, insert into right subtree 
                  (i.e. node.rightChild) by calling insertBelow recursively.
           Case 2: 
		   if the value is less or equal to the node.data:
               a) if node.leftChild is null, set the node.leftChild to 
                  reference the new node containing value.
               b) Otherwise, insert into left subtree (i.e. node.leftChild) 
                  by calling insertBelow recursively.	
        */				  
	}
    
    /*
    * TO DO: find and remove the given value in case it is in the tree
    *
    * Function replaceNode below may be useful.
    */
    public void remove(int value){
		/* Hints:
		   First find the node n containing the value; if there is none, you are done.
		   If either child of n is null, you can simply replace n with its other child.
		   Otherwise, we need to replace the value in n:
		   1. Starting with n's left child, follow the rightChild pointers as long as they are not null.
		      This gets you to the node m containing the largest value in n's left subtree.
		   2. Copy m's data into n, replacing the old value.
		   3. Replace m with its left child.
		*/
        TreeNode n = root;
        while(n != null && n.data !=value){
            if(n.data < value)
                n =n.rightChild;
            else
                n=n.leftChild;
        }
        if(n != null)
            if(n.leftChild == null)
                replaceNode(n ,n.rightChild);
            else if (n.rightChild == null)
                replaceNode(n, n.leftChild);
            else{
                TreeNode m = n.leftChild;
                while(m.rightChild != null)
                    m=m.rightChild;
                n.data = m.data;
                replaceNode(m,m.leftChild);
            }
    }
    
    /*
    * Auxiliary function: replaces a node
    * If node is the root, replacement becomes the new root
    * Otherwise, node is the left/right child of some parent, and replacement takes that place
    */
    private void replaceNode(TreeNode node, TreeNode replacement){
        TreeNode parent = node.parent;
        if(parent == null){  // node is the root 
            root = replacement;
            if(root != null)
                root.parent = null;
        }
        else if(node == parent.leftChild)
            parent.setLeftChild(replacement);
        else parent.setRightChild(replacement);
    }

    
    /*
    * Generates an array of the given size, containing random values
    */
    public static int[] randomValues(int howMany){
        int[] result = new int[howMany];
        Random random = new Random();
        for(int i=0; i<howMany; i++)
           result[i] = random.nextInt() % (10 * howMany);
        return result;
    }
    
    /*
    * Inserts all the values in the given array
    */
    public void insertAll(int[] values, boolean printResults){
        for(int i=0; i<values.length; i++){
            insert(values[i]);
            if(printResults)
                output();
        }
    }
    
    /*
    * Removes all the values in the given array, if present
    */
    public void removeAll(int[] values, boolean printResults){
        for(int i=0; i<values.length; i++){
            remove(values[i]);
            if(printResults)
                output();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 10; 
        // Whether to print results. Only use with small numbers of values.
        boolean printResults = true; 
        
        BinarySearchTree t = new BinarySearchTree();
        int[] a = randomValues(numValues);
        if(printResults){
            System.out.print("Input values: ");
            for(int i=0;i<numValues; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }
        long start = System.currentTimeMillis();
        t.insertAll(a, printResults);
        t.removeAll(a, printResults);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
    	System.out.println();
        System.out.println("Elapsed time = " + elapsed + " seconds");        
    }
}
