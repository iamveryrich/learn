package Week_03.solveNQueens;//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
//
//
//
// 提示：
//
//
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ）
//
// Related Topics 回溯算法


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class SolutionOfSelf {

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new LinkedList<>();
    if(n <= 0){
      return null;
    }
    Set<Integer> colSet = new HashSet<Integer>();
    Set<Integer> sumSet = new HashSet<Integer>();
    Set<Integer> diffSet = new HashSet<Integer>();
    List<String> pointList = new LinkedList<>();
    boolean ifFind = generateNextPoint(1,n,colSet,sumSet,diffSet,pointList,result);
    return result;
  }

  /* 关键点：
      若使N*N个格子内，放下N个皇后，则每行必有一个皇后点；
      依据第一个关键点，第一个皇后子必在第一行，第二个皇后子必在第二行......
  计算思路：
      1，以第一行第i个单元格为第1个皇后的位置；
      2，计算出第1个皇后可以吃掉的位置的特征；
      3，计算第二行第？个单元格为第2个皇后的位置；不能在第2步的步骤；
      4，按第3步的思路递归计算直接第N个皇后子；
  递归的参数:
      计算到了第几个：index
      当前可以被吃掉的位置：
          colSet 纵线数组;
          sumSet 上斜线和数组；
          arrSet 之前的皇后节点；

  结束递归的条件：
     计算到了第N个皇后；*/

  private boolean generateNextPoint(int index, int num, Set<Integer> colSet, Set<Integer> sumSet, Set<Integer> diffSet,List<String> pointList, List<List<String>> result) {
    if(index > num){
      result.add(new LinkedList<>(pointList));
      return true;
    }
    StringBuffer tempStr = new StringBuffer();
    boolean ifFind = false,ifFindNext = false;
    for(int i=1,j=num;i<=j;i++){
      // 判断是否是可吃子;
      //    入参：子一（i,j） 子二(m,n)
      //    返回值：可吃-true,不可吃-false
      //    判断依据：
      //      1,是否同一横线: i == m
      //      2,是否同一纵线: j == n
      //      3,是否同一下斜线：(m-i)/(n-j) = 1 ==> m-i = n-j ==> m-n = i-j
      //      4,是否同一上斜线: m+n = i+j

      //判断其是否符合条件
      if(colSet.contains(i)){
        tempStr.append(".");
        continue;
      }
      if(sumSet.contains(index+i)){
        tempStr.append(".");
        continue;
      }
      if(diffSet.contains(index-i)){
        tempStr.append(".");
        continue;
      }
      //发现了符合条件的数据
      ifFind = true;
      tempStr.append("Q");
      for(int m=i+1;m<=num;m++){
        tempStr.append(".");
      }
      pointList.add(tempStr.toString());
      colSet.add(i);
      sumSet.add(index+i);
      diffSet.add(index-i);
      ifFindNext = generateNextPoint(index+1,num,colSet,sumSet,diffSet,pointList,result);

      //如果获得了错误,进行回溯
      pointList.remove(index-1);
      colSet.remove(i);
      sumSet.remove(index+i);
      diffSet.remove(index-i);
      tempStr.delete(i-1,num);
      tempStr.append(".");
    }
    return ifFind && ifFindNext;
  }

  @Test
  public void test() {
    System.out.println(solveNQueens(4));
  }

}
//leetcode submit region end(Prohibit modification and deletion)

