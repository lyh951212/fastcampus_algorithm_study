package leetcode_450;

/**
 *   Runtime : 0 ms
 *   Memory : 49.1 MB
 */

// Definition for a binary tree node.
class TreeNodeMoon {
      int val;
      TreeNodeMoon left;
      TreeNodeMoon right;
      TreeNodeMoon() {}
      TreeNodeMoon(int val) { this.val = val; }
      TreeNodeMoon(int val, TreeNodeMoon left, TreeNodeMoon right) {
         this.val = val;
          this.left = left;
         this.right = right;
      }
 }
public class moon_450 {
    public static void main(String[] args) {

    }
    public TreeNodeMoon deleteNode(TreeNodeMoon root, int key) {
        // root가 null이면 null 반환
        if(root==null) return null;

        // key 값이 root 값보다 작다면 left로 이동
        if(key < root.val) root.left = deleteNode(root.left, key);
            // key 값이 root 값보다 크다면 right로 이동
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else {
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;

            // right 탐색을 위한 TreeNode
            TreeNodeMoon node = root.right;
            // 최솟값
            int value = node.val;

            // 최솟값을 탐색하기 위해 반복
            while(node.left!=null){
                value = node.left.val;
                node = node.left;
            }

            // 탐색된 최솟값을 root의 값으로 대체
            root.val = value;

            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }
}
