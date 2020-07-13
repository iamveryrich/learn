package Week_03.isValidBST;
//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
// 假设一个二叉搜索树具有如下特征：
//
//
// 节点的左子树只包含小于当前节点的数。
// 节点的右子树只包含大于当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
// 示例 1:
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
//
//
// 示例 2:
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
//
// Related Topics 树 深度优先搜索

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */

//利用二叉搜索树的中序遍历出来的结果是递增的
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {

  private  Integer lastValue ;
  public boolean isValidBST(TreeNode root) {
    if(root == null){
      return true;
    }
    if(!isValidBST(root.left)){
      return false;
    }
    if(!invalid(root.val)){
      return false;
    }
    if(!isValidBST(root.right)){
      return false;
    }
    return true;
  }

  public boolean invalid(int value){
    if(lastValue == null){
      lastValue = value;
      return true;
    }
    boolean valid = (value > lastValue);
    lastValue = value;
    return valid;
  }

  @Test
  public void test() {
    TreeNode node = new TreeNode(20);
    node.left = new TreeNode(10);
    node.left.left = new TreeNode(5);
    node.left.right = new TreeNode(12);
    node.right = new TreeNode(30);
    System.out.println(isValidBST(node));
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
