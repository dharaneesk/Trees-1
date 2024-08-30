
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length == 0) return null;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex =-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                rootIndex = i;
                break;
            }
        }

        int [] inLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int [] inRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        int [] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length+1);
        int [] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, preorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}