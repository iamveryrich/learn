package Week_03.lowestCommonAncestor;//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
//
// 示例 2:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
//
// Related Topics 树


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

import Week_03.lowestCommonAncestor.Solution.TreeNode;
import java.util.Stack;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class SolutionUSEDFS {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q){
      return root;
    }
    TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
    TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
    //左右都没有
    if(leftNode == null && rightNode == null){
      return null;
    }
    //都在右节点
    if(leftNode == null){
      return rightNode;
    }
    //都在左节点
    if(rightNode == null){
      return leftNode;
    }
    //左右节点各有一个
    return root;
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
    System.out.println(lowestCommonAncestor(root,root.left.left,new TreeNode(99)).val);

    //节点有一个在里面
    System.out.println(lowestCommonAncestor(root,root.left.left,new  TreeNode(100)).val);
    //节点都不在里面
    System.out.println(lowestCommonAncestor(root,new  TreeNode(99),new  TreeNode(100)).val);
  }

}
//leetcode submit region end(Prohibit modification and deletion)



