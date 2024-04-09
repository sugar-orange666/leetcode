package com.demo.no08;

/**
 * 836. 矩形重叠
 *
 * @Date：2024/4/9 14:19
 * @Description
 */
public class No836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]))
                && (Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }
}
