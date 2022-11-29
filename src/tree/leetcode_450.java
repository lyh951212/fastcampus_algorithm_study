package tree;

import java.util.ArrayDeque;
import java.util.Queue;

//Memory
//49.8 MB
//Runtime
//0 ms
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
      }
 }
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if (key > root.val)
            root.right = deleteNode(root.right, key);
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                root.val = getMinNode(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }

        return root;
    }

    public int getMinNode(TreeNode node)
    {
        if(node == null)
            return -1;

        int minVal = 0;
        while(node != null)
        {
            minVal = node.val;
            node = node.left;
        }
        return minVal;
    }

    public void printTreeByLevel(TreeNode root)
    {
        if(root == null)
            return;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode pollNode = q.poll();
            System.out.println(pollNode.val);
            if(pollNode.left != null)
                q.add(pollNode.left);
            if(pollNode.right != null)
                q.add(pollNode.right);
        }


    }
}

public class leetcode_450 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution s = new Solution();
        s.deleteNode(root,3);
        s.printTreeByLevel(root);
    }
}
