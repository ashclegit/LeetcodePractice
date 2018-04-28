import java.util.Stack;


public class vaildBST {


    private static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val)
        {
            this.val = val;
        }
    }

     //recursion method
    /*public boolean isValidBST(TreeNode node)
    {
        return isValidBST(node,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long min,long max)
    {
        if (node ==  null) return true;
        else if(node.val >= max || node.val <= min)
        {
            return false;
        }
        else
        {
            return isValidBST(node.left,min,node.val) && isValidBST(node.right,node.val,max);
        }
    }*/

    //Iterative version
    public boolean isValidBST(TreeNode node)
    {
        Stack<TreeNode> mystack = new Stack<>();

        TreeNode cur = node;
        TreeNode pre = null;

        while(!mystack.isEmpty() || cur != null)
        {
            if(cur != null)
            {
                mystack.push(cur);
                cur = cur.left;
            }
            else
            {
                TreeNode p = mystack.pop();
                if(pre != null && p.val <= pre.val)
                {
                    return false;
                }
                pre = p;
                cur = p.right;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        TreeNode Node = new TreeNode(1);
        Node.left = new TreeNode(2);
        Node.right = new TreeNode(5);
        vaildBST vb = new vaildBST();
        System.out.println(vb.isValidBST(Node));
    }

}
