package Week_03.myPow;//实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//计算堆栈超大，会出现stackoverflow
// 示例 1:
//
// 输入: 2.00000, 10
//输出: 1024.00000
//
//
// 示例 2:
//
// 输入: 2.10000, 3
//输出: 9.26100
//
//
// 示例 3:
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25
//
// 说明:
//
//
// -100.0 < x < 100.0
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
//
// Related Topics 数学 二分查找


import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class SolutionOfBasic2 {

  public double myPow(double x, int n) {
    if (x == 0) {
      return 0;
    }

    if (n == 0) {
      return 1;
    }
    if (n > 0) {
      return positive(x, n);
    }

    if (n < 0) {
      return negative(x, n);
    }

    return 1;
  }

  public double positive(double x, int n) {
    if (n == 0) {
      return 1;
    }

    if (n > 0) {
      return x * positive(x, n - 1);
    }
    return 1;
  }

  public double negative(double x, int n) {
    if (n == 0) {
      return 1;
    }

    if (n < 0) {
      return (1 / x) * negative(x, n + 1);
    }
    return 1;
  }

  @Test
  public void test() {
    System.out.println(myPow(-2, -3));
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

