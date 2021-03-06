package Week_02.arraySort;//给你一个整数数组 nums，请你将该数组升序排列。
//
//
//
//
//
//
// 示例 1：
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
//
//
// 示例 2：
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 50000
// -50000 <= nums[i] <= 50000
//
//


import java.util.Arrays;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Bubble {
    public int[] sortArray(int[] nums) {
        int len = nums.length, lastIndex = len -1, bigggerIndex  = lastIndex,tempValue;

        while(lastIndex > 0){
            for(int i=lastIndex;i>=0;i--){
                if(nums[bigggerIndex]<nums[i]){
                    bigggerIndex = i;
                }
            }
            tempValue = nums[lastIndex];
            nums[lastIndex] = nums[bigggerIndex];
            nums[bigggerIndex] = tempValue;
            bigggerIndex = --lastIndex;
        }
       return nums;
    }



    @Test
    public void sortArray(){
        int[] nums = new int[]{4,1,2,5,3,99,100};
        nums = sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

