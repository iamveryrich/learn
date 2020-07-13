package Week_03.subSets;//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class SolutionOfRecur {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> resultList = new LinkedList<>();
    resultList.add(new ArrayList<>());
    for(int i : nums){
      for(int m=0,n=resultList.size();m<n;m++){
        List<Integer>  oldList = resultList.get(m);
        List<Integer> newList = new ArrayList<Integer>(oldList);
        newList.add(i);
        resultList.add(newList);
      }
    }
    resultList.remove(0);
    return resultList;
  }

  @Test
  public void test() {
    System.out.println(subsets(new int[]{1,2,3}));
  }

}
//leetcode submit region end(Prohibit modification and deletion)
