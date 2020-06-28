package Week_01.merge;//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明:
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例:
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6]
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while(m>0 || n>0){
            if(m > 0 && n ==0){
                nums1[m+n-1] = nums1[m-1];
                m--;
                continue;
            }
            if(n > 0 && m ==0){
                nums1[m+n-1] = nums2[m-1];
                m--;
                continue;
            }
            if(nums1[m-1] > nums1[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums1[n-1];
                n--;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
