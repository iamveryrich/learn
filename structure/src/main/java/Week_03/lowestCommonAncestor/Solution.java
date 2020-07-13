package Week_03.lowestCommonAncestor;
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
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

import java.util.Stack;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    //遍历root，找到p 和 q的所有父级节点
    Stack<TreeNode> parentsOfP = new Stack<>();

    Stack<TreeNode> parentsOfQ = new Stack<>();
    findParent(root,p,parentsOfP);
    findParent(root,q,parentsOfQ);
    //遍历p 和 q的父级节点，找到最后一个相同的node，即为最近公共祖先
    TreeNode parentNode = findLowestCommon(parentsOfP,parentsOfQ);
    return parentNode;
  }

  private boolean findParent(TreeNode root, TreeNode p, Stack<TreeNode> parentsOfP) {
    boolean ifFind = false;
    if(root == null){
      return false;
    }

    //中序遍历
    ifFind = findParent(root.left,p,parentsOfP);
    if(ifFind){
      parentsOfP.push(root);
      return true;
    }
    if(root.val == p.val){
      parentsOfP.push(root);
      return true;
    }

    ifFind = findParent(root.right,p,parentsOfP);
    if(ifFind){
      parentsOfP.push(root);
      return true;
    }
    return  ifFind;
  }


  private TreeNode findLowestCommon(Stack<TreeNode> parentsOfP, Stack<TreeNode> parentsOfQ) {
    TreeNode parentNodeOfP = null,parentNodeOfQ  = null ,lowestCommon = null;
    while(!parentsOfP.empty() && !parentsOfQ.empty()){
      parentNodeOfP =  parentsOfP.pop();
      parentNodeOfQ =  parentsOfQ.pop();
      if(parentNodeOfP.val != parentNodeOfQ.val){
        break;
      }else{
        lowestCommon = parentNodeOfP;
      }
    }
    return lowestCommon;
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
    //节点都在里面
    System.out.println(lowestCommonAncestor(root,root.left.left,root.left.right).val);
    //节点有一个在里面
    System.out.println(lowestCommonAncestor(root,root.left.left,new TreeNode(100)).val);
    //节点都不在里面
    System.out.println(lowestCommonAncestor(root,new TreeNode(99),new TreeNode(100)).val);
  }

}
//leetcode submit region end(Prohibit modification and deletion)



