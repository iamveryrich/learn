package Week_01.removeDuplicates;

//给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//
//
//
// 示例 1:
//
// 给定数组 nums = [1,1,2],
//
//函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
//
//你不需要考虑数组中超出新长度后面的元素。
//
// 示例 2:
//
// 给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//你不需要考虑数组中超出新长度后面的元素。
//
//
//
//
// 说明:
//
// 为什么返回数值是整数，但输出的答案是数组呢?
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
// 你可以想象内部操作如下:
//
// // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//
// Related Topics 数组 双指针


//空间复杂度O(1) 时间复杂度O(n)
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        //特殊情况处理
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }

        //最后一个不重复元素
        int lastValue = nums[0];
        //最后一个不重复元素在新数组中的位置
        int posOfLastValue = 0;
        //遍历数组nums：
        for(int j=1;j<nums.length;j++){
            // 若下个元素与上个元素相等，则lastValue 与 posOfLastValue都不变,继续遍历
            if(nums[j] == lastValue){
                continue;
            }else{
                // 若下个元素与上个元素不相等:
                //          则lastValue为下个元素的值
                //          posOfLastValue 加 1
                //          nums[posOfLastValue]的值设置为nums[j]
                lastValue = nums[j];
                nums[++posOfLastValue] = nums[j];
            }
        }
        return ++posOfLastValue;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

