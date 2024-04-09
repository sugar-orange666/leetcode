package com.demo.no01;

/**
 *
 * 162. 寻找峰值
 *
 * @Date：2024/4/9 11:31
 * @Description
 */
public class No162 {
    //方法一 是o(n)的时间复杂度
    //也可以查找出最大的元素，直接返回最大元素所在的位置
//    public int findPeakElement(int[] nums) {
//        if (nums.length <= 1) {
//            return 0;
//        }
//        if (nums.length == 2) {
//            return nums[0] > nums[1] ? 0 : 1;
//        }
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
//                return i;
//            }
//        }
//        return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
//
//    }

    //通过二分查找，忘最大的一边找
    //因为左边和右边都是负无穷，假如大的方向是右边，则num[mid]<num[mid+1] num[mid+1]>负无穷 所以往大的一边找肯定可以找到
    public int findPeakElement(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }


    public static void main(String[] args) {
        No162 no162 = new No162();
        int res = no162.findPeakElement(new int[]{1, 7, 2, 5, 4, 2});
        System.out.println(res);
    }
}
