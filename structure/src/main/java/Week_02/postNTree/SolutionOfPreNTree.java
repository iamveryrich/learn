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

//leetcode submit region begin(Prohibit modification and deletion)
public class SolutionOfPreNTree {
    public List<Integer> preorder(Node root) {
        List<Integer> valueList = new ArrayList<>();
        if(root == null){
            return valueList;
        }
        preorderChild(root,valueList);
        return valueList;
    }
    public void preorderChild(Node root,List<Integer> valueList){
        valueList.add(root.val);
        for(Node node : root.children){
            preorderChild(node,valueList);
        }
    }

    @Test
    public void preorder(){
    }
}
//leetcode submit region end(Prohibit modification and deletion)

