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
public class SolutionOfSort {
    public int[] sortArray(int[] nums) {
        if(nums == null){
            return new int[0];
        }
        return sortArray(nums,nums.length);
    }

    public int[] sortArray(int[] nums,int len) {
        //待排序数组有效性判断：数组为空、长度为0、长度为1
        if(len <= 1){
            return nums;
        }

        //将nums分为两组nums1 、midValue、nums2，nums1中的元素都小于midValue,nums2中的元素都大于midValue
        //取第一个元素为midValue
        //声明两个与nums等长的数组，存储nums1 和 nums2中的数据
        int[] nums1 = new int[len];
        int[] nums2 = new int[len];
        int midValue = nums[0];
        int midIndex = 0,smallIndex = -1,bigIndex = -1;
        for(int i=1;i<len;i++){
            if(nums[i] >= nums[0]){
                nums2[++bigIndex] = nums[i];
            }else{
                nums1[++smallIndex] = nums[i];
            }
        }
        midIndex = smallIndex + 1;
        //将nums1,nums2分别排序
        nums1 = sortArray(nums1,smallIndex+1);
        nums2 = sortArray(nums2,bigIndex+1);

        //合并nums1 、midValue、nums2并返回
        for(int i=0;i<len;i++){
            if(i<midIndex){
                nums[i] = nums1[i] ;
            }else if(i == midIndex){
                nums[midIndex] = midValue;
            }else{
                nums[i] = nums2[i-midIndex-1] ;
            }
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

