package Week_02.preorderTraversal;//给定一个二叉树，返回它的 前序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树


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

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        readPre(root,values);
        return values;
    }

    public void readPre(TreeNode root,List<Integer> values){
        if(root == null) {
            return;
        }
        values.add(root.val);
        readPre(root.left,values);
        readPre(root.right,values);
    }

    @Test
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left  = node2;
        node1.right = node3;
        node2.left = node4;
        System.out.println(preorderTraversal(node1));


    }

}
//leetcode submit region end(Prohibit modification and deletion)

