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
public class DoubleBubble {
    public int[] sortArray(int[] nums) {
        int len = nums.length, lastIndex = len -1, firstIndex = 0,
            bigggerIndex  = lastIndex,smallerIndex = firstIndex,
            tempBiggerValue,tempSmallValue;

        while(lastIndex > firstIndex){
            for(int i=lastIndex;i>=firstIndex;i--){
                if(nums[bigggerIndex]<nums[i]){
                    bigggerIndex = i;
                }
                if(nums[smallerIndex]>nums[i]){
                    smallerIndex = i;
                }
            }
            tempBiggerValue = nums[lastIndex];
            tempSmallValue = nums[firstIndex];

            if(bigggerIndex != lastIndex){
                nums[lastIndex] = nums[bigggerIndex];
            }
            if(smallerIndex != firstIndex){
                if(lastIndex != smallerIndex){
                    nums[firstIndex] = nums[smallerIndex];
                }else{
                    nums[firstIndex] = tempBiggerValue;
                }
            }
            nums[bigggerIndex] = tempBiggerValue;
            nums[smallerIndex] = tempSmallValue;

            bigggerIndex = --lastIndex;
            smallerIndex = ++firstIndex;
        }
       return nums;
    }



    @Test
    public void sortArray(){
        int[] nums = new int[]{1,1,0,0};
        nums = sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

