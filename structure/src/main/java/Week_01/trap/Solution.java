package Week_01.trap;//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针
import java.util.Stack;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int trap(int[] height) {
        int area = 0,topIndex = 0,midEleIndex = 0,leftEleIndex,rightEleIndex;
        if(height == null || height.length == 0){
            return area;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0,j=height.length;i<j;i++){
            //取出栈顶元素
            //如果栈中无元素(可以理解为没有桶底)/栈顶元素大于当前元素（可以理解为没有桶盖）（不能接住雨水），当前元素进栈,继续判断下一个数组元素；
            //如果栈顶元素小于当前元素（能接住雨水）
            //          1，取出栈顶元素=桶左边元素，当前元素=桶右边元素,将桶左边元素 赋值给 中间元素；
            //          2，计算桶左边元素与桶右边元素组成的桶的盛水量
            //                2.1计算桶的高度（左、右两边取小者）-中间元素的高度；
            //                2.2计算桶的宽度 （右元素索引-左元素索引-1）
            //                2.3累加计算桶的体积 area = area+ h * w;
            //          3，继续取栈顶元素进入下次判断
            //          4, 栈中再无元素小于当前元素后，将当前元素/桶右边元素放入栈

            if(stack.size() == 0 || height[stack.peek()] > height[i]){
                stack.push(i);
                continue;
            }
            while(stack.size() > 0){
                leftEleIndex = stack.peek();
                rightEleIndex = i;
                int h = getSmaller(height[leftEleIndex] ,height[rightEleIndex]) - height[midEleIndex];
                int w = rightEleIndex - leftEleIndex -1 ;
                area = area + h*w;
                if(height[leftEleIndex] > height[rightEleIndex]){
                    midEleIndex = rightEleIndex;
                    break;
                }else{
                    midEleIndex = leftEleIndex;
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return area;
    }

    public int getSmaller(int ele1,int ele2){
        return ele1 < ele2?ele1:ele2;
    }

    @Test
    public void testTrap(){
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int area = trap(height);
        System.out.println(area);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

