import java.util.LinkedList;
import java.util.Queue;

public class stringToTree {

    class TreeNode
    {
        TreeNode right;
        TreeNode left;
        int val;
        public TreeNode(int val)
        {
            this.val = val;
        }
    }

    public void levelOrder(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int q = queue.size();
            for(int i=0;i<q;i++)
            {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if(node.left != null)
                {
                    queue.add(node.left);
                }
                if(node.right != null)
                {
                    queue.add(node.right);
                }
            }
            System.out.println("");
        }
    }

    public TreeNode str2Tree(String tree)
    {

        if(tree == null || tree.length() == 0)
        {
            return null;
        }

        int parseLen = tree.indexOf("(");
        int val = parseLen == -1 ? Integer.parseInt(tree) : Integer.parseInt(tree.substring(0,tree.indexOf("(")));
        TreeNode root = new TreeNode(val);
        if(parseLen == -1)
        {
            return root;
        }
        int start = parseLen;
        int parenCount = 0;
        for(int i=parseLen;i<tree.length();i++)
        {
            if(tree.charAt(i) == '(') parenCount++;
            else if(tree.charAt(i) == ')') parenCount--;
            if(parenCount == 0 && start == parseLen)
            {
                root.left = str2Tree(tree.substring(start+1,i));
                start = i+1;
            }
            else if(parenCount == 0)
            {
                root.right = str2Tree(tree.substring(start+1,i));
            }
        }
        return root;
    }

    public static void main(String[] args) {

        stringToTree st = new stringToTree();
        String treeString = "4(2(3)(4))(6(5))";
        TreeNode tree = st.str2Tree(treeString);
        st.levelOrder(tree);
    }
}
