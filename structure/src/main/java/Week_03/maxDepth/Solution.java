package Week_03.maxDepth;//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索


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

import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {

  public int maxDepth(TreeNode root) {
      return recur(root);
  }

  public int recur(TreeNode node) {
    int level = 0;
    if (node == null) {
      return level;
    }else{
      ++level;
    }
    int leftLen = recur(node.left);
    int rightLen = recur(node.right);
    level = level + (leftLen>rightLen ? leftLen : rightLen);
    return level;
  }



  @Test
  public void test() {
    TreeNode node = new TreeNode(20);
    node.left = new TreeNode(10);
    node.left.left = new TreeNode(5);
    node.left.right = new TreeNode(12);
    node.right = new TreeNode(30);
    System.out.println(maxDepth(node));
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

