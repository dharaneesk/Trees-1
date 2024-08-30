class Solution {

    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }

    public boolean helper(TreeNode root){

        if(root == null) return true; 

        boolean left = helper(root.left);
        if(prev!=null && root.val <= prev.val) return false;
        prev = root;
        System.out.println(root.val);
        boolean right = true;
        if(left){
            right = helper(root.right);
        }
        
        return left && right;
    }
}