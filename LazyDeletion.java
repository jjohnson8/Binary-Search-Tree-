//JUDITH JOHNSON 
package projects;
import java.util.Scanner;
public class LazyDeletion {
        
	public static int menuChoice;
    public static TreeNode root=null;
    static int numDeletedNodes;
    public static int Size;
	static class TreeNode {
		 int key; //Keys in range of 1 to 99
	   TreeNode leftchild;
		TreeNode rightchild;
		boolean deleted;
		TreeNode(int k){
			key =k;
			leftchild=rightchild=null; // initializing the values of right and left child =null
		}
		//Insertion
		public static void insert(TreeNode node,int key1){
				if (node == null){ // for the root node being null
					root = new TreeNode(key1);
					System.out.println("Element Inserted");
				Size++; 
					}
			
				else if(key1 < node.key) { // if less than the root inserts the element to the left of the root
					if (node.leftchild == null){
						node.leftchild = new TreeNode(key1); //returns new left child
						Size++;
					}
					else
						insert(node.leftchild, key1);
	                System.out.println("Element inserted"); //inserts leftchild
					
	            }
				else if (key1 > node.key){ // if greater than root node goes to the right of the root
					
					if (node.rightchild == null){
						node.rightchild = new TreeNode(key1); //returns new right child
						Size++;
					}
					
					else
						insert(node.rightchild, key1); //inserts the element to the right of the root
					System.out.println("Element Inserted");
	            }
        }
		// Lazy Deletion
		public static void lazydelete (TreeNode node,int key){
			if(node ==null){
				return; 
			}
			else if (key<node.key){ 
				 lazydelete(node.leftchild,key); //marks the left child as deleted 
				 numDeletedNodes++; //count the no of deleted Nodes
				 
			}
			else if (key>node.key){
			 lazydelete(node.rightchild,key); // marks the right child as deleted
			 numDeletedNodes++;
			
			}
			else
			{			
				node.deleted = true;  //if not null marks the lement as deleted
				numDeletedNodes++;
				process();
			}
		}
			// Contains The Element
		public static boolean contains(TreeNode node,int key){
			
			if(node ==null){
				return false; 
			}
			else if (key<node.key)
				 return contains(node.leftchild,key);// Contains left child
			else  if(key>node.key)
				return contains(node.rightchild,key);// contains right child
			else
				return true;
	
			
			}
		//Minimum element in the tree
		public static TreeNode findMin(TreeNode t) {
			
			   if (t == null) return null;
			 
			   TreeNode node = findMin(t.leftchild); //checks the left child is minimum or not
			 
			   if (node != null) return node;
			 
			   if (!t.deleted) return t; // if deleted item is min then returns the deleted item as minimum
			 
			   return findMin(t.rightchild);  //checks the right child is minimum or not
			}
		   // Maximum Element in the tree
		    public static TreeNode findmax(TreeNode t){
				if (t == null) return null;
				 
				   TreeNode node = findmax(t.rightchild);  //checks the right child is maximum or not
				 
				   if (node != null) return node;
				 
				   if (!t.deleted) return t;    // if deleted item is max then returns the deleted item as minimum
				 
				   return findmax(t.leftchild);		    //checks the left child is maximum or not	
		    
		    	
		    }
		//InOrder Transversal
		public static void inOrder(TreeNode node) {  
			
			if(node !=  null) {
			    inOrder(node.leftchild); // Prints the left child
			 if(node.deleted)
				System.out.println("*");
			   System.out.println(node.key);  // prints the root
			  
			inOrder(node.rightchild);   //prints the right child
				}
				} 
			 
		// Count the No of Nodes
		public static int NoofNodes(TreeNode node){
			 return Size;
              }
		// Count the No of Deleted Nodes
		public  static int NoofDeletedNodes(TreeNode node){
			return numDeletedNodes;
		}
		  // Height of the tree
		public static int treeHeight(TreeNode node){
			
			if(node==null)
				return 0;
			else
			return (1+ Math.max(treeHeight(node.leftchild),treeHeight(node.rightchild))); // sums the path of the tree
			}
		public static void process(){
			Scanner Sc = new Scanner(System.in);

			 String mainMenu = ("Select a choice from the menu: \n" 
			            + "1. Insert\n" 
			            + "2. Delete \n"
			            + "3. Find Max\n" 
			            + "4.  Find Min \n"
			            + "5. Contains\n" 
			            + "6. Inorder Transversal \n"
			            + "7. Height\n" 
			             +"8.No Of Nodes");

			    System.out.println(mainMenu);

			     menuChoice = Sc.nextInt(); // allows users to make a choice 

			    // use of switch case to choose an option and get user input
		switch (menuChoice) {
			case 1: {
				System.out.println("Enter the Element:");
				Scanner Sc2= new Scanner(System.in);
				int k=Sc2.nextInt();
			    insert(root,k);
			    	process();
			    	return;
			        }
			       
			    

			 case 2: {
			    	System.out.println("Enter the Element to be Deleted:");
			    	Scanner Sc3 =new Scanner (System.in);
			    	int k=Sc3.nextInt();
			    	lazydelete(root,k);
		          
			    	process();
			        return;
			    }

			 case 3: {
			        int k= findmax(root).key;
			        System.out.println("The Maximum Element in the Tree:"+k);
			         process();
			        return;
			    }

			   case 4: {
				   				   
			    	int k  = findMin(root).key;
			    	System.out.println("The Minmum elemnt in the Tree:"+ k);
			    	process();
			        return;
			    }   
			    
			   case 5:{
				  System.out.println("Enter the Element to Be found:");
					Scanner Sc4 =new Scanner (System.in);
					int k1 = Sc4.nextInt();
				     if(TreeNode.contains( root, k1)) // checks if the element is in the tree 
				     {
				    	 contains(root,k1);
				     System.out.println("The Element is Found");}
				     else {
				     System.out.println("The Element is Not Found");
					}
				   process();
			    	return;
			    }

			    case 6: {
			    	
			    	inOrder(root);
			    	process();
			        return;
			    }
			    case 7: {
			    	
			    	int k=treeHeight(root);
			    	System.out.println("The Height Of the Tree:"+k	);
			    	process();
			        return;
			    }
			    

			    case 8: {
			    	int k =NoofNodes(root);
			    			System.out.println("The No of Nodes:"+k);
			    	int k1=NoofDeletedNodes(root);
			    	System.out.println("The No of Delted Nodes:"+k1);
			        process();
			        return;
			
		}
		
		}
		
		}
	
       public static void main(String[] args) {
      process(); //calls the switch cases
	}
		}
}
