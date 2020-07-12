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
public class SolutionOfBinary {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> resultList = new LinkedList<>();
    //生成、并遍历n个二进制串
    int len = nums.length;
    int minNum = (int)Math.pow(2,len);
    String binaryStr;
    char[] charArr;
    List<Integer> combin;
    for(int i=minNum,j=minNum*2;i<j;i++){
      //存储组合的list
      combin = new ArrayList<>();
      //用数组中元素的索引号代表的二进制串的组合
      binaryStr = Integer.toBinaryString(i).substring(1);
      //二进制串的组合中的字符数组
      charArr = binaryStr.toCharArray();

      //根据charArr中的1元素组装数据
      for(int m=0,n=charArr.length;m<n;m++){
        if(charArr[m] == '1'){
          combin.add(nums[m]);
        }
      }
      resultList.add(combin);
    }
    return resultList;
  }

  @Test
  public void test() {
    System.out.println(subsets(new int[]{1,2,3}));
  }

  @Test
  public void testOther() {

  }

}
//leetcode submit region end(Prohibit modification and deletion)

