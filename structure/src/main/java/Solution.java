//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {

  }

  public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

  @Test
  public void test() {
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(8);
    root.right = new TreeNode(11);
    root.left.left = new TreeNode(7);
    root.left.right = new TreeNode(9);
  }

}
//leetcode submit region end(Prohibit modification and deletion)



