package Week_02.inorderTraversal;//给定一个二叉树，返回它的中序 遍历。
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
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表


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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        readInMid(root,values);
        return values;
    }

    public void readInMid(TreeNode root,List<Integer> values){
        if(root == null) {
            return;
        }
        readInMid(root.left,values);
        values.add(root.val);
        readInMid(root.right,values);
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
        System.out.println(inorderTraversal(node1));


    }

}
//leetcode submit region end(Prohibit modification and deletion)

