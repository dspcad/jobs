public class ch4_5{
    public static void main(String args[]){
        treeNode validBST = new treeNode(20);
        validBST.left = new treeNode(17);
        validBST.right = new treeNode(27);

        validBST.left.right = new treeNode(19);
        validBST.left.left = new treeNode(10);

        validBST.right.left = new treeNode(21);
        validBST.right.right = new treeNode(29);

        if(checkValidation(validBST))
            System.out.println("Valid BST");
        else
            System.out.println("NOT Valid BST");

        treeNode invalidBST = new treeNode(20);
        invalidBST.left = new treeNode(21);
        invalidBST.right = new treeNode(27);

        invalidBST.left.right = new treeNode(19);
        invalidBST.left.left = new treeNode(10);

        invalidBST.right.left = new treeNode(21);
        invalidBST.right.right = new treeNode(29);

         if(checkValidation(invalidBST))
            System.out.println("Valid BST");
        else
            System.out.println("NOT Valid BST");



    }

    public static boolean checkValidation(treeNode root){
        if(root == null)
            return true;

        if(checkValidation(root.left) && checkValidation(root.left)){
            int left = root.left == null ? Integer.MIN_VALUE : root.left.val;
            int right = root.right == null ? Integer.MAX_VALUE : root.right.val;

            if(root.val >= left && root.val < right)
                return true;
            else
                return false;
        }

        return false;
    }
}

class treeNode{
    public int val;
    public treeNode left;
    public treeNode right;

    public treeNode(int value){
        this.val = value;
        this.left = null;
        this.right = null;
    }
}
