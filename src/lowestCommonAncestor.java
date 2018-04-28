import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class lowestCommonAncestor {

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

    public TreeNode findLCA(TreeNode root,TreeNode p,TreeNode q)
    {
        //recursion method
        /*if(root == null || p == root || q == root)
        {
            return root;
        }

        TreeNode left = findLCA(root.left,p,q);
        TreeNode right = findLCA(root.right,p,q);

        if(left == null)
        {
            return right;
        }
        else if(right == null)
        {
            return left;
        }
        else
        {
            return right;
        }*/

        //Iterative method

        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        Stack<TreeNode> mystack = new Stack<>();

        parent.put(root,null);
        mystack.push(root);

        while(!parent.containsKey(p) || !parent.containsKey(q))
        {
            TreeNode cur = mystack.pop();
            if(cur.left != null)
            {
                parent.put(cur.left,cur);
                mystack.push(cur.left);
            }
            if(cur.right != null)
            {
                parent.put(cur.right,cur);
                mystack.push(cur.right);
            }
        }

        Set<TreeNode> myset = new HashSet<>();
        while(p != null)
        {
            myset.add(p);
            p = parent.get(p);
        }
        while(!myset.contains(q))
        {
            q = parent.get(q);
        }
        return q;
    }

    public static void main(String[] args) {

        lowestCommonAncestor lca = new lowestCommonAncestor();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        TreeNode res = lca.findLCA(root,root.left.right,root.left);
        System.out.println(res.val);
    }
}
