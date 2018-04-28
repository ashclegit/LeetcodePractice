import java.util.LinkedList;
import java.util.Queue;

public class serializeAndDeserializeBT {

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

    public static String serialize(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        queue.add(root);

        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();

            if(temp == null)
            {
                sb.append("n ");
                continue;
            }

            sb.append(temp.val + " ");
            queue.add(temp.left);
            queue.add(temp.right);
        }

        return sb.toString();
    }

    public static TreeNode deserialize(String data)
    {
        if(data == null) return null;
        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        for(int i=1;i<values.length;i++)
        {
            TreeNode parent = queue.poll();

            if(!values[i].equals("n"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }

            if(!values[++i].equals("n"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }

        }
        return root;
    }



    public static void main(String[] args) {

        serializeAndDeserializeBT sd = new serializeAndDeserializeBT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        //root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        String nodes = sd.serialize(root);
        TreeNode tree = deserialize(nodes);
    }
}
