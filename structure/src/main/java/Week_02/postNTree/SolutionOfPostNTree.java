package Week_02.postNTree;/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


//leetcode submit region begin(Prohibit modification and deletion)
public class SolutionOfPostNTree {
    public List<Integer> postorder(Node root) {
        List<Integer> valueList = new ArrayList<>();
        if(root == null){
            return valueList;
        }
        postorderChild(root,valueList);
        return valueList;
    }
    public void postorderChild(Node root,List<Integer> valueList){
        for(Node node : root.children){
            postorderChild(node,valueList);
        }
        valueList.add(root.val);
    }

    @Test
    public void preorder(){
    }
}
//leetcode submit region end(Prohibit modification and deletion)

