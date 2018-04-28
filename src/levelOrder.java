import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class levelOrder {


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



    public List<List<Integer>> printLevelOrder(TreeNode root)
    {
        Queue<TreeNode> myqueue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        myqueue.add(root);

        while(!myqueue.isEmpty())
        {
            int qlen = myqueue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i=0;i<qlen;i++)
            {
                TreeNode  node = myqueue.poll();
                tempList.add(node.val);
                if(node.left != null)
                {
                    myqueue.add(node.left);
                }
                if(node.right != null) {
                    myqueue.add(node.right);
                }
            }
            res.add(tempList);
        }
        return res;
    }

    public static void main(String[] args) {

        levelOrder lv = new levelOrder();
        TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(lv.printLevelOrder(root));
    }
}
