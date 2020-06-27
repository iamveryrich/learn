package Week_01.rotate;
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length ==0 || k ==0 || k%nums.length == 0){
            return;
        }
        //nums.length=5 nums={1,2,3,4,5} k=2
        //moveStep=2;
        int moveStep = k%nums.length;
        int[] temp = new int[moveStep];
        //新建长度为K的数组，存储被移出原数组的元素
        //temp={4,5}
        for(int i=0;i<moveStep;i++){
            temp[i] = nums[nums.length - moveStep+i];
        }

        //将移出后剩余的元素的索引分别增加movesStep
        for(int i=nums.length-moveStep-1;i>=0;i--){
            nums[i+moveStep]  = nums[i];
        }
        //将移出的元素补充到原数组的前端
        for(int i=0;i<moveStep;i++){
            nums[i] = temp[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

