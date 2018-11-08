This is a Binary search tree class with lazy deletion that has TreeNode as nested class in Java
The program does the following operations: 
 Insert
   Insert a new element to a leaf node. 
 Delete
   Does not remove the element from the tree. It just mark the element as deleted.
 findMin
  Return the minimum element, but if it is marked deleted return appropriate minimum
 findMax
   Return the maximum element, but if it is marked deleted return appropriate maximum
 Contains
  Return true if a particular element is in the tree and is not marked as deleted
 In order tree Traversal
  Print the in order traversal of the tree. Indicating with * symbol for elements that are marked deleted
 Height ( returns the height of the tree)
  Return the height of the tree, count all the elements even the ones that are marked as deleted
 No Of nodes ( returns number of nodes)
  Return size of the tree, count all the elements even the ones that are marked as deleted. And also return the number of deleted elements.

Sample Run: 
1. Insert 2. Delete 3. Find Max 4. Find Min 5. Contains 6. In order Tree Traversal 7. Height 8. No Of Nodes

Your Option: 1 Enter element: 11 Element inserted
Your Option: 1 Enter Element: 36 Element Inserted

Your Option: 6 In order Traversal: 11 36
